package example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TranslatorService {

    @WebMethod
    public String translate(String wordKey) {
        // 实现翻译逻辑
        return "翻译结果"; // 示例返回
    }
}
