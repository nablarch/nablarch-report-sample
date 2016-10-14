package please.change.me.sample.ss11AB;

import org.junit.Test;

import please.change.me.sample.test.SampleHttpRequestTestSupport;

/**
 * {@link W11AB01Action}のテスト
 * @author Masayuki Fujikuma
 */
public class W11AB01ActionRequestTest extends SampleHttpRequestTestSupport {

    @Override
    protected String getBaseUri() {
        return "/action/ss11AB/W11AB01Action/";
    }
    
    @Test
    public void メニュー画面_レイアウト確認_初期表示() {
        execute("メニュー画面_レイアウト確認_初期表示");
    }
}
