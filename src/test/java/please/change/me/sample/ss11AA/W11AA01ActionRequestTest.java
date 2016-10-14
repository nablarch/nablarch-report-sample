package please.change.me.sample.ss11AA;


import org.junit.Test;

import please.change.me.sample.test.SampleHttpRequestTestSupport;

/**
 * {@link W11AA01Action}のリクエスト単体テストクラス
 *
 * @author Miki Habu
 */
public class W11AA01ActionRequestTest extends SampleHttpRequestTestSupport {

    @Override
    protected String getBaseUri() {
        return "/action/ss11AA/W11AA01Action/";
    }

    @Test
    public void ログイン画面_レイアウト確認_初期表示() {
        execute("ログイン画面_レイアウト確認_初期表示");
    }

    @Test
    public void ログイン画面_ログイン成功() {
        execute("ログイン画面_ログイン成功");
    }

    @Test
    public void ログイン画面_文言確認_精査エラー() {
        execute("ログイン画面_文言確認_精査エラー");
    }
}

