package please.change.me.sample.ss11AC;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import nablarch.common.code.CodeUtil;
import nablarch.common.web.WebUtil;
import nablarch.common.web.download.StreamResponse;
import nablarch.core.ThreadContext;
import nablarch.core.db.statement.SqlResultSet;
import nablarch.core.db.statement.SqlRow;
import nablarch.core.db.support.DbAccessSupport;
import nablarch.core.db.support.TooManyResultException;
import nablarch.core.message.ApplicationException;
import nablarch.core.message.MessageLevel;
import nablarch.core.message.MessageUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;
import nablarch.integration.report.ReportContext;
import nablarch.integration.report.ReportManager;
import nablarch.integration.report.ReportParam;
import nablarch.integration.report.datasource.SqlResultSetDataSource;
import please.change.me.sample.ss11.component.CM311AC1Component;

/**
 * ユーザ検索機能のアクションクラス
 * 
 * @author Naoki Tamura
 */
public class W11AC01Action extends DbAccessSupport {
    /**
     * ユーザ一覧照会画面を表示する。<br/>
     * 
     * @param req
     *            リクエストコンテキスト
     * @param ctx
     *            HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    public HttpResponse doRW11AC0101(HttpRequest req, ExecutionContext ctx) {
        CM311AC1Component component = new CM311AC1Component();
        SqlResultSet ugroupList = component.getUserGroups();
        ctx.setRequestScopedVar("ugroupList", ugroupList);
        return new HttpResponse("/ss11AC/W11AC0101.jsp");
    }

    /**
     * ユーザ一覧照会結果を表示する。<br/>
     * 
     * @param req
     *            リクエストコンテキスト
     * @param ctx
     *            HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    @OnError(type = ApplicationException.class, path = "forward://RW11AC0101")
    public HttpResponse doRW11AC0102(HttpRequest req, ExecutionContext ctx) {

        CM311AC1Component component = new CM311AC1Component();
        SqlResultSet ugroupList = component.getUserGroups();
        ctx.setRequestScopedVar("ugroupList", ugroupList); // 部署一覧

        // 検索条件入力チェック
        W11AC01Form form = W11AC01Form.validate(req, "search");

        ctx.setRequestScopedVar("11AC_W11AC01", form);

        // 検索実行
        SqlResultSet searchResult;
        try {
            searchResult = selectByCondition(form);
        } catch (TooManyResultException e) {
            throw new ApplicationException(MessageUtil.createMessage(
                    MessageLevel.ERROR, "MSG00035", e.getMaxResultCount()));
        }

        if (searchResult.isEmpty()) {
            WebUtil.notifyMessages(ctx,
                    MessageUtil.createMessage(MessageLevel.ERROR, "MSG00044"));
        }

        // 検索結果をリクエストスコープに設定
        ctx.setRequestScopedVar("searchResult", searchResult);
        ctx.setRequestScopedVar("resultCount", form.getResultCount());
        ctx.setRequestScopedVar("searchResultSize", searchResult.size());

        return new HttpResponse("/ss11AC/W11AC0101.jsp");
    }

    /**
     * ユーザ情報詳細を表示する。<br/>
     * 
     * @param req
     *            リクエストコンテキスト
     * @param ctx
     *            HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    @OnError(type = ApplicationException.class, path = "forward://RW11AC0102")
    public HttpResponse doRW11AC0103(HttpRequest req, ExecutionContext ctx) {

        // 引継いだユーザIDの取得
        W11AC01Form form = W11AC01Form.validate(req, "selectUserInfo");
        String userId = form.getUserId();

        // 検索実行
        CM311AC1Component component = new CM311AC1Component();
        SqlRow userDetailedInfo = component.selectDetailedUserInfo(userId);

        // 対象ユーザの詳細情報が取得できなければエラー
        if (userDetailedInfo == null) {
            throw new ApplicationException(MessageUtil.createMessage(
                    MessageLevel.ERROR, "MSG00029"));
        }

        // 検索結果をリクエストスコープに設定。認可単位は1ユーザに0～複数紐づく。
        ctx.setRequestScopedVar("userDetailedInfo", userDetailedInfo);
        ctx.setRequestScopedVar("ugroupInfo", component.selectUgroup(userId)
                .get(0));
        ctx.setRequestScopedVar("permissionUnitInfo",
                component.selectPermissionUnit(userId));

        return new HttpResponse("/ss11AC/W11AC0102.jsp");
    }

    /**
     * ユーザ一覧照会結果をPDFで出力する.<br />
     * 
     * @param req
     *            リクエストコンテキスト
     * @param ctx
     *            HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    @OnError(type = ApplicationException.class, path = "forward://RW11AC0101")
    public HttpResponse doRW11AC0105(HttpRequest req, ExecutionContext ctx) {

        CM311AC1Component component = new CM311AC1Component();
        SqlResultSet ugroupList = component.getUserGroups();
        ctx.setRequestScopedVar("ugroupList", ugroupList); // 部署一覧

        W11AC01Form form = W11AC01Form.validate(req, "search");

        // 検索実行
        SqlResultSet searchResult;
        try {

            // 検索結果取得件数を検索結果上限件数に設定
            form.setMax(form.getMaxResultCount());
            searchResult = selectByCondition(form);
        } catch (TooManyResultException e) {
            throw new ApplicationException(MessageUtil.createMessage(
                    MessageLevel.ERROR, "MSG00035", e.getMaxResultCount()));
        }

        for (SqlRow record : searchResult) {
            // データの加工
            setUserDetailedInfoForReport(record);
        }

        // 帳票出力処理
        Map<String, Object> params = new HashMap<String, Object>();
        String loginId = ThreadContext.getUserId();
        params.put("execLoginId", loginId);

        ReportParam rp;
        if (!searchResult.isEmpty()) {
            rp = new ReportParam(params, new SqlResultSetDataSource(
                    searchResult));
        } else {
            rp = new ReportParam(params);
        }

        ReportContext rctx = new ReportContext("R001");
        rctx.addReportParam(rp);

        File tmpPdf = ReportManager.createReport(rctx);

        StreamResponse response = new StreamResponse(tmpPdf, true);
        response.setContentType("application/octet-stream");
        response.setContentDisposition("ユーザ情報一覧.pdf");

        return response;
    }

    /**
     * 取得したユーザー情報を元に帳票出力用に加工・セットする。
     * 
     * @param record
     *            ユーザー情報
     */
    void setUserDetailedInfoForReport(SqlRow record) {
        String group = String.format("%s:%s", record.getString("ugroupId"),
                record.getString("ugroupName"));
        String extensionNumber = String.format("%s - %s",
                record.getString("extensionNumberBuilding"),
                record.getString("extensionNumberPersonal"));
        String userIdLockedName = CodeUtil.getOptionalName("C0000001",
                record.getString("userIdLocked"), "OPTION01");
        record.put("extensionNumber", extensionNumber);
        record.put("group", group);
        record.put("userIdLockedName", userIdLockedName);
    }

    /**
     * 条件検索を行う。<br/>
     * 引数で検索条件を指定することにより条件検索ができる。<br/>
     * 検索条件をしない場合は、引数にnullまたは空文字を渡すようにする。<br/>
     * これにより、その引数に関する検索条件を外すことができる。<br/>
     * 
     * @param condition
     *            検索条件
     * @return 検索結果
     */
    SqlResultSet selectByCondition(W11AC01FormBase condition) {
        return search("SELECT_USER_BY_CONDITION", condition);
    }
}
