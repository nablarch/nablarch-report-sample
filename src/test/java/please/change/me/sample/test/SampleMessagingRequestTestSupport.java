package please.change.me.sample.test;

import nablarch.test.core.messaging.MessagingReceiveTestSupport;
import nablarch.test.core.messaging.MessagingRequestTestSupport;

/**
 * 本プロジェクト専用の{@link MessagingReceiveTestSupport}継承クラス。<br/>
 * プロジェクト固有の共通処理を提供する。
 * メッセージ同期応答のリクエスト単体テストを作成する場合、
 * {@link MessagingReceiveTestSupport}を直接継承するのではなく、
 * 本クラスを継承すること。
 *
 * @author T.Kawasaki
 */
public abstract class SampleMessagingRequestTestSupport
        extends MessagingRequestTestSupport {

    /** コンストラクタ。 */
    protected SampleMessagingRequestTestSupport() {
    }

    /**
     * コンストラクタ。
     *
     * @param testClass テストクラス
     */
    public SampleMessagingRequestTestSupport(Class<?> testClass) {
        super(testClass);
    }
}
