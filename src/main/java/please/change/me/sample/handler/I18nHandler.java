package please.change.me.sample.handler;

import nablarch.common.web.handler.threadcontext.LanguageAttributeInHttpUtil;
import nablarch.core.util.StringUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpRequestHandler;
import nablarch.fw.web.HttpResponse;

/**
 * 国際化対応ハンドラ。
 * @author Kiyohito Itoh
 */
public class I18nHandler implements HttpRequestHandler {

    /**
     * {@inheritDoc}
     * <p/>
     * リクエストパラメータから言語の取得を試み、言語が取得できた場合のみ
     * {@link LanguageAttributeInHttpUtil#keepLanguage(HttpRequest, ExecutionContext, String)}
     * メソッドを呼び出し言語の保持を行う。
     */
    public HttpResponse handle(HttpRequest request, ExecutionContext context) {
        String language = getLanguage(request, "language");
        if (StringUtil.hasValue(language)) {
            LanguageAttributeInHttpUtil.keepLanguage(request, context, language);
        }
        return context.handleNext(request);
    }
    
    /**
     * リクエストパラメータから言語を取得する。
     * @param request リクエスト
     * @param paramName 言語を送信するパラメータ名
     * @return 取得できた言語。取得できない場合はnull
     */
    private String getLanguage(HttpRequest request, String paramName) {
        if (!request.getParamMap().containsKey(paramName)) {
            return null;
        }
        return request.getParam(paramName)[0];
    }
}
