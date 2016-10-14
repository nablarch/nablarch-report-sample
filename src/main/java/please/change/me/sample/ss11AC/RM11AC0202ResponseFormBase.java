package please.change.me.sample.ss11AC;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import nablarch.core.validation.PropertyName;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.unicode.SystemChar;

/**
 * Httpユーザ登録送信_レスポンス:登録データの情報を保持するクラス。
 *
 * RM11AC0202ResponseFormBase クラスは Httpユーザ登録送信_レスポンス:登録データ レコードにマッピングされるフィールドを保持する。
 *
 * @author Entity Generator
 */
public abstract class RM11AC0202ResponseFormBase implements Serializable {

    /**
     * serialVersionUID。
     */
    private static final long serialVersionUID = 1L;

    /**
     * 障害事由コード。
     */
    private String failureCode;

    /**
     * 問い合わせID。
     */
    private String userInfoId;

    /**
     * データ区分。
     */
    private String dataKbn;



    /**
     * デフォルトコンストラクタ。
     */
    public RM11AC0202ResponseFormBase() {
    }

    /**
     * Mapを引数にとるコンストラクタ。
     * @param params 項目名をキーとし、項目値を値とするMap。
     */
    public RM11AC0202ResponseFormBase(Map<String, Object> params) {
        failureCode = (String) params.get("failureCode");
        userInfoId = (String) params.get("userInfoId");
        dataKbn = (String) params.get("dataKbn");
    }

    /**
     * プロパティの情報をMapに変換する。
     *
     * @return 変換後のMap
     */
    protected Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("failureCode", failureCode);
        result.put("userInfoId", userInfoId);
        result.put("dataKbn", dataKbn);
        return result;
    }

    /**
     * 障害事由コードを取得する。
     * @return 障害事由コード。
     */
    public String getFailureCode() {
        return failureCode;
    }

    /**
     * 障害事由コードを設定する。
     * @param failureCode 設定する障害事由コード。
     */
    @PropertyName("障害事由コード")
    @Length(max = 3)
    @SystemChar(allowLineSeparator = false, charsetDef = "numericCharset")
    public void setFailureCode(String failureCode) {
        this.failureCode = failureCode;
    }

    /**
     * 問い合わせIDを取得する。
     * @return 問い合わせID。
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * 問い合わせIDを設定する。
     * @param userInfoId 設定する問い合わせID。
     */
    @PropertyName("問い合わせID")
    @Length(max = 20)
    @SystemChar(allowLineSeparator = false, charsetDef = "AlnumChar")
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * データ区分を取得する。
     * @return データ区分。
     */
    public String getDataKbn() {
        return dataKbn;
    }

    /**
     * データ区分を設定する。
     * @param dataKbn 設定するデータ区分。
     */
    @PropertyName("データ区分")
    @Length(max = 1, min = 1)
    @SystemChar(allowLineSeparator = false, charsetDef = "numericCharset")
    public void setDataKbn(String dataKbn) {
        this.dataKbn = dataKbn;
    }

}
