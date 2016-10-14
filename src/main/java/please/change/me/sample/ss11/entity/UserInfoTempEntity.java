package please.change.me.sample.ss11.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import nablarch.core.db.statement.autoproperty.CurrentDateTime;
import please.change.me.core.db.statement.autoproperty.ExecutionId;
import nablarch.core.db.statement.autoproperty.RequestId;
import nablarch.core.db.statement.autoproperty.UserId;
import nablarch.core.util.StringUtil;
import nablarch.core.validation.PropertyName;
import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.Required;
import nablarch.core.validation.validator.unicode.SystemChar;

/**
 * ユーザ情報テンポラリエンティティ
 *
 * @author hisaaki sioiri
 */
public class UserInfoTempEntity implements Serializable {

    /** シリアルバージョン */
    private static final long serialVersionUID = -3384825570660718200L;

    /** ユーザ情報ID */
    private String userInfoId;

    /** ログインID */
    private String loginId;

    /** 漢字名称 */
    private String kanjiName;

    /** かな名 */
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

    /** 登録者ID */
    @UserId
    private String insertUserId;

    /** 登録日時 */
    @CurrentDateTime
    private Timestamp insertDate;

    /** 更新者ID */
    @UserId
    private String updatedUserId;

    /** 更新日時 */
    @CurrentDateTime
    private Timestamp updatedDate;

    /** 登録リクエストID */
    @RequestId
    private String insertRequestId;

    /** 登録実行時ID */
    @ExecutionId
    private String insertExecutionId;

    /**
     * コンストラクタ。
     *
     * @param data データ
     */
    public UserInfoTempEntity(Map<String, Object> data) {
        userInfoId = (String) data.get("userInfoId");
        loginId = (String) data.get("loginId");
        kanjiName = (String) data.get("kanjiName");
        kanaName = (String) data.get("kanaName");
        mailAddress = (String) data.get("mailAddress");
        extensionNumberBuilding = (String) data.get("extensionNumberBuilding");
        extensionNumberPersonal = (String) data.get("extensionNumberPersonal");
        mobilePhoneNumberAreaCode = (String) data.get("mobilePhoneNumberAreaCode");
        mobilePhoneNumberCityCode = (String) data.get("mobilePhoneNumberCityCode");
        mobilePhoneNumberSbscrCode = (String) data.get("mobilePhoneNumberSbscrCode");
    }

    /**
     * ユーザ情報IDを取得する。
     *
     * @return ユーザ情報ID
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * ユーザ情報IDを設定する。
     *
     * @param userInfoId ユーザ情報ID
     */
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
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
    @PropertyName("ログインID")
    @Required
    @Length(max = 20)
    @SystemChar(charsetDef = "asciiCharset")
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
    @PropertyName("漢字氏名")
    @Required
    @Length(max = 50)
    @SystemChar(charsetDef = "zenkakuCharset")
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
    @PropertyName("カナ氏名")
    @Required
    @Length(max = 50)
    @SystemChar(charsetDef = "zenkakuKatakanaCharset")
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
    @PropertyName("メールアドレス")
    @Required
    @Length(max = 100)
    @SystemChar(charsetDef = "asciiCharset")
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
    @PropertyName("内線番号(ビル番号)")
    @Required
    @Length(max = 2)
    @SystemChar(charsetDef = "numericCharset")
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
    @PropertyName("内線番号(個人番号)")
    @Required
    @Length(max = 4)
    @SystemChar(charsetDef = "numericCharset")
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
    @PropertyName("携帯電話番号(市外)")
    @Length(max = 3)
    @SystemChar(charsetDef = "numericCharset")
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
    @PropertyName("携帯電話番号(市内)")
    @Length(max = 4)
    @SystemChar(charsetDef = "numericCharset")
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
    @PropertyName("携帯電話番号(加入)")
    @Length(max = 4)
    @SystemChar(charsetDef = "numericCharset")
    public void setMobilePhoneNumberSbscrCode(String mobilePhoneNumberSbscrCode) {
        this.mobilePhoneNumberSbscrCode = mobilePhoneNumberSbscrCode;
    }

    /**
     * 登録ユーザIDを取得する。
     *
     * @return 登録ユーザID
     */
    public String getInsertUserId() {
        return insertUserId;
    }

    /**
     * 登録ユーザIDを設定する。
     *
     * @param insertUserId 登録ユーザID
     */
    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    /**
     * 登録日時を取得する。
     *
     * @return 登録日時
     */
    public Timestamp getInsertDate() {
        return insertDate;
    }

    /**
     * 登録日時を設定する。
     *
     * @param insertDate 登録日時
     */
    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * 更新ユーザIDを取得する。
     *
     * @return 更新ユーザID
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * 更新ユーザIDを設定する。
     *
     * @param updatedUserId 更新ユーザID
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    /**
     * 更新日時を取得する。
     *
     * @return 更新日時
     */
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 更新日時を設定する。
     *
     * @param updatedDate 更新日時
     */
    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * リクエストIDを取得する。
     *
     * @return 更新リクエストID
     */
    public String getInsertRequestId() {
        return insertRequestId;
    }

    /**
     * リクエストIDを設定する。
     *
     * @param insertRequestId リクエストID
     */
    public void setInsertRequestId(String insertRequestId) {
        this.insertRequestId = insertRequestId;
    }

    /**
     * 実行時IDを取得する。
     *
     * @return 実行時ID
     */
    public String getInsertExecutionId() {
        return insertExecutionId;
    }

    /**
     * 実行時IDを設定する。
     *
     * @param insertExecutionId 実行時ID
     */
    public void setInsertExecutionId(String insertExecutionId) {
        this.insertExecutionId = insertExecutionId;
    }

    /**
     * ユーザ情報テンポラリ登録用の精査を行う。
     *
     * @param context バリデーションの実行に必要なコンテキスト
     */
    @ValidateFor("validateRegister")
    public static void validateForRegister(ValidationContext<UserInfoTempEntity> context) {
        // 共通項目以外を精査する。
        ValidationUtil.validateWithout(context,
                new String[]{"userInfoId", "insertUserId", "insertDate", "updatedUserId", "updatedDate",
                    "insertRequestId", "insertExecutionId"});

        if (!context.isValid()) {
            // 単項目精査でエラーがあった場合は、項目間精査は行わない。
            return;
        }

        //**********************************************************************
        // 以下項目間精査
        //**********************************************************************
        // 携帯電話番号の項目間精査を行う。
        UserInfoTempEntity userInfoTempEntity = context.createObject();
        if (!userInfoTempEntity.isValidateMobilePhoneNumbers()) {
            context.addResultMessage("mobilePhoneNumber", "MSG00004");
        }
    }


    /**
     * 携帯電話番号の項目間精査を行う。<br/>
     * 一部のみ入力されている場合、精査エラー
     *
     * @return 精査OKの場合は、true
     */
    private boolean isValidateMobilePhoneNumbers() {
        return isMobilePhoneNumberEmpty() || isMobilePhoneNumberComplete();
    }

    /**
     * 携帯電話番号が全て未入力であるか判定する。
     *
     * @return 全ての未入力の場合はtrue
     */
    private boolean isMobilePhoneNumberEmpty() {
        return StringUtil.isNullOrEmpty(mobilePhoneNumberAreaCode, mobilePhoneNumberCityCode,
                mobilePhoneNumberSbscrCode);
    }

    /**
     * 携帯電話番号が全て入力されているか判定する。
     *
     * @return 全て入力されている場合はtrue
     */
    private boolean isMobilePhoneNumberComplete() {
        return StringUtil.hasValue(mobilePhoneNumberAreaCode) && StringUtil.hasValue(mobilePhoneNumberCityCode)
                && StringUtil.hasValue(mobilePhoneNumberSbscrCode);
    }
}
