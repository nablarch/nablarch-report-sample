package please.change.me.sample.test;

import nablarch.test.core.messaging.MessagingReceiveTestSupport;

/**
 * 本プロジェクト専用の{@link MessagingReceiveTestSupport}継承クラス。<br/>
 * プロジェクト固有の共通処理を提供する。
 * メッセージ応答なし受信処理のリクエスト単体テストを作成する場合、
 * {@link MessagingReceiveTestSupport}を直接継承するのではなく、
 * 本クラスを継承すること。
 *
 * @author T.Kawasaki
 */
public abstract class SampleMessagingReceiveTestSupport
        extends MessagingReceiveTestSupport {

    /** コンストラクタ。 */
    protected SampleMessagingReceiveTestSupport() {
        super();
    }

    /**
     * コンストラクタ。
     *
     * @param testClass テストクラス
     */
    public SampleMessagingReceiveTestSupport(Class<?> testClass) {
        super(testClass);
    }
}
