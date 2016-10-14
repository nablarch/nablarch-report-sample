package please.change.me.sample.ss11AC;

import java.util.HashMap;
import java.util.Map;

import nablarch.common.code.validator.CodeValue;
import nablarch.core.db.support.ListSearchInfo;
import nablarch.core.validation.PropertyName;
import nablarch.core.validation.convertor.Digits;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.NumberRange;
import nablarch.core.validation.validator.Required;
import nablarch.core.validation.validator.unicode.SystemChar;

/**
 * ユーザ情報一覧照会フォーム。
 *
 * @author 
 */
public abstract class W11AC01FormBase extends ListSearchInfo {

    //---- プロパティ ----//

    /** ログインID */
    private String loginId;

    /** 漢字氏名 */
    private String kanjiName;

    /** カナ氏名 */
    private String kanaName;

    /** グループ */
    private String ugroupId;

    /** ユーザIDロック */
    private String userIdLocked;

    //---- コンストラクタ ----//

    /** デフォルトコンストラクタ。 */
    public W11AC01FormBase() {
    }

    /**
     * Mapを引数にとるコンストラクタ。
     *
     * @param params 項目名をキーとし、項目値を値とするMap
     */
    public W11AC01FormBase(Map<String, Object> params) {

        loginId = (String) params.get("loginId");
        kanjiName = (String) params.get("kanjiName");
        kanaName = (String) params.get("kanaName");
        ugroupId = (String) params.get("ugroupId");
        userIdLocked = (String) params.get("userIdLocked");
        setPageNumber((Integer) params.get("pageNumber"));
        setSortId((String) params.get("sortId"));

    }

    /**
     * プロパティの情報をMapに変換する。
     *
     * @return 変換後のMap
     */
    protected Map<String, Object> toMap() {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("loginId", loginId);
        result.put("kanjiName", kanjiName);
        result.put("kanaName", kanaName);
        result.put("ugroupId", ugroupId);
        result.put("userIdLocked", userIdLocked);
        result.put("pageNumber", getPageNumber());
        result.put("sortId", getSortId());
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
    @Length(max = 20)
    @SystemChar(charsetDef = "asciiCharset", allowLineSeparator = false)
    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
    @Length(max = 50)
    @SystemChar(charsetDef = "zenkakuKatakanaCharset", allowLineSeparator = false)
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
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
    @Length(max = 10, min = 10)
    @SystemChar(charsetDef = "numericCharset", allowLineSeparator = false)
    public void setUgroupId(String ugroupId) {
        this.ugroupId = ugroupId;
    }

    /**
     * ユーザIDロックを取得する。
     *
     * @return ユーザIDロック。
     */
    public String getUserIdLocked() {
        return this.userIdLocked;
    }

    /**
     * ユーザIDロックを設定する。
     *
     * @param userIdLocked 設定するユーザIDロック。
     *
     */
    @PropertyName("ユーザIDロック")
    @CodeValue(codeId = "C0000001", pattern = "PATTERN01")
    public void setUserIdLocked(String userIdLocked) {
        this.userIdLocked = userIdLocked;
    }

    /**
     * ページ番号を設定する。
     *
     * @param pageNumber ページ番号
     */
    @PropertyName("開始ページ")
    @Required
    @NumberRange(max = 10, min = 1)
    @Digits(integer = 2)
    public void setPageNumber(Integer pageNumber) {
        super.setPageNumber(pageNumber);
    }

    /**
     * ソートIDを設定する。
     *
     * @param sortId ソートID
     */
    @PropertyName("ソートID")
    @Required
    public void setSortId(String sortId) {
        super.setSortId(sortId);
    }
}
