package please.change.me.sample.ss11AC;

import java.util.Map;

import nablarch.core.util.StringUtil;
import nablarch.core.validation.PropertyName;
import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.Required;
import nablarch.core.validation.validator.unicode.SystemChar;
import nablarch.fw.web.HttpRequest;

/**
 * ユーザ検索フォーム。
 *
 * @author Naoki Tamura
 */
public class W11AC01Form extends W11AC01FormBase {

    /**
     * シリアルバージョン
     */
    private static final long serialVersionUID = 1L;
    
    /** ユーザID */
    private String userId;

    /**
     * コンストラクタ
     *
     * @param params パラメータ
     */
    public W11AC01Form(Map<String, Object> params) {
        super(params);
        userId = (String) params.get("userId");
    }

    /**
     * バリデーションを実施する。
     *
     * @param req 入力パラメータ情報
     * @param validationName 使用するバリデーションの名前
     * @return 入力パラメータを精査後に生成した本フォーム
     */
    public static W11AC01Form validate(HttpRequest req, String validationName) {
        ValidationContext<W11AC01Form> context = ValidationUtil.validateAndConvertRequest(
                "11AC_W11AC01", W11AC01Form.class, req, validationName);
        context.abortIfInvalid();
        return context.createObject();
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
    @PropertyName("ユーザID")
    @Required
    @Length(min = 10, max = 10)
    @SystemChar(charsetDef = "numericCharset")
    public void setUserId(String userId) {
        this.userId = userId;
    }


    /** 精査対象プロパティ */
    private static final String[] SEARCH_CONDITION_PROPS = {"loginId", "kanjiName", "kanaName", "ugroupId", "userIdLocked", "pageNumber", "sortId"};

    /**
     * 検索条件の精査対象プロパティを返す。
     *
     * @return 検索条件の精査対象プロパティ
     */
    public String[] getSearchConditionProps() {
        return SEARCH_CONDITION_PROPS;
    }

    /**
     * 検索条件を精査する。
     *
     * @param context ValidationContext
     */
    @ValidateFor("search")
    public static void validateForSearch(ValidationContext<W11AC01Form> context) {
        // 単項目精査
        ValidationUtil.validate(context, SEARCH_CONDITION_PROPS);
        if (!context.isValid()) {
            return;
        }

        W11AC01Form form = context.createObject();
        if (!form.isValidSearchCondition()) {
            context.addMessage("MSG00006");
        }
    }

    /**
     * ユーザ選択時のパラメータを精査する。
     *
     * @param context ValidationContext
     */
    @ValidateFor("selectUserInfo")
    public static void validateForSelectUser(ValidationContext<W11AC01FormBase> context) {
        // 単項目精査
        ValidationUtil.validate(context, new String[]{"userId"});
    }

    /**
     * 検索条件が妥当かどうか確認する。<br/>
     * 検索条件のうち、少なくとも１つは指定されていることを確認する。
     *
     * @return 妥当な場合は真、そうでない場合は偽
     */
    private boolean isValidSearchCondition() {
        return StringUtil.hasValue(
                getLoginId(),
                getKanjiName(),
                getKanaName(),
                getUgroupId(),
                getUserIdLocked());
    }
}

