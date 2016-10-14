package please.change.me.sample.ss11AC;

import java.util.HashMap;
import java.util.Map;

import nablarch.core.validation.PropertyName;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.Required;
import nablarch.core.validation.validator.unicode.SystemChar;
import please.change.me.core.validation.validator.MailAddress;


/**
 * ユーザ情報登録フォーム。
 *
 * @author 
 */
public abstract class W11AC02FormBase {

    //---- プロパティ ----//

    /** ログインID */
    private String loginId;

    /** パスワード */
    private String newPassword;

    /** パスワード（確認用） */
    private String confirmPassword;

    /** 漢字氏名 */
    private String kanjiName;

    /** カナ氏名 */
    private String kanaName;

    /** メールアドレス */
    private String mailAddress;

    /** 内線番号(ビル番号) */
    private String extensionNumberBuilding;

    /** 内線番号(個人番号) */
    private String extensionNumberPersonal;

    /** 携帯電話番号(市外局番) */
    private String mobilePhoneNumberAreaCode;

    /** 携帯電話番号(市内局番) */
    private String mobilePhoneNumberCityCode;

    /** 携帯電話番号(加入者局番) */
    private String mobilePhoneNumberSbscrCode;

    /** グループ */
    private String ugroupId;

    /** 認可単位 */
    private String[] permissionUnit;

    //---- コンストラクタ ----//

    /** デフォルトコンストラクタ。 */
    public W11AC02FormBase() {
    }

    /**
     * Mapを引数にとるコンストラクタ。
     *
     * @param params 項目名をキーとし、項目値を値とするMap
     */
    public W11AC02FormBase(Map<String, Object> params) {

        loginId = (String) params.get("loginId");
        newPassword = (String) params.get("newPassword");
        confirmPassword = (String) params.get("confirmPassword");
        kanjiName = (String) params.get("kanjiName");
        kanaName = (String) params.get("kanaName");
        mailAddress = (String) params.get("mailAddress");
        extensionNumberBuilding = (String) params.get("extensionNumberBuilding");
        extensionNumberPersonal = (String) params.get("extensionNumberPersonal");
        mobilePhoneNumberAreaCode = (String) params.get("mobilePhoneNumberAreaCode");
        mobilePhoneNumberCityCode = (String) params.get("mobilePhoneNumberCityCode");
        mobilePhoneNumberSbscrCode = (String) params.get("mobilePhoneNumberSbscrCode");
        ugroupId = (String) params.get("ugroupId");
        permissionUnit = (String[]) params.get("permissionUnit");
        
        

    }

    /**
     * プロパティの情報をMapに変換する。
     *
     * @return 変換後のMap
     */
    protected Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("loginId", loginId);
        result.put("newPassword", newPassword);
        result.put("confirmPassword", confirmPassword);
        result.put("kanjiName", kanjiName);
        result.put("kanaName", kanaName);
        result.put("mailAddress", mailAddress);
        result.put("extensionNumberBuilding", extensionNumberBuilding);
        result.put("extensionNumberPersonal", extensionNumberPersonal);
        result.put("mobilePhoneNumberAreaCode", mobilePhoneNumberAreaCode);
        result.put("mobilePhoneNumberCityCode", mobilePhoneNumberCityCode);
        result.put("mobilePhoneNumberSbscrCode", mobilePhoneNumberSbscrCode);
        result.put("ugroupId", ugroupId);
        result.put("permissionUnit", permissionUnit);
        
        
        return result;
    }


    //------ プロパティアクセッサ -----//

    /**
     * ログインIDを取得する。
     *
     * @return ログインID。
     */
    public String getLoginId() {
        return this.loginId;
    }

    /**
     * ログインIDを設定する。
     *
     * @param loginId 設定するログインID。
     *
     */
    @PropertyName("ログインID")
    @Required
    @Length(max = 20)
    @SystemChar(charsetDef = "asciiCharset", allowLineSeparator = false)
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * パスワードを取得する。
     *
     * @return パスワード。
     */
    public String getNewPassword() {
        return this.newPassword;
    }

    /**
     * パスワードを設定する。
     *
     * @param newPassword 設定するパスワード。
     *
     */
    @PropertyName("パスワード")
    @Required
    @Length(max = 20)
    @SystemChar(charsetDef = "asciiCharset", allowLineSeparator = false)
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * パスワード（確認用）を取得する。
     *
     * @return パスワード（確認用）。
     */
    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    /**
     * パスワード（確認用）を設定する。
     *
     * @param confirmPassword 設定するパスワード（確認用）。
     *
     */
    @PropertyName("パスワード（確認用）")
    @Required
    @Length(max = 20)
    @SystemChar(charsetDef = "asciiCharset", allowLineSeparator = false)
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * 漢字氏名を取得する。
     *
     * @return 漢字氏名。
     */
    public String getKanjiName() {
        return this.kanjiName;
    }

    /**
     * 漢字氏名を設定する。
     *
     * @param kanjiName 設定する漢字氏名。
     *
     */
    @PropertyName("漢字氏名")
    @Required
    @Length(max = 50)
    @SystemChar(charsetDef = "zenkakuCharset", allowLineSeparator = false)
    public void setKanjiName(String kanjiName) {
        this.kanjiName = kanjiName;
    }

    /**
     * カナ氏名を取得する。
     *
     * @return カナ氏名。
     */
    public String getKanaName() {
        return this.kanaName;
    }

    /**
     * カナ氏名を設定する。
     *
     * @param kanaName 設定するカナ氏名。
     *
     */
    @PropertyName("カナ氏名")
    @Required
    @Length(max = 50)
    @SystemChar(charsetDef = "zenkakuKatakanaCharset", allowLineSeparator = false)
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * メールアドレスを取得する。
     *
     * @return メールアドレス。
     */
    public String getMailAddress() {
        return this.mailAddress;
    }

    /**
     * メールアドレスを設定する。
     *
     * @param mailAddress 設定するメールアドレス。
     *
     */
    @PropertyName("メールアドレス")
    @Required
    @Length(max = 100)
    @MailAddress()
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * 内線番号(ビル番号)を取得する。
     *
     * @return 内線番号(ビル番号)。
     */
    public String getExtensionNumberBuilding() {
        return this.extensionNumberBuilding;
    }

    /**
     * 内線番号(ビル番号)を設定する。
     *
     * @param extensionNumberBuilding 設定する内線番号(ビル番号)。
     *
     */
    @PropertyName("内線番号(ビル番号)")
    @Required
    @Length(max = 2)
    @SystemChar(charsetDef = "numericCharset", allowLineSeparator = false)
    public void setExtensionNumberBuilding(String extensionNumberBuilding) {
        this.extensionNumberBuilding = extensionNumberBuilding;
    }

    /**
     * 内線番号(個人番号)を取得する。
     *
     * @return 内線番号(個人番号)。
     */
    public String getExtensionNumberPersonal() {
        return this.extensionNumberPersonal;
    }

    /**
     * 内線番号(個人番号)を設定する。
     *
     * @param extensionNumberPersonal 設定する内線番号(個人番号)。
     *
     */
    @PropertyName("内線番号(個人番号)")
    @Required
    @Length(max = 4)
    @SystemChar(charsetDef = "numericCharset", allowLineSeparator = false)
    public void setExtensionNumberPersonal(String extensionNumberPersonal) {
        this.extensionNumberPersonal = extensionNumberPersonal;
    }

    /**
     * 携帯電話番号(市外局番)を取得する。
     *
     * @return 携帯電話番号(市外局番)。
     */
    public String getMobilePhoneNumberAreaCode() {
        return this.mobilePhoneNumberAreaCode;
    }

    /**
     * 携帯電話番号(市外局番)を設定する。
     *
     * @param mobilePhoneNumberAreaCode 設定する携帯電話番号(市外局番)。
     *
     */
    @PropertyName("携帯電話番号(市外局番)")
    @Length(max = 3)
    @SystemChar(charsetDef = "numericCharset", allowLineSeparator = false)
    public void setMobilePhoneNumberAreaCode(String mobilePhoneNumberAreaCode) {
        this.mobilePhoneNumberAreaCode = mobilePhoneNumberAreaCode;
    }

    /**
     * 携帯電話番号(市内局番)を取得する。
     *
     * @return 携帯電話番号(市内局番)。
     */
    public String getMobilePhoneNumberCityCode() {
        return this.mobilePhoneNumberCityCode;
    }

    /**
     * 携帯電話番号(市内局番)を設定する。
     *
     * @param mobilePhoneNumberCityCode 設定する携帯電話番号(市内局番)。
     *
     */
    @PropertyName("携帯電話番号(市内局番)")
    @Length(max = 4)
    @SystemChar(charsetDef = "numericCharset", allowLineSeparator = false)
    public void setMobilePhoneNumberCityCode(String mobilePhoneNumberCityCode) {
        this.mobilePhoneNumberCityCode = mobilePhoneNumberCityCode;
    }

    /**
     * 携帯電話番号(加入者局番)を取得する。
     *
     * @return 携帯電話番号(加入者局番)。
     */
    public String getMobilePhoneNumberSbscrCode() {
        return this.mobilePhoneNumberSbscrCode;
    }

    /**
     * 携帯電話番号(加入者局番)を設定する。
     *
     * @param mobilePhoneNumberSbscrCode 設定する携帯電話番号(加入者局番)。
     *
     */
    @PropertyName("携帯電話番号(加入者局番)")
    @Length(max = 4)
    @SystemChar(charsetDef = "numericCharset", allowLineSeparator = false)
    public void setMobilePhoneNumberSbscrCode(String mobilePhoneNumberSbscrCode) {
        this.mobilePhoneNumberSbscrCode = mobilePhoneNumberSbscrCode;
    }

    /**
     * グループを取得する。
     *
     * @return グループ。
     */
    public String getUgroupId() {
        return this.ugroupId;
    }

    /**
     * グループを設定する。
     *
     * @param ugroupId 設定するグループ。
     *
     */
    @PropertyName("グループ")
    @Required
    @Length(max = 10, min = 10)
    @SystemChar(charsetDef = "numericCharset", allowLineSeparator = false)
    public void setUgroupId(String ugroupId) {
        this.ugroupId = ugroupId;
    }

    /**
     * 認可単位を取得する。
     *
     * @return 認可単位。
     */
    public String[] getPermissionUnit() {
        return this.permissionUnit;
    }

    /**
     * 認可単位を設定する。
     *
     * @param permissionUnit 設定する認可単位。
     *
     */
    @PropertyName("認可単位")
    @Length(max = 10, min = 10)
    @SystemChar(charsetDef = "numericCharset", allowLineSeparator = false)
    public void setPermissionUnit(String[] permissionUnit) {
        this.permissionUnit = permissionUnit;
    }

}
