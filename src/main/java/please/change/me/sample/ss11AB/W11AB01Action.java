package please.change.me.sample.ss11AB;

import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;

/**
 * メニュー画面のアクションクラス。
 * 
 * @author Masayuki Fujikuma
 */
public class W11AB01Action {

    /**
     * メニュー画面を表示する。
     * 
     * @param request リクエスト
     * @param context リクエストコンテキスト
     * @return HttpResponse HTTPレスポンス
     */
    public HttpResponse doRW11AB0101(HttpRequest request, ExecutionContext context) {
        return new HttpResponse("/ss11AB/W11AB0101.jsp");
    }

}
