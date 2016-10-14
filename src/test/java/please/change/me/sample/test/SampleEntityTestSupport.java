package please.change.me.sample.test;

import java.util.Locale;

import nablarch.core.ThreadContext;

import nablarch.test.core.db.EntityTestSupport;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * 本プロジェクト用の{@link nablarch.test.core.db.EntityTestSupport}継承クラス。
 *
 * 本プロジェクトのForm（Entity）クラスのテストをサポートする共通的な処理を本クラスにて実現する。
 *
 * @author hisaaki sioiri
 */
public class SampleEntityTestSupport extends EntityTestSupport {

    /** テスト実行時に設定されていた{@link java.util.Locale} */
    private static Locale original;

    @BeforeClass
    public static void setUpEntityTest() {
        original = ThreadContext.getLanguage();
        ThreadContext.setLanguage(Locale.JAPANESE);
    }

    @AfterClass
    public static void tearDownEntityTest() {
        if (original != null) {
            ThreadContext.setLanguage(original);
        }
    }

}
