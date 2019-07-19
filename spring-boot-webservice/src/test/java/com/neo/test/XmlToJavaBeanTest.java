package com.neo.test;

import com.baiwang.cloud.model.request.Signature;
import com.baiwang.cloud.util.JaxbUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 11:24
 */
public class XmlToJavaBeanTest {

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\">\n" +
                "\t<SignedInfo>\n" +
                "\t\t<SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>\n" +
                "\t\t<Reference URI=\"#001\">\n" +
                "\t\t</Reference>\n" +
                "\t</SignedInfo>\n" +
                "\t<SignatureValue>MIIFiAYJKoZIhvcNAQcCoIIFeTCCBXUCAQExCzAJBgUrDgMCGgUAMAsGCSqGSIb3DQEHAaCCB0HVZIChKEfL51n745VI0l1g8zeqH6utZd+GQ==</SignatureValue>\n" +
                "\t<KeyInfo>\n" +
                "\t\t<KeyName>95566SW09999999123</KeyName>\n" +
                "\t</KeyInfo>\n" +
                "\t<Object id=\"001\">\n" +
                "\t\t<SignedData>\n" +
                "EU+PC9CVVNJTkVTU19UWVBFPjxEQlRfQ09ERVRZUEU+MzM8L0RCVF9D\n" +
                "T0RFVFlQRT48REJUX0NPREU+NzY2OTE4OTIzPC9EQlRfQ09ERT48RFJBQ0NfTk8+NDUzMzU4ODg3\n" +
                "ODgwPC9EUkFDQ19OTz48U1BUMT5odHRwOi8vMTE2LjIzNi4yMTIuMTU1OjgwMDEvdG1zX3NlcnZl\n" +
                "ci9QYXltZW50UmVzcFNlcnZsZXQ8L1NQVDE+PFNQVDI+PC9TUFQyPjxTUFQzPjwvU1BUMz48L0RS\n" +
                "QUNDX1FVUl9SRVFVRVNUPg=</SignedData>\n" +
                "\t</Object>\n" +
                "</Signature>\n";

        try {
//            XStream xstream = new XStream();
//            Signature signature1 = (Signature) xstream.fromXML(xml);

//            Object object = JaxbUtil.xmlToBean(xml, Object.class);
//            System.out.println(object);
            System.out.println(xml);
            Signature signature = JaxbUtil.xmlToBean(xml, Signature.class);
            System.out.println(signature);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
