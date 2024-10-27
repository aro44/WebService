package example;

import javax.xml.soap.SOAPMessage;

public class SentenceTranslator {
    private final SOAPRequestHandler soapRequestHandler;

    public SentenceTranslator(SOAPRequestHandler soapRequestHandler) {
        this.soapRequestHandler = soapRequestHandler;
    }

    public String translateSentence(String sentence) {
        try {
            SOAPMessage soapMessage = soapRequestHandler.createSOAPRequest("TranslatorSentence", sentence);
            return soapRequestHandler.sendRequest(soapMessage);
        } catch (Exception e) {
            return "翻译错误: " + e.getMessage();
        }
    }
}