package please.change.me.sample.ss11AC;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import nablarch.core.ThreadContext;
import nablarch.core.db.statement.SqlResultSet;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.test.core.db.DbAccessTestSupport;

import org.junit.Test;

/**
 * @author T.Kawasaki
 */
public class W11AC01ActionTest extends DbAccessTestSupport {

    private W11AC01Action sut = new W11AC01Action();

    @Test
    public void ユーザ情報照会_検索条件に応じたユーザ情報が取得できること() {
        final String sheetName = "ユーザ情報照会_検索条件に応じたユーザ情報が取得できること";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        final List<Map<String, String[]>> inputs = getListParamMap(sheetName,
                "inputParams");
        int no = 0;
        for (Map<String, String> shot : shots) {
            String message = sheetName + "：shot[" + shot.get("no") + "] "
                    + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            W11AC01FormBase form = createForm(inputs.get(no++));
            // 実行
            SqlResultSet actual = sut.selectByCondition(form);
            // 検証
            assertSqlResultSetEquals(message, sheetName, shot.get("expected"),
                    actual);
        }
    }

    /**
     * フォームを生成する。
     * 
     * @param params
     *            パラメータ
     * @return フォーム
     */
    private W11AC01Form createForm(Map<String, String[]> params) {
        ValidationContext<W11AC01Form> ctx = ValidationUtil
                .validateAndConvertRequest(W11AC01Form.class, params, "search");
        ctx.abortIfInvalid();
        return ctx.createObject();
    }

    @Test
    public void 帳票出力用ユーザー情報の設定() {
        ThreadContext.setLanguage(Locale.JAPANESE);
        final String sheetName = "帳票出力用ユーザー情報の設定";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        final List<Map<String, String[]>> inputs = getListParamMap(sheetName,
                "inputParams");
        int no = 0;
        for (Map<String, String> shot : shots) {
            String message = sheetName + "：shot[" + shot.get("no") + "] "
                    + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            W11AC01FormBase form = createForm(inputs.get(no++));
            SqlResultSet actual = sut.selectByCondition(form);

            sut.setUserDetailedInfoForReport(actual.get(0));

            // 検証
            assertSqlRowEquals(message, sheetName, shot.get("expected"),
                    actual.get(0));

        }
    }

}
