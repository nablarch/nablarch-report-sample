package please.change.me.sample.ss11AC;

import java.io.File;

import nablarch.common.web.download.StreamResponse;
import nablarch.core.ThreadContext;
import nablarch.core.db.statement.SqlResultSet;
import nablarch.core.db.statement.SqlRow;
import nablarch.core.db.support.DbAccessSupport;
import nablarch.core.message.ApplicationException;
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
 * ユーザー基本情報帳票出力のアクションクラス。
 * 
 * @author Naoki Tamura
 */
public class W11AC02Action extends DbAccessSupport {

    /** ユーザー使用言語 */
    private static final String USER_LANG = "ja";

    /**
     * ユーザ情報画面を表示する。
     * 
     * @param req
     *            リクエストコンテキスト
     * @param ctx
     *            HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    public HttpResponse doRW11AC0201(HttpRequest req, ExecutionContext ctx) {

        // 表示に必要なグループの情報、認可単位の情報をリクエストスコープに格納
        setUpViewData(ctx);

        return new HttpResponse("/ss11AC/W11AC0201.jsp");
    }

    /**
     * ユーザ基本情報のPDF出力処理を行う。
     * 
     * @param req
     *            リクエストコンテキスト
     * @param ctx
     *            HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    @OnError(type = ApplicationException.class, path = "forward://RW11AC0201")
    public HttpResponse doRW11AC0207(HttpRequest req, ExecutionContext ctx) {

        // 引継いだユーザIDの取得
        W11AC02Form form = W11AC02Form.validate(req, "pdf");
        String loginId = form.getLoginId();

        CM311AC1Component component = new CM311AC1Component();

        // 帳票出力処理
        SqlRow userDetailedInfo = getUserDetailedInfoForReport(loginId);

        // データソースの設定
        userDetailedInfo.put("permissionDS", new SqlResultSetDataSource(
                component.selectPermissionUnit(loginId)));
        ReportParam rp = new ReportParam(userDetailedInfo);

        ReportContext rctx = new ReportContext("R002");
        rctx.addReportParam(rp);

        File tmpPdf = ReportManager.createReport(rctx);

        StreamResponse response = new StreamResponse(tmpPdf, true);
        response.setContentType("application/octet-stream");
        response.setContentDisposition("ユーザ基本情報.pdf");

        return response;
    }

    /**
     * 帳票出力用のたユーザー情報を取得する。
     * 
     * @param userId
     *            ログインID
     * @return ユーザー情報
     */
    SqlRow getUserDetailedInfoForReport(String userId) {

        CM311AC1Component component = new CM311AC1Component();
        SqlRow userDetailedInfo = component.selectDetailedUserInfo(userId);

        String execLoginId = ThreadContext.getUserId();
        userDetailedInfo.put("execLoginId", execLoginId);

        String extensionNumber = String.format("%s - %s",
                userDetailedInfo.getString("extensionNumberBuilding"),
                userDetailedInfo.getString("extensionNumberPersonal"));
        userDetailedInfo.put("extensionNumber", extensionNumber);

        String mobilePhoneNumber = String.format("%s - %s - %s",
                userDetailedInfo.getString("mobilePhoneNumberAreaCode"),
                userDetailedInfo.getString("mobilePhoneNumberCityCode"),
                userDetailedInfo.getString("mobilePhoneNumberSbscrCode"));

        if (mobilePhoneNumber.contains("null")) {
            mobilePhoneNumber = "";
        }

        userDetailedInfo.put("mobilePhoneNumber", mobilePhoneNumber);

        String ugroupId = component.selectUgroup(userId).get(0)
                .getString("ugroupId");
        String ugroupName = component.selectUgroup(userId).get(0)
                .getString("ugroupName");

        userDetailedInfo.put("ugroupInfo",
                String.format("%s : %s", ugroupId, ugroupName));

        return userDetailedInfo;
    }

    /**
     * 表示に必要なグループの情報、認可単位の情報をリクエストスコープに格納する。
     * 
     * @param ctx
     *            HTTPリクエストの処理に関連するサーバ側の情報
     */
    private void setUpViewData(ExecutionContext ctx) {

        // 表示に必要なグループの情報、認可単位の情報を取得
        CM311AC1Component component = new CM311AC1Component();
        SqlResultSet groupInfo = component.getUserGroups();
        SqlResultSet permissionUnitInfo = component.getAllPermissionUnit();

        // 結果をリクエストスコープに格納
        ctx.setRequestScopedVar("allGroup", groupInfo);
        ctx.setRequestScopedVar("allPermissionUnit", permissionUnitInfo);
    }

}
