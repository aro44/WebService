package example;

import javax.xml.soap.SOAPMessage;

public class Translator {
    private final SOAPRequestHandler soapRequestHandler;

    public Translator(SOAPRequestHandler soapRequestHandler) {
        this.soapRequestHandler = soapRequestHandler;
    }

    public String translate(String wordKey) {
        try {
            SOAPMessage soapMessage = soapRequestHandler.createSOAPRequest("Translator", wordKey);
            return soapRequestHandler.sendRequest(soapMessage);
        } catch (Exception e) {
            return "翻译错误: " + e.getMessage();
        }
    }
}