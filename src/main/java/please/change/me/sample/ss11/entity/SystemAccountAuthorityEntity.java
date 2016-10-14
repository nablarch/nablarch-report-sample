package please.change.me.sample.ss11.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import nablarch.core.db.statement.autoproperty.CurrentDateTime;
import nablarch.core.db.statement.autoproperty.UserId;

/**
 * システムアカウント権限テーブルの情報を保持するクラス。
 *
 * @author Miki Habu
 */
public class SystemAccountAuthorityEntity implements Serializable {

    /** シリアルバージョン */
    private static final long serialVersionUID = -249781666362258488L;

    /** ユーザID。 */
    private String userId;

    /** 認可単位ID。 */
    private String permissionUnitId;

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

    /** デフォルトコンストラクタ。 */
    public SystemAccountAuthorityEntity() {
    }

    /**
     * Mapを引数にとるコンストラクタ。
     *
     * @param params 項目名をキーとし、項目値を値とするMap
     */
    public SystemAccountAuthorityEntity(Map<String, Object> params) {
        userId = (String) params.get("userId");
        permissionUnitId = (String) params.get("permissionUnitId");
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
     * 認可単位IDを取得する。
     *
     * @return 認可単位ID。
     */
    public String getPermissionUnitId() {
        return permissionUnitId;
    }

    /**
     * 認可単位IDを設定する。
     *
     * @param permissionUnitId 設定する認可単位ID。
     */
    public void setPermissionUnitId(String permissionUnitId) {
        this.permissionUnitId = permissionUnitId;
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
}
