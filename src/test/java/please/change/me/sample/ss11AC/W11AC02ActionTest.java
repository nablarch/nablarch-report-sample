package please.change.me.sample.ss11AC;

import java.util.List;
import java.util.Map;

import nablarch.core.ThreadContext;
import nablarch.core.db.statement.SqlRow;
import nablarch.test.core.db.DbAccessTestSupport;

import org.junit.Test;

/**
 * @author Naoki Tamura
 */
public class W11AC02ActionTest extends DbAccessTestSupport {

    private W11AC02Action sut = new W11AC02Action();

    @Test
    public void 帳票出力用ユーザー情報の取得() {
        ThreadContext.setUserId("0000000001");
        
        final String sheetName = "帳票出力用ユーザー情報の取得";
        List<Map<String, String>> shots = getListMap(sheetName, "testShots");

        final List<Map<String, String[]>> inputs = getListParamMap(sheetName,
                "inputParams");
        int no = 0;
        for (Map<String, String> shot : shots) {
            String message = sheetName + "：shot[" + shot.get("no") + "] "
                    + shot.get("case") + "\n";

            // 事前条件
            setUpDb(sheetName, shot.get("setUpTable"));

            SqlRow actual = sut.getUserDetailedInfoForReport(inputs.get(no++)
                    .get("userId")[0]);
            // 検証
            assertSqlRowEquals(message, sheetName, shot.get("expected"), actual);

        }
    }

}
