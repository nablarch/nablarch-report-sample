package please.change.me.sample.ss11AA;

import please.change.me.common.authentication.AuthenticationFailedException;
import please.change.me.common.authentication.PasswordExpiredException;
import please.change.me.common.authentication.UserIdLockedException;
import please.change.me.common.authentication.AuthenticationUtil;

import nablarch.core.date.BusinessDateUtil;
import nablarch.core.db.statement.SqlPStatement;
import nablarch.core.db.statement.SqlResultSet;
import nablarch.core.db.support.DbAccessSupport;
import nablarch.core.message.ApplicationException;
import nablarch.core.message.MessageLevel;
import nablarch.core.message.MessageUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

/**
 * ログイン画面のアクションクラス。
 *
 * @author Masayuki Fujikuma
 */
public class W11AA01Action extends DbAccessSupport {

    /**
     * ログイン画面を表示する。
     *
     * @param request リクエストコンテキスト
     * @param context HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    public HttpResponse doRW11AA0101(HttpRequest request,
            ExecutionContext context) {
        // セッション初期化
        context.invalidateSession();
        return new HttpResponse("/ss11AA/W11AA0101.jsp");
    }

    /**
     * ログイン画面の「ログイン」イベントの処理を行う
     *
     * @param request リクエストコンテキスト
     * @param context HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    @OnError(type = ApplicationException.class,
            path = "/ss11AA/W11AA0101.jsp") // セッションの破棄は行わないため、ログイン画面初期表示のリクエストにはフォワードしない。
    public HttpResponse doRW11AA0102(HttpRequest request,
            ExecutionContext context) {

        W11AA01Form form = W11AA01Form.validate(request, "login");

        // ユーザ情報の存在精査
        SqlResultSet result = selectSystemAccount(form.getLoginId());
        if (result.isEmpty()) {
            // ログインIDに紐付くユーザ情報が存在しなかった場合の処理(MSG00007)
            throw new ApplicationException(MessageUtil.createMessage(
                    MessageLevel.ERROR, "MSG00007"));
        }

        String userId = result.get(0).getString("USER_ID");

        try {
            // 認証
            AuthenticationUtil.authenticate(userId, form.getPassword());
        } catch (AuthenticationFailedException e) {
            // 認証に失敗した場合の処理(MSG00007)
            throw new ApplicationException(MessageUtil.createMessage(
                    MessageLevel.ERROR, "MSG00007"));

        } catch (UserIdLockedException e) {
            // ユーザIDがロックされていた場合の処理(MSG00008)
            throw new ApplicationException(MessageUtil.createMessage(
                    MessageLevel.ERROR, "MSG00008"));

        } catch (PasswordExpiredException e) {
            // パスワードの有効期限が切れていた場合の処理(MSG00009)
            throw new ApplicationException(MessageUtil.createMessage(
                    MessageLevel.ERROR, "MSG00009"));
        }

        // 認証OKの場合、メニュー画面に遷移する。
        context.invalidateSession();
        context.setSessionScopedVar("user.id", userId);
        context.setSessionScopedVar("commonHeaderLoginUserName",
                result.get(0).getString("KANJI_NAME"));
        context.setSessionScopedVar("commonHeaderLoginDate",
                BusinessDateUtil.getDate());
        return new HttpResponse(303, "redirect:///action/ss11AB/W11AB01Action/RW11AB0101");
    }
    
    /**
     * システムアカウントの検索を実行する。<br>
     *
     * @param loginId 検索条件
     * @return 検索結果。
     */
    private SqlResultSet selectSystemAccount(String loginId) {
        SqlPStatement statement = getSqlPStatement("SELECT_SYSTEM_ACCOUNT");
        statement.setString(1, loginId);
        return statement.retrieve();
    }
}
