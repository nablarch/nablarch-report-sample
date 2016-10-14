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
 * {@link W11AC02Action}のテスト
 * 
 * @author Naoki Tamura
 */
public class W11AC02ActionRequestTest extends SampleHttpRequestTestSupport {

	@BeforeClass
	public static void beforeClass() throws Throwable {
		CompileUtil.compileReportDirAll("report/R002");
	}

	/** {@inheritDoc} */
	@Override
	protected String getBaseUri() {
		return "/action/ss11AC/W11AC02Action/";
	}
	
    @Test
    public void 登録画面_レイアウト確認_初期表示() {
        execute("登録画面_レイアウト確認_初期表示");
    }

	@Test
	public void 詳細画面表示_PDF出力() {
		execute("詳細画面表示_PDF出力", new BasicAdvice() {
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
