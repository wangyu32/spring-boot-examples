package com.neo.test;

import com.baiwang.cloud.model.base.Interface;
import com.baiwang.cloud.model.business.fpcx.request.FpcxRequest;
import com.baiwang.cloud.model.business.fpcx.response.FpcxResponse;
import com.baiwang.cloud.model.business.yhdzjg.request.YhdzJgRequest;
import com.baiwang.cloud.model.business.yhdzjg.response.YhdzJgResponse;
import com.baiwang.cloud.model.business.yhdztj.request.YhdzTjRequest;
import com.baiwang.cloud.model.business.yhdztj.response.YhdzTjResponse;
import com.baiwang.cloud.model.sign.Signature;
import com.baiwang.cloud.model.business.cljg.request.CljgRequest;
import com.baiwang.cloud.model.business.cljg.response.CljgResponse;
import com.baiwang.cloud.util.JaxbUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 11:24
 */
public class XmlToJavaBeanTest {

    public static void main(String[] args) throws Exception{

//        sign();
//        test2();
//        REQUEST_FPCXJS_1();
//        REQUEST_FPCXJS_2();
//        FPCXJS_RESPONSE_1();
//        FPCXJS_RESPONSE_2();

//        REQUEST_YWJG();
//        RESPONSE_YWJG_1();
//        RESPONSE_YWJG_2();

//        REQUEST_YHDZ_TJ();
//        RESPONSE_YHDZ_TJ();

//        REQUEST_YHDZ_JG();
//        RESPONSE_YHDZ_JG_1();
        RESPONSE_YHDZ_JG_2();

    }

    private static void RESPONSE_YHDZ_JG_2() throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "    <code>0000</code>\n" +
                "    <message>成功</message>\n" +
                "    <Data size=\"2\">\n" +
                "        <YHMX>\n" +
                "            <QQLSH>银行请求流水号</QQLSH>\n" +
                "            <ERRCODE>该流水错误代码</ERRCODE>\n" +
                "        </YHMX>\n" +
                "        <YHMX>\n" +
                "            <QQLSH>银行请求流水号2</QQLSH>\n" +
                "            <ERRCODE>该流水错误代码2</ERRCODE>\n" +
                "        </YHMX>\n" +
                "    </Data>\n" +
                "</response>";
        System.out.println(xml);
        YhdzJgResponse bean = JaxbUtil.xmlToBean(xml, YhdzJgResponse.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void RESPONSE_YHDZ_JG_1() throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "    <code>0000</code>\n" +
                "    <message>成功</message>\n" +
                "    <Data size=\"1\">\n" +
                "        <YHMX>\n" +
                "            <QQLSH>银行请求流水号</QQLSH>\n" +
                "            <ERRCODE>该流水错误代码</ERRCODE>\n" +
                "        </YHMX>\n" +
                "    </Data>\n" +
                "</response>";
        System.out.println(xml);
        YhdzJgResponse bean = JaxbUtil.xmlToBean(xml, YhdzJgResponse.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }


    private static void REQUEST_YHDZ_JG() throws Exception{
        String xml = "<REQUEST_YHDZ_JG>\n" +
                "\t<DZLSH>对账流水号</DZLSH>\n" +
                "</REQUEST_YHDZ_JG>\n";
        System.out.println(xml);
        YhdzJgRequest bean = JaxbUtil.xmlToBean(xml, YhdzJgRequest.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void RESPONSE_YHDZ_TJ() throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<response>\n" +
                "<code>0000</code>\n" +
                "<message>成功</message>\n" +
                "</response>\n";
        System.out.println(xml);
        YhdzTjResponse bean = JaxbUtil.xmlToBean(xml, YhdzTjResponse.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void REQUEST_YHDZ_TJ() throws Exception{
        String xml = "<REQUEST_YHDZ_TJ>\n" +
                "    <DZLSH>对账流水号</DZLSH>\n" +
                "    <DZJZRQ>2016-01-02</DZJZRQ>\n" +
                "    <DZBZ>1</DZBZ>\n" +
                "    <DZMXS size=\"2\">\n" +
                "        <DZMX>\n" +
                "            <QQLSH>请求流水号</QQLSH>\n" +
                "            <CLJG>结汇结果</CLJG>\n" +
                "            <JE>结汇金额</JE>\n" +
                "        </DZMX>\n" +
                "        <DZMX>\n" +
                "            <QQLSH>请求流水号</QQLSH>\n" +
                "            <CLJG>结汇结果</CLJG>\n" +
                "            <JE>结汇金额</JE>\n" +
                "        </DZMX>\n" +
                "    </DZMXS>\n" +
                "</REQUEST_YHDZ_TJ>";
        System.out.println(xml);
        YhdzTjRequest bean = JaxbUtil.xmlToBean(xml, YhdzTjRequest.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void RESPONSE_YWJG_2() throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "    <code>0000</code>\n" +
                "    <message>成功</message>\n" +
                "    <Data>\n" +
                "        <QQLSH>请求流水号</QQLSH>\n" +
                "        <FPMXS size=\"2\">\n" +
                "            <FPMX>\n" +
                "                <FPDM>发票代码</FPDM>\n" +
                "                <FPHM>发票号码</FPHM>\n" +
                "                <FPXZM>发票下载码</FPXZM>\n" +
                "            </FPMX>\n" +
                "            <FPMX>\n" +
                "                <FPDM>发票代码2</FPDM>\n" +
                "                <FPHM>发票号码2</FPHM>\n" +
                "                <FPXZM>发票下载码2</FPXZM>\n" +
                "            </FPMX>\n" +
                "        </FPMXS>\n" +
                "    </Data>\n" +
                "</response>\n";
        System.out.println(xml);
        CljgResponse bean = JaxbUtil.xmlToBean(xml, CljgResponse.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void RESPONSE_YWJG_1() throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "    <code>0000</code>\n" +
                "    <message>成功</message>\n" +
                "    <Data>\n" +
                "        <QQLSH>请求流水号</QQLSH>\n" +
                "        <FPMXS size=\"1\">\n" +
                "            <FPMX>\n" +
                "                <FPDM>发票代码</FPDM>\n" +
                "                <FPHM>发票号码</FPHM>\n" +
                "                <FPXZM>发票下载码</FPXZM>\n" +
                "            </FPMX>\n" +
                "        </FPMXS>\n" +
                "    </Data>\n" +
                "</response>\n";
        System.out.println(xml);
        CljgResponse bean = JaxbUtil.xmlToBean(xml, CljgResponse.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void REQUEST_YWJG() throws Exception{
        String xml = "<REQUEST_YWJG>\n" +
                "<QQLSH>请求流水号</QQLSH>\n" +
                "<CLJG>结汇结果</CLJG>\n" +
                "<JE>结汇金额</JE>\n" +
                "</REQUEST_YWJG>\n";
        System.out.println(xml);
        CljgRequest bean = JaxbUtil.xmlToBean(xml, CljgRequest.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void FPCXJS_RESPONSE_2() throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<response>\n" +
                "    <code>0000</code>\n" +
                "    <message>金额冻结成功</message>\n" +
                "    <Data>\n" +
                "        <QQLSH>请求流水号</QQLSH>\n" +
                "        <PTLSH>平台业务流水号</PTLSH>\n" +
                "        <BB>币种</BB>\n" +
                "        <FPMXS size=\"2\">\n" +
                "            <FPMX>\n" +
                "                <FPDM>发票代码</FPDM>\n" +
                "                <FPHM>发票号码</FPHM>\n" +
                "                <ZJE>返回状态1002时，显示票面总金额</ZJE>\n" +
                "                <JE>返回状态为1002时，显示可用余额</JE>\n" +
                "                <YHZH>发票销售方银行账户及名称</YHZH>\n" +
                "            </FPMX>\n" +
                "            <FPMX>\n" +
                "                <FPDM>发票代码1</FPDM>\n" +
                "                <FPHM>发票号码2</FPHM>\n" +
                "                <ZJE>返回状态1002时，显示票面总金额</ZJE>\n" +
                "                <JE>返回状态为1002时，显示可用余额</JE>\n" +
                "                <YHZH>发票销售方银行账户及名称</YHZH>\n" +
                "            </FPMX>\n" +
                "        </FPMXS>\n" +
                "    </Data>\n" +
                "</response>";
        System.out.println(xml);
        FpcxResponse bean = JaxbUtil.xmlToBean(xml, FpcxResponse.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void FPCXJS_RESPONSE_1() throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<response>\n" +
                "    <code>0000</code>\n" +
                "    <message>金额冻结成功</message>\n" +
                "    <Data>\n" +
                "        <QQLSH>请求流水号</QQLSH>\n" +
                "        <PTLSH>平台业务流水号</PTLSH>\n" +
                "        <BB>币种</BB>\n" +
                "        <FPMXS size=\"1\">\n" +
                "            <FPMX>\n" +
                "                <FPDM>发票代码</FPDM>\n" +
                "                <FPHM>发票号码</FPHM>\n" +
                "                <ZJE>返回状态1002时，显示票面总金额</ZJE>\n" +
                "                <JE>返回状态为1002时，显示可用余额</JE>\n" +
                "                <YHZH>发票销售方银行账户及名称</YHZH>\n" +
                "            </FPMX>\n" +
                "        </FPMXS>\n" +
                "    </Data>\n" +
                "</response>";
        System.out.println(xml);
        FpcxResponse bean = JaxbUtil.xmlToBean(xml, FpcxResponse.class);
        System.out.println(bean);
        System.out.println(JaxbUtil.beanToXml(bean));
    }

    private static void REQUEST_FPCXJS_2() throws Exception {
        String xml =
                "<REQUEST_FPCXJS>\n" +
                "<QQLSH>请求流水号</QQLSH>\n" +
                "<NSRSBH>纳税人识别号</NSRSBH>\n" +
                "<ZJE>200.02</ZJE>\n" +
                "<BB>币种</BB>\n" +
                "<FPMXS size=\"2\">\n" +
                "\t\t<FPMX>\n" +
                "\t\t\t<FPDM>发票代码</FPDM>\n" +
                "\t\t\t<FPHM>发票号码</FPHM>\n" +
                "\t\t\t<JE>100.00</JE>\n" +
                "\t\t</FPMX>\n" +
                "\t\t<FPMX>\n" +
                "\t\t\t<FPDM>发票代码1</FPDM>\n" +
                "\t\t\t<FPHM>发票号码1</FPHM>\n" +
                "\t\t\t<JE>100.02</JE>\n" +
                "\t\t</FPMX>\n" +
                "</FPMXS>\n" +
                "</REQUEST_FPCXJS>";
        try {
            System.out.println(xml);
            FpcxRequest bean = JaxbUtil.xmlToBean(xml, FpcxRequest.class);
            System.out.println(bean);
            System.out.println(JaxbUtil.beanToXml(bean));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void REQUEST_FPCXJS_1() throws Exception {
        String xml =
                "<REQUEST_FPCXJS>\n" +
                "<QQLSH>请求流水号</QQLSH>\n" +
                "<NSRSBH>纳税人识别号</NSRSBH>\n" +
                "<ZJE>总结算金额</ZJE>\n" +
                "<BB>币种</BB>\n" +
                "<FPMXS size=\"1\">\n" +
                "\t\t<FPMX>\n" +
                "\t\t\t<FPDM>发票代码</FPDM>\n" +
                "\t\t\t<FPHM>发票号码</FPHM>\n" +
                "\t\t\t<JE>结算金额</JE>\n" +
                "\t\t</FPMX>\n" +
                "</FPMXS>\n" +
                "</REQUEST_FPCXJS>";
        try {
            System.out.println(xml);
            FpcxRequest bean = JaxbUtil.xmlToBean(xml, FpcxRequest.class);
            System.out.println(bean);
            System.out.println(JaxbUtil.beanToXml(bean));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test2() throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<interface>\n" +
                "<globalInfo>\n" +
                "<version>接口版本</version>\n" +
                "<interfaceCode>接口编码</interfaceCode>\n" +
                "</globalInfo>\n" +
                "<Data>\n" +
                "<content>银行发起的请求内容</content>\n" +
                "</Data>\n" +
                "</interface>";

        try {
            System.out.println(xml);
            Interface bean = JaxbUtil.xmlToBean(xml, Interface.class);
            System.out.println(bean);
            System.out.println(JaxbUtil.beanToXml(bean));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sign() throws Exception {
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
            System.out.println(JaxbUtil.beanToXml(signature));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
