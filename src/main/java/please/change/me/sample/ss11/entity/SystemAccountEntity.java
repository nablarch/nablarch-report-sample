package please.change.me.sample.ss11.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import nablarch.core.db.statement.autoproperty.CurrentDateTime;
import nablarch.core.db.statement.autoproperty.UserId;
import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;

/**
 * システムアカウントテーブルの情報を保持するクラス。<br>
 *
 * @author Miki Habu
 */
public class SystemAccountEntity implements Serializable {

    /** シリアルバージョン */
    private static final long serialVersionUID = -6395280344255490522L;

    /** 認可単位(権限設定)。 */
    private String[] permissionUnit;

    /** ユーザID。 */
    private String userId;

    /** ログインID。 */
    private String loginId;

    /** パスワード。 */
    private String password;

    /** ユーザIDロック。 */
    private String userIdLocked;

    /** パスワード有効期限。 */
    private String passwordExpirationDate;

    /** 認証失敗回数。 */
    private Integer failedCount;

    /** ユーザ有効期限(FROM)。 */
    private String effectiveDateFrom;

    /** ユーザ有効期限(TO)。 */
    private String effectiveDateTo;

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

    /** バージョン番号 */
    private Long version;

    /** デフォルトコンストラクタ。 */
    public SystemAccountEntity() {
    }

    /**
     * Mapを引数にとるコンストラクタ。
     *
     * @param params 項目名をキーとし、項目値を値とするMap
     */
    public SystemAccountEntity(Map<String, Object> params) {
        userId = (String) params.get("userId");
        loginId = (String) params.get("loginId");
        password = (String) params.get("password");
        userIdLocked = (String) params.get("userIdLocked");
        passwordExpirationDate = (String) params.get("passwordExpirationDate");
        failedCount = (Integer) params.get("failedCount");
        effectiveDateFrom = (String) params.get("effectiveDateFrom");
        effectiveDateTo = (String) params.get("effectiveDateTo");
        permissionUnit = (String[]) params.get("permissionUnit");
    }


    /**
     * 認可単位(権限設定)を取得する。
     *
     * @return 認可単位
     */
    public String[] getPermissionUnit() {
        return permissionUnit;
    }

    /**
     * 認可単位(権限設定)を設定する。
     *
     * @param permissionUnit 設定する認可単位(権限設定)
     */
    public void setPermissionUnit(String[] permissionUnit) {
        this.permissionUnit = permissionUnit;
    }

    /** 認可単位ID比較時に実施するバリデーション */
    private static final String[] COMPARE_PERMISSION_VALIDATE_PROPS = new String[]{"permissionUnit"};

    /**
     * 認可単位ID比較時に実施するバリデーション。
     *
     * @param context バリデーションの実行に必要なコンテキスト
     */
    @ValidateFor("comparePermission")
    public static void validateForComparePermission(ValidationContext<SystemAccountEntity> context) {
        // 認可単位のみ精査
        ValidationUtil.validate(context, COMPARE_PERMISSION_VALIDATE_PROPS);
    }

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
     * @param userId 設定するユーザID。
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ログインIDを取得する。
     *
     * @return ログインID。
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * ログインIDを設定する。
     *
     * @param loginId 設定するログインID。
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * パスワードを取得する。
     *
     * @return パスワード。
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定する。
     *
     * @param password 設定するパスワード。
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ユーザIDロックを取得する。
     *
     * @return ユーザIDロック。
     */
    public String getUserIdLocked() {
        return userIdLocked;
    }

    /**
     * ユーザIDロックを設定する。
     *
     * @param userIdLocked 設定するユーザIDロック。
     */
    public void setUserIdLocked(String userIdLocked) {
        this.userIdLocked = userIdLocked;
    }

    /**
     * パスワード有効期限を取得する。
     *
     * @return パスワード有効期限。
     */
    public String getPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    /**
     * パスワード有効期限を設定する。
     *
     * @param passwordExpirationDate 設定するパスワード有効期限。
     */
    public void setPasswordExpirationDate(String passwordExpirationDate) {
        this.passwordExpirationDate = passwordExpirationDate;
    }

    /**
     * 認証失敗回数を取得する。
     *
     * @return 認証失敗回数。
     */
    public Integer getFailedCount() {
        return failedCount;
    }

    /**
     * 認証失敗回数を設定する。
     *
     * @param failedCount 設定する認証失敗回数。
     */
    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    /**
     * ユーザ有効期限(FROM)を取得する。
     *
     * @return ユーザ有効期限(FROM)。
     */
    public String getEffectiveDateFrom() {
        return effectiveDateFrom;
    }

    /**
     * ユーザ有効期限(FROM)を設定する。
     *
     * @param effectiveDateFrom 設定するユーザ有効期限(FROM)。
     */
    public void setEffectiveDateFrom(String effectiveDateFrom) {
        this.effectiveDateFrom = effectiveDateFrom;
    }

    /**
     * ユーザ有効期限(TO)を取得する。
     *
     * @return ユーザ有効期限(TO)。
     */
    public String getEffectiveDateTo() {
        return effectiveDateTo;
    }

    /**
     * ユーザ有効期限(TO)を設定する。
     *
     * @param effectiveDateTo 設定するユーザ有効期限(TO)。
     */
    public void setEffectiveDateTo(String effectiveDateTo) {
        this.effectiveDateTo = effectiveDateTo;
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
     * バージョン番号を取得する。
     *
     * @return バージョン番号
     */
    public Long getVersion() {
        return version;
    }

    /**
     * バージョン番号を設定する。
     *
     * @param version バージョン番号
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}

