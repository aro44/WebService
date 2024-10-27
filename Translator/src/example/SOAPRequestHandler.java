package example;

import javax.xml.soap.*;

public class SOAPRequestHandler {
    private static final String ENDPOINT_URL = "http://fy.webxml.com.cn/webservices/EnglishChinese.asmx";

    public SOAPMessage createSOAPRequest(String methodName, String wordKey) throws Exception {
        // 创建SOAP消息和SOAP信封
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // 创建SOAP信封
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("web", "http://fy.webxml.com.cn/webservices/");

        // 创建SOAP请求体
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement(methodName, "web");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("wordKey", "web");
        soapBodyElem1.addTextNode(wordKey);

        soapMessage.saveChanges();

        return soapMessage;
    }

    public String sendRequest(SOAPMessage soapMessage) throws Exception {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // 发送SOAP请求
        SOAPMessage soapResponse = soapConnection.call(soapMessage, ENDPOINT_URL);
        return getSOAPResponse(soapResponse);
    }

    private String getSOAPResponse(SOAPMessage soapResponse) throws Exception {
        SOAPBody responseBody = soapResponse.getSOAPBody();
        // 从响应中提取结果
        if (responseBody.hasFault()) {
            // 有错误处理
            return "Error: " + responseBody.getFault().getFaultString();
        }
        return responseBody.getTextContent();
    }
}