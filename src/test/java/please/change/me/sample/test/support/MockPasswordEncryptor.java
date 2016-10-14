package please.change.me.sample.test.support;

import please.change.me.common.authentication.PasswordEncryptor;

/**
 * {@link PasswordEncryptor}のテスト用モック実装クラス。
 *
 * @author hisaaki sioiri
 */
public class MockPasswordEncryptor implements PasswordEncryptor {

    /**
     * {@inheritDoc}
     *
     * 本実装では、ユーザIDとパスワードを連結し逆順にした文字列を返却する。
     */
    public String encrypt(String userId, String password) {
        StringBuilder builder = new StringBuilder();
        builder.append(userId).append(password);
        return builder.reverse().toString();
    }
}
