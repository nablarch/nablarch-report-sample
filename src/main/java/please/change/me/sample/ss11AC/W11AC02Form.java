package please.change.me.sample.ss11AC;

import java.util.Map;

import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.fw.web.HttpRequest;

/**
 * ユーザ登録フォーム。
 * 
 * @author Naoki Tamura
 */
public class W11AC02Form extends W11AC02FormBase {

    /** コンストラクタ。 */
    public W11AC02Form() {
    }

    /**
     * Mapを引数にとるコンストラクタ。
     * 
     * @param params
     *            項目名をキーとし、項目値を値とするMap
     */
    public W11AC02Form(Map<String, Object> params) {
        super(params);
    }

    /**
     * バリデーションを実施する。
     * 
     * @param req
     *            入力パラメータ情報
     * @param validationName
     *            使用するバリデーションの名前
     * @return 入力パラメータを精査後に生成した本フォーム
     */
    public static W11AC02Form validate(HttpRequest req, String validationName) {
        ValidationContext<W11AC02Form> context = ValidationUtil
                .validateAndConvertRequest("W11AC02", W11AC02Form.class, req,
                        validationName);
        context.abortIfInvalid();
        return context.createObject();
    }

    /**
     * 帳票出力時に実施するバリデーション
     * 
     * @param context
     *            バリデーションの実行に必要なコンテキスト
     */
    @ValidateFor("pdf")
    public static void validateForPdf(ValidationContext<W11AC02Form> context) {
        ValidationUtil.validate(context, new String[]{"loginId"});
        if (!context.isValid()) {
            return;
        }
    }
}
