package please.change.me.sample.ss11AC;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import nablarch.core.validation.PropertyName;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.unicode.SystemChar;
import please.change.me.core.validation.validator.MailAddress;

/**
 * Httpユーザ登録送信_リクエスト:登録データの情報を保持するクラス。
 *
 * RM11AC0202RequestFormBase クラスは Httpユーザ登録送信_リクエスト:登録データ レコードにマッピングされるフィールドを保持する。
 *
 * @author Entity Generator
 */
public abstract class RM11AC0202RequestFormBase implements Serializable {

    /**
     * serialVersionUID。
     */
    private static final long serialVersionUID = 1L;

    /**
     * データ区分。
     */
    private String dataKbn;

    /**
     * ログインID。
     */
    private String loginId;

    /**
     * 漢字氏名。
     */
    private String kanjiName;

    /**
     * カナ氏名。
     */
    private String kanaName;

    /**
     * メールアドレス。
     */
    private String mailAddress;

    /**
     * 内線番号(ビル番号)。
     */
    private String extensionNumberBuilding;

    /**
     * 内線番号(個人番号)。
     */
    private String extensionNumberPersonal;

    /**
     * 携帯電話番号(市外)。
     */
    private String mobilePhoneNumberAreaCode;

    /**
     * 携帯電話番号(市内)。
     */
    private String mobilePhoneNumberCityCode;

    /**
     * 携帯電話番号(加入)。
     */
    private String mobilePhoneNumberSbscrCode;



    /**
     * デフォルトコンストラクタ。
     */
    public RM11AC0202RequestFormBase() {
    }

    /**
     * Mapを引数にとるコンストラクタ。
     * @param params 項目名をキーとし、項目値を値とするMap。
     */
    public RM11AC0202RequestFormBase(Map<String, Object> params) {
        dataKbn = (String) params.get("dataKbn");
        loginId = (String) params.get("loginId");
        kanjiName = (String) params.get("kanjiName");
        kanaName = (String) params.get("kanaName");
        mailAddress = (String) params.get("mailAddress");
        extensionNumberBuilding = (String) params.get("extensionNumberBuilding");
        extensionNumberPersonal = (String) params.get("extensionNumberPersonal");
        mobilePhoneNumberAreaCode = (String) params.get("mobilePhoneNumberAreaCode");
        mobilePhoneNumberCityCode = (String) params.get("mobilePhoneNumberCityCode");
        mobilePhoneNumberSbscrCode = (String) params.get("mobilePhoneNumberSbscrCode");
    }

    /**
     * プロパティの情報をMapに変換する。
     *
     * @return 変換後のMap
     */
    protected Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("dataKbn", dataKbn);
        result.put("loginId", loginId);
        result.put("kanjiName", kanjiName);
        result.put("kanaName", kanaName);
        result.put("mailAddress", mailAddress);
        result.put("extensionNumberBuilding", extensionNumberBuilding);
        result.put("extensionNumberPersonal", extensionNumberPersonal);
        result.put("mobilePhoneNumberAreaCode", mobilePhoneNumberAreaCode);
        result.put("mobilePhoneNumberCityCode", mobilePhoneNumberCityCode);
        result.put("mobilePhoneNumberSbscrCode", mobilePhoneNumberSbscrCode);
        return result;
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

    /**
     * ログインIDを取得する。
     * @return ログインID。
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * ログインIDを設定する。
     * @param loginId 設定するログインID。
     */
    @PropertyName("ログインID")
    @Length(max = 20)
    @SystemChar(allowLineSeparator = false, charsetDef = "AlnumChar")
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * 漢字氏名を取得する。
     * @return 漢字氏名。
     */
    public String getKanjiName() {
        return kanjiName;
    }

    /**
     * 漢字氏名を設定する。
     * @param kanjiName 設定する漢字氏名。
     */
    @PropertyName("漢字氏名")
    @Length(max = 50)
    @SystemChar(allowLineSeparator = false, charsetDef = "zenkakuCharset")
    public void setKanjiName(String kanjiName) {
        this.kanjiName = kanjiName;
    }

    /**
     * カナ氏名を取得する。
     * @return カナ氏名。
     */
    public String getKanaName() {
        return kanaName;
    }

    /**
     * カナ氏名を設定する。
     * @param kanaName 設定するカナ氏名。
     */
    @PropertyName("カナ氏名")
    @Length(max = 50)
    @SystemChar(allowLineSeparator = false, charsetDef = "zenkakuKatakanaCharset")
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * メールアドレスを取得する。
     * @return メールアドレス。
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * メールアドレスを設定する。
     * @param mailAddress 設定するメールアドレス。
     */
    @PropertyName("メールアドレス")
    @Length(max = 100)
    @MailAddress
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * 内線番号(ビル番号)を取得する。
     * @return 内線番号(ビル番号)。
     */
    public String getExtensionNumberBuilding() {
        return extensionNumberBuilding;
    }

    /**
     * 内線番号(ビル番号)を設定する。
     * @param extensionNumberBuilding 設定する内線番号(ビル番号)。
     */
    @PropertyName("内線番号(ビル番号)")
    @Length(max = 2)
    @SystemChar(allowLineSeparator = false, charsetDef = "numericCharset")
    public void setExtensionNumberBuilding(String extensionNumberBuilding) {
        this.extensionNumberBuilding = extensionNumberBuilding;
    }

    /**
     * 内線番号(個人番号)を取得する。
     * @return 内線番号(個人番号)。
     */
    public String getExtensionNumberPersonal() {
        return extensionNumberPersonal;
    }

    /**
     * 内線番号(個人番号)を設定する。
     * @param extensionNumberPersonal 設定する内線番号(個人番号)。
     */
    @PropertyName("内線番号(個人番号)")
    @Length(max = 4)
    @SystemChar(allowLineSeparator = false, charsetDef = "numericCharset")
    public void setExtensionNumberPersonal(String extensionNumberPersonal) {
        this.extensionNumberPersonal = extensionNumberPersonal;
    }

    /**
     * 携帯電話番号(市外)を取得する。
     * @return 携帯電話番号(市外)。
     */
    public String getMobilePhoneNumberAreaCode() {
        return mobilePhoneNumberAreaCode;
    }

    /**
     * 携帯電話番号(市外)を設定する。
     * @param mobilePhoneNumberAreaCode 設定する携帯電話番号(市外)。
     */
    @PropertyName("携帯電話番号(市外)")
    @Length(max = 3)
    @SystemChar(allowLineSeparator = false, charsetDef = "numericCharset")
    public void setMobilePhoneNumberAreaCode(String mobilePhoneNumberAreaCode) {
        this.mobilePhoneNumberAreaCode = mobilePhoneNumberAreaCode;
    }

    /**
     * 携帯電話番号(市内)を取得する。
     * @return 携帯電話番号(市内)。
     */
    public String getMobilePhoneNumberCityCode() {
        return mobilePhoneNumberCityCode;
    }

    /**
     * 携帯電話番号(市内)を設定する。
     * @param mobilePhoneNumberCityCode 設定する携帯電話番号(市内)。
     */
    @PropertyName("携帯電話番号(市内)")
    @Length(max = 4)
    @SystemChar(allowLineSeparator = false, charsetDef = "numericCharset")
    public void setMobilePhoneNumberCityCode(String mobilePhoneNumberCityCode) {
        this.mobilePhoneNumberCityCode = mobilePhoneNumberCityCode;
    }

    /**
     * 携帯電話番号(加入)を取得する。
     * @return 携帯電話番号(加入)。
     */
    public String getMobilePhoneNumberSbscrCode() {
        return mobilePhoneNumberSbscrCode;
    }

    /**
     * 携帯電話番号(加入)を設定する。
     * @param mobilePhoneNumberSbscrCode 設定する携帯電話番号(加入)。
     */
    @PropertyName("携帯電話番号(加入)")
    @Length(max = 4)
    @SystemChar(allowLineSeparator = false, charsetDef = "numericCharset")
    public void setMobilePhoneNumberSbscrCode(String mobilePhoneNumberSbscrCode) {
        this.mobilePhoneNumberSbscrCode = mobilePhoneNumberSbscrCode;
    }

}
