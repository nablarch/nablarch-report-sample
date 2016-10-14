package please.change.me.sample.ss11AC;

import org.junit.BeforeClass;
import org.junit.Test;

import please.change.me.sample.test.SampleBatchRequestTestSupport;
import please.change.me.sample.test.support.CompileUtil;

/**
 * {@link B11AC012Action}のテストクラス。
 *
 * @author Naoki Tamura
 */
public class B11AC012ActionRequestTest extends SampleBatchRequestTestSupport {
    
    @BeforeClass
    public static void beforeClass() throws Throwable {
        CompileUtil.compileReportDirAll("report/R003");
    }

    /** 正常終了系のテスト。 */
    @Test
    public void testNormalEnd() {
        execute();
    }
}
