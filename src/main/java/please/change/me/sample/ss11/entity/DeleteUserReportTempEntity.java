package please.change.me.sample.ss11.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import nablarch.core.db.statement.autoproperty.CurrentDateTime;
import nablarch.core.db.statement.autoproperty.UserId;

/**
 * 削除ユーザレポートテンポラリエンティティ。
 *
 * @author hisaaki sioiri
 */
public class DeleteUserReportTempEntity implements Serializable {

    /** シリアルバージョン */
    private static final long serialVersionUID = 707376997650526243L;

    /** ユーザID */
    private String userId;

    /** ログインID */
    private String loginId;

    /** 漢字名称 */
    private String kanjiName;

    /** カナ名称 */
    private String kanaName;

    /** メールアドレス */
    private String mailAddress;

    /** 内線番号(ビル番号) */
    private String extensionNumberBuilding;

    /** 内線番号(個人番号) */
    private String extensionNumberPersonal;

    /** 携帯電話番号(市外) */
    private String mobilePhoneNumberAreaCode;

    /** 携帯電話番号(市内) */
    private String mobilePhoneNumberCityCode;

    /** 携帯電話番号(加入) */
    private String mobilePhoneNumberSbscrCode;

    /** 登録者ID。 */
    @UserId
    private String insertUserId;

    /** 登録日時。 */
    @CurrentDateTime
    private Timestamp insertDate;

    /** 更新者ID。 */
    @UserId
    private String updatedUserId;

    /** 更新日時。 */
    @CurrentDateTime
    private Timestamp updatedDate;

    /**
     * コンストラクタ。
     *
     * @param data 各プロパティのデータを保持したMap
     */
    public DeleteUserReportTempEntity(Map<String, Object> data) {
        userId = (String) data.get("userId");
        loginId = (String) data.get("loginId");
        kanjiName = (String) data.get("kanjiName");
        kanaName = (String) data.get("kanaName");
        mailAddress = (String) data.get("mailAddress");
        extensionNumberBuilding = (String) data.get("extensionNumberBuilding");
        extensionNumberPersonal = (String) data.get("extensionNumberPersonal");
        mobilePhoneNumberAreaCode = (String) data.get(
                "mobilePhoneNumberAreaCode");
        mobilePhoneNumberCityCode = (String) data.get(
                "mobilePhoneNumberCityCode");
        mobilePhoneNumberSbscrCode = (String) data.get(
                "mobilePhoneNumberSbscrCode");
    }

    /**
     * ユーザIDを取得する。
     *
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザを設定する。
     *
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * 漢字名称を取得する。
     *
     * @return 漢字名称
     */
    public String getKanjiName() {
        return kanjiName;
    }

    /**
     * 漢字名称を設定する。
     *
     * @param kanjiName 漢字名称
     */
    public void setKanjiName(String kanjiName) {
        this.kanjiName = kanjiName;
    }

    /**
     * カナ名称を取得する。
     *
     * @return カナ名称
     */
    public String getKanaName() {
        return kanaName;
    }

    /**
     * カナ名称を設定する。
     *
     * @param kanaName カナ名称
     */
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * メールアドレスを取得する。
     *
     * @return メールアドレス
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * メールアドレスを設定する。
     *
     * @param mailAddress メールアドレス
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * 内線番号(ビル番号) を取得する。
     *
     * @return 内線番号(ビル番号)
     */
    public String getExtensionNumberBuilding() {
        return extensionNumberBuilding;
    }

    /**
     * 内線番号(ビル番号)を設定する。
     *
     * @param extensionNumberBuilding 内線番号(ビル番号)
     */
    public void setExtensionNumberBuilding(String extensionNumberBuilding) {
        this.extensionNumberBuilding = extensionNumberBuilding;
    }

    /**
     * 内線番号(個人番号)を取得する。
     *
     * @return 内線番号(個人番号)
     */
    public String getExtensionNumberPersonal() {
        return extensionNumberPersonal;
    }

    /**
     * 内線番号(個人番号)を設定する。
     *
     * @param extensionNumberPersonal 内線番号(個人番号)
     */
    public void setExtensionNumberPersonal(String extensionNumberPersonal) {
        this.extensionNumberPersonal = extensionNumberPersonal;
    }

    /**
     * 携帯電話番号(市外)を取得する。
     *
     * @return 携帯電話番号(市外)
     */
    public String getMobilePhoneNumberAreaCode() {
        return mobilePhoneNumberAreaCode;
    }

    /**
     * 携帯電話番号(市外)を設定する。
     *
     * @param mobilePhoneNumberAreaCode 携帯電話番号(市外)
     */
    public void setMobilePhoneNumberAreaCode(String mobilePhoneNumberAreaCode) {
        this.mobilePhoneNumberAreaCode = mobilePhoneNumberAreaCode;
    }

    /**
     * 携帯電話番号(市内)を取得する。
     *
     * @return 携帯電話番号(市内)
     */
    public String getMobilePhoneNumberCityCode() {
        return mobilePhoneNumberCityCode;
    }

    /**
     * 携帯電話番号(市内)を設定する。
     *
     * @param mobilePhoneNumberCityCode 携帯電話番号(市内)
     */
    public void setMobilePhoneNumberCityCode(String mobilePhoneNumberCityCode) {
        this.mobilePhoneNumberCityCode = mobilePhoneNumberCityCode;
    }

    /**
     * 携帯電話番号(加入)を取得する。
     *
     * @return 携帯電話番号(加入)
     */
    public String getMobilePhoneNumberSbscrCode() {
        return mobilePhoneNumberSbscrCode;
    }

    /**
     * 携帯電話番号(加入)を設定する。
     *
     * @param mobilePhoneNumberSbscrCode 携帯電話番号(加入)
     */
    public void setMobilePhoneNumberSbscrCode(
            String mobilePhoneNumberSbscrCode) {
        this.mobilePhoneNumberSbscrCode = mobilePhoneNumberSbscrCode;
    }
}
