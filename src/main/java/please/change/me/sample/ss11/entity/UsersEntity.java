package please.change.me.sample.ss11.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import nablarch.core.db.statement.autoproperty.CurrentDateTime;
import nablarch.core.db.statement.autoproperty.UserId;

/**
 * ユーザテーブルの情報を保持するクラス。
 *
 * @author Nablarch taro
 */
public class UsersEntity implements Serializable {

    /** シリアルバージョン */
    private static final long serialVersionUID = -5431575293232405272L;

    /** ユーザID。 */
    private String userId;

    /** 漢字氏名。 */
    private String kanjiName;

    /** カナ氏名。 */
    private String kanaName;

    /** メールアドレス。 */
    private String mailAddress;

    /** 内線番号(ビル番号)。 */
    private String extensionNumberBuilding;

    /** 内線番号(個人番号)。 */
    private String extensionNumberPersonal;

    /** 携帯電話番号(市外)。 */
    private String mobilePhoneNumberAreaCode;

    /** 携帯電話番号(市内)。 */
    private String mobilePhoneNumberCityCode;

    /** 携帯電話番号(加入)。 */
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
     * ユーザIDを取得する。
     *
     * @return ユーザID。
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定する。
     *
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 漢字氏名を取得する。
     *
     * @return 漢字氏名。
     */
    public String getKanjiName() {
        return kanjiName;
    }

    /**
     * 漢字氏名を設定する。
     *
     * @param kanjiName 漢字氏名
     */
    public void setKanjiName(String kanjiName) {
        this.kanjiName = kanjiName;
    }

    /**
     * カナ氏名を取得する。
     *
     * @return カナ氏名。
     */
    public String getKanaName() {
        return kanaName;
    }

    /**
     * カナ氏名を設定する。
     *
     * @param kanaName カナ氏名
     */
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * メールアドレスを取得する。
     *
     * @return メールアドレス。
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * メールアドレスを設定する。
     *
     * @param mailAddress 設定するメールアドレス。
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * 内線番号(ビル番号)を取得する。
     *
     * @return 内線番号(ビル番号)。
     */
    public String getExtensionNumberBuilding() {
        return extensionNumberBuilding;
    }

    /**
     * 内線番号(ビル番号)を設定する。
     *
     * @param extensionNumberBuilding 設定する内線番号(ビル番号)。
     */
    public void setExtensionNumberBuilding(String extensionNumberBuilding) {
        this.extensionNumberBuilding = extensionNumberBuilding;
    }

    /**
     * 内線番号(個人番号)を取得する。
     *
     * @return 内線番号(個人番号)。
     */
    public String getExtensionNumberPersonal() {
        return extensionNumberPersonal;
    }

    /**
     * 内線番号(個人番号)を設定する。
     *
     * @param extensionNumberPersonal 設定する内線番号(個人番号)。
     */
    public void setExtensionNumberPersonal(String extensionNumberPersonal) {
        this.extensionNumberPersonal = extensionNumberPersonal;
    }

    /**
     * 携帯電話番号(市外)を取得する。
     *
     * @return 携帯電話番号(市外)。
     */
    public String getMobilePhoneNumberAreaCode() {
        return mobilePhoneNumberAreaCode;
    }

    /**
     * 携帯電話番号(市外)を設定する。
     *
     * @param mobilePhoneNumberAreaCode 設定する携帯電話番号(市外)。
     */
    public void setMobilePhoneNumberAreaCode(String mobilePhoneNumberAreaCode) {
        this.mobilePhoneNumberAreaCode = mobilePhoneNumberAreaCode;
    }

    /**
     * 携帯電話番号(市内)を取得する。
     *
     * @return 携帯電話番号(市内)。
     */
    public String getMobilePhoneNumberCityCode() {
        return mobilePhoneNumberCityCode;
    }

    /**
     * 携帯電話番号(市内)を設定する。
     *
     * @param mobilePhoneNumberCityCode 設定する携帯電話番号(市内)。
     */
    public void setMobilePhoneNumberCityCode(String mobilePhoneNumberCityCode) {
        this.mobilePhoneNumberCityCode = mobilePhoneNumberCityCode;
    }

    /**
     * 携帯電話番号(加入)を取得する。
     *
     * @return 携帯電話番号(加入)。
     */
    public String getMobilePhoneNumberSbscrCode() {
        return mobilePhoneNumberSbscrCode;
    }

    /**
     * 携帯電話番号(加入)を設定する。
     *
     * @param mobilePhoneNumberSbscrCode 設定する携帯電話番号(加入)。
     */
    public void setMobilePhoneNumberSbscrCode(String mobilePhoneNumberSbscrCode) {
        this.mobilePhoneNumberSbscrCode = mobilePhoneNumberSbscrCode;
    }


    /**
     * 登録者IDを取得する。
     *
     * @return 登録者ID。
     */
    public String getInsertUserId() {
        return insertUserId;
    }

    /**
     * 登録者IDを設定する。
     *
     * @param insertUserId 設定する登録者ID。
     */
    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    /**
     * 登録日時を取得する。
     *
     * @return 登録日時。
     */
    public Timestamp getInsertDate() {
        return insertDate;
    }

    /**
     * 登録日時を設定する。
     *
     * @param insertDate 設定する登録日時。
     */
    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * 更新者IDを取得する。
     *
     * @return 更新者ID。
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * 更新者IDを設定する。
     *
     * @param updatedUserId 設定する更新者ID。
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    /**
     * 更新日時を取得する。
     *
     * @return 更新日時。
     */
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 更新日時を設定する。
     *
     * @param updatedDate 設定する更新日時。
     */
    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * Mapを引数にとるコンストラクタ。
     *
     * @param params 項目名をキーとし、項目値を値とするMap。
     */
    public UsersEntity(Map<String, Object> params) {
        userId = (String) params.get("userId");
        kanjiName = (String) params.get("kanjiName");
        kanaName = (String) params.get("kanaName");
        mailAddress = (String) params.get("mailAddress");
        extensionNumberBuilding = (String) params.get("extensionNumberBuilding");
        extensionNumberPersonal = (String) params.get("extensionNumberPersonal");
        mobilePhoneNumberAreaCode = (String) params.get("mobilePhoneNumberAreaCode");
        mobilePhoneNumberCityCode = (String) params.get("mobilePhoneNumberCityCode");
        mobilePhoneNumberSbscrCode = (String) params.get("mobilePhoneNumberSbscrCode");
    }
}

