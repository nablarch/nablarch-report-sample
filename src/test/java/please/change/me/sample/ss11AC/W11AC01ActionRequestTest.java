package please.change.me.sample.ss11AC;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import nablarch.fw.ExecutionContext;
import nablarch.test.core.http.BasicAdvice;
import nablarch.test.core.http.TestCaseInfo;

import org.junit.BeforeClass;
import org.junit.Test;

import please.change.me.sample.test.SampleHttpRequestTestSupport;
import please.change.me.sample.test.support.CompileUtil;

/**
 * {@link W11AC01Action}のテスト
 * 
 * @author Naoki Tamura
 */
public class W11AC01ActionRequestTest extends SampleHttpRequestTestSupport {

    @BeforeClass
    public static void beforeClass() throws Throwable {
        CompileUtil.compileReportDirAll("report/R001");
    }

    /** {@inheritDoc} */
    @Override
    protected String getBaseUri() {
        return "/action/ss11AC/W11AC01Action/";
    }

    @Test
    public void 検索画面_レイアウト確認_初期表示() {
        execute("検索画面_レイアウト確認_初期表示");
    }

    @Test
    public void 検索処理_レイアウト確認_最長桁() {
        execute("検索処理_レイアウト確認_最長桁");
    }

    @Test
    public void 検索処理_レイアウト確認_最短桁() {
        execute("検索処理_レイアウト確認_最短桁");
    }

    @Test
    public void 検索処理_結果なし() {
        execute("検索処理_結果なし");
    }

    @Test
    public void 検索処理_検索条件未入力_エラーが発生する() {
        execute("検索処理_結果条件未入力");
    }

    @Test
    public void 検索処理_結果条件の精査エラー() {
        execute("検索処理_結果条件の精査エラー");
    }

    @Test
    public void 検索処理_最大件数オーバー() {
        execute("検索処理_最大件数オーバー");
    }

    @Test
    public void 詳細画面表示_レイアウト確認_最長桁() {
        execute("詳細画面表示_レイアウト確認_最長桁");
    }

    @Test
    public void 詳細画面表示_レイアウト確認_最短桁() {
        execute("詳細画面表示_レイアウト確認_最短桁");
    }

    @Test
    public void 詳細画面表示_ユーザなし() {
        execute("詳細画面表示_ユーザなし");
    }

    @Test
    public void 一覧画面_PDF出力() {
        execute("一覧画面_PDF出力", new BasicAdvice() {
            @Override
            public void afterExecute(TestCaseInfo testCaseInfo,
                    ExecutionContext context) {
                File dump = (File) context
                        .getRequestScopedVar("nablarch_testFW_dumpFile");
                assertThat("PDFファイルのサイズが0以上であること", dump.length() > 0, is(true));
            }
        });
    }

}
