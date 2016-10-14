package please.change.me.sample.ss11AA;

import java.util.Map;

import nablarch.core.validation.PropertyName;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.Required;
import nablarch.core.validation.validator.unicode.SystemChar;

/**
 * ログインフォーム。
 *
 * @author Masayuki Fujikuma
 */
public abstract class W11AA01FormBase {

    /** ログインID */
    private String loginId;

    /** パスワード */
    private String password;

    /**
     * コンストラクタ
     *
     * @param params パラメータ
     */
    public W11AA01FormBase(Map<String, Object> params) {
        loginId = (String) params.get("loginId");
        password = (String) params.get("password");
    }

    /**
     * ログインIDを取得する。
     *
     * @return ログインID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * ログインIDを設定する。
     *
     * @param loginId ログインID
     */
    @PropertyName(messageId = "S0010002")
    @Required
    @SystemChar(charsetDef = "asciiCharset")
    @Length(min = 0, max = 20)
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * パスワードを取得する。
     *
     * @return password パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを取得する。
     *
     * @param password パスワード
     */
    @PropertyName(messageId = "S0010003")
    @Required
    @SystemChar(charsetDef = "asciiCharset")
    @Length(min = 0, max = 20)
    public void setPassword(String password) {
        this.password = password;
    }

}
