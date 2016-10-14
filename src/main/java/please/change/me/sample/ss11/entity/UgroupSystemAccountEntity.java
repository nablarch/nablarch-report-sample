package please.change.me.sample.ss11.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import nablarch.core.db.statement.autoproperty.CurrentDateTime;
import nablarch.core.db.statement.autoproperty.UserId;

/**
 * グループシステムアカウントテーブルの情報を保持するクラス。
 *
 * @author Miki Habu
 */
public class UgroupSystemAccountEntity implements Serializable {

    /** シリアルバージョン */
    private static final long serialVersionUID = -291382376663682981L;

    /** ユーザID。 */
    private String userId;

    /** グループID。 */
    private String ugroupId;

    /** 有効期限(FROM)。 */
    private String effectiveDateFrom;

    /** 有効期限(TO)。 */
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

    /** デフォルトコンストラクタ。 */
    public UgroupSystemAccountEntity() {
    }

    /**
     * Mapを引数にとるコンストラクタ。
     *
     * @param params 項目名をキーとし、項目値を値とするMap
     */
    public UgroupSystemAccountEntity(Map<String, Object> params) {
        userId = (String) params.get("userId");
        ugroupId = (String) params.get("ugroupId");
        effectiveDateFrom = (String) params.get("effectiveDateFrom");
        effectiveDateTo = (String) params.get("effectiveDateTo");
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
     * グループIDを取得する。
     *
     * @return グループID。
     */
    public String getUgroupId() {
        return ugroupId;
    }

    /**
     * グループIDを設定する。
     *
     * @param ugroupId 設定するグループID。
     */
    public void setUgroupId(String ugroupId) {
        this.ugroupId = ugroupId;
    }

    /**
     * 有効期限(FROM)を取得する。
     *
     * @return 有効期限(FROM)。
     */
    public String getEffectiveDateFrom() {
        return effectiveDateFrom;
    }

    /**
     * 有効期限(FROM)を設定する。
     *
     * @param effectiveDateFrom 設定する有効期限(FROM)。
     */
    public void setEffectiveDateFrom(String effectiveDateFrom) {
        this.effectiveDateFrom = effectiveDateFrom;
    }

    /**
     * 有効期限(TO)を取得する。
     *
     * @return 有効期限(TO)。
     */
    public String getEffectiveDateTo() {
        return effectiveDateTo;
    }

    /**
     * 有効期限(TO)を設定する。
     *
     * @param effectiveDateTo 設定する有効期限(TO)。
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
}
