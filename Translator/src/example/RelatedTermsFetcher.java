package example;

import javax.xml.soap.SOAPMessage;

public class RelatedTermsFetcher {
    private final SOAPRequestHandler soapRequestHandler;

    public RelatedTermsFetcher(SOAPRequestHandler soapRequestHandler) {
        this.soapRequestHandler = soapRequestHandler;
    }

    public String getRelatedTerms(String wordKey) {
        try {
            SOAPMessage soapMessage = soapRequestHandler.createSOAPRequest("TranslatorReferString", wordKey);
            return soapRequestHandler.sendRequest(soapMessage);
        } catch (Exception e) {
            return "查询错误: " + e.getMessage();
        }
    }
}
