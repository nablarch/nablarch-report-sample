package please.change.me.sample.ss11.entity;

import java.sql.Timestamp;
import java.util.Map;

import please.change.me.core.db.statement.autoproperty.ExecutionId;

import nablarch.core.db.statement.autoproperty.CurrentDateTime;
import nablarch.core.db.statement.autoproperty.RequestId;
import nablarch.core.db.statement.autoproperty.UserId;

/**
 * 削除ユーザ情報メッセージ送信エンティティ
 *
 * @author hisaaki sioiri
 */
public class DeleteUserSendMessage {

    /** 送信メッセージ連番 */
    private String sendMessageSequence;

    /** ユーザID */
    private String userId;

    /** 漢字名称 */
    private String kanjiName;

    /** カナ名称 */
    private String kanaName;

    /** ステータス */
    private String status;

    /** 登録ユーザID */
    @UserId
    private String insertUserId;

    /** 登録日時 */
    @CurrentDateTime
    private Timestamp insertDate;

    /** 登録リクエストID */
    @RequestId
    private String insertRequestId;

    /** 登録実行時ID */
    @ExecutionId
    private String insertExecutionId;

    /** 更新ユーザID */
    @UserId
    private String updatedUserId;

    /** 更新日時 */
    @CurrentDateTime
    private Timestamp updatedDate;

    /**
     * コンストラクタ。
     *
     * @param data 各プロパティのデータを保持したMap
     */
    public DeleteUserSendMessage(Map<String, Object> data) {
        sendMessageSequence = (String) data.get("sendMessageSequence");
        userId = (String) data.get("userId");
        kanjiName = (String) data.get("kanjiName");
        kanaName = (String) data.get("kanaName");
        status = (String) data.get("status");
        insertUserId = (String) data.get("insertUserId");
        insertDate = (Timestamp) data.get("insertDate");
        insertRequestId = (String) data.get("insertRequestId");
        insertExecutionId = (String) data.get("insertExecutionId");
        updatedUserId = (String) data.get("updatedUserId");
        updatedDate = (Timestamp) data.get("updatedDate");
    }

    /**
     * 送信連番を取得する。
     * @return 送信連番
     */
    public String getSendMessageSequence() {
        return sendMessageSequence;
    }

    /**
     * 送信連番を設定する。
     * @param sendMessageSequence 送信連番
     */
    public void setSendMessageSequence(String sendMessageSequence) {
        this.sendMessageSequence = sendMessageSequence;
    }

    /**
     * ユーザIDを取得する。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定する。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 漢字名称を取得する。
     * @return 漢字名称
     */
    public String getKanjiName() {
        return kanjiName;
    }

    /**
     * 漢字名称を設定する。
     * @param kanjiName 漢字名称
     */
    public void setKanjiName(String kanjiName) {
        this.kanjiName = kanjiName;
    }

    /**
     * カナ名称を取得する。
     * @return カナ名称
     */
    public String getKanaName() {
        return kanaName;
    }

    /**
     * カナ名称を設定する。
     * @param kanaName カナ名称
     */
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * ステータスを取得する。
     * @return ステータス
     */
    public String getStatus() {
        return status;
    }

    /**
     * ステータスを設定する。
     * @param status ステータス
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 登録ユーザIDを取得する。
     * @return 登録ユーザID
     */
    public String getInsertUserId() {
        return insertUserId;
    }

    /**
     * 登録ユーザIDを設定する。
     * @param insertUserId 登録ユーザID
     */
    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    /**
     * 登録日時を取得する。
     * @return 登録日時
     */
    public Timestamp getInsertDate() {
        return insertDate;
    }

    /**
     * 登録日時を設定する。
     * @param insertDate 登録日時
     */
    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    /**
     * 登録リクエストIDを取得する。
     * @return 登録リクエストID
     */
    public String getInsertRequestId() {
        return insertRequestId;
    }

    /**
     * 登録リクエストIDを設定する。
     * @param insertRequestId 登録リクエストID
     */
    public void setInsertRequestId(String insertRequestId) {
        this.insertRequestId = insertRequestId;
    }

    /**
     * 登録実行時IDを取得する。
     * @return 登録実行時ID
     */
    public String getInsertExecutionId() {
        return insertExecutionId;
    }

    /**
     * 登録実行時IDを設定する。
     * @param insertExecutionId 登録実行時ID
     */
    public void setInsertExecutionId(String insertExecutionId) {
        this.insertExecutionId = insertExecutionId;
    }

    /**
     * 更新ユーザIDを取得する。
     * @return 更新ユーザID
     */
    public String getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * 更新ユーザIDを設定する。
     * @param updatedUserId 更新ユーザID
     */
    public void setUpdatedUserId(String updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    /**
     * 更新日時を取得する。
     * @return 更新日時
     */
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 更新日時を設定する。
     * @param updatedDate 更新日時
     */
    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}

