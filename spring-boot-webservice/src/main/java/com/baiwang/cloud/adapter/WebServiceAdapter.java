package com.baiwang.cloud.adapter;

//import com.baiwang.knight.service.model.BodyModel;
//import com.baiwang.knight.service.model.HeadModel;
//import com.baiwang.knight.service.model.MessageType;
//import com.baiwang.knight.service.model.ParamWrapper;
//import com.baiwang.knight.service.model.content.ContentResponse;
//import com.baiwang.knight.service.model.content.ImportFlowSheetRequest;
//import com.baiwang.knight.service.model.content.TraceInfo;
//import com.baiwang.knight.service.util.json.BWJSONObject;
//import com.baiwang.knight.service.util.json.JSONException;
//import com.baiwang.knight.service.util.json.XML;
//import com.baiwang.knight.service.util.json.XMLParserConfiguration;
import com.baiwang.cloud.model.sign.Signature;
import com.baiwang.cloud.util.JaxbUtil;
import com.baiwang.cloud.util.NullUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * WebService适配器
 * @author liujp
 * @date 2018/12/24
 */
@Slf4j
@WebService(serviceName = "WebServiceAdapter", targetNamespace = "http://adapter.entrance.finance.baiwang.com")
@Component
public class WebServiceAdapter
        extends AbstractAdapter
{

    @WebMethod
    public String service(@WebParam(name = "service") String message) {
        log.info("请求报文：{}", message);

        //1. message 非空校验
        if(NullUtil.isNull(message)){
            log.error("请求报文为空：{}", message);
            return "请求报文为空";
        }

        try {
            Signature signature = JaxbUtil.xmlToBean(message.trim(), Signature.class);
            log.info("signature covert to xml : \n{}", JaxbUtil.beanToXml(signature));

            //2.报文校验

        } catch (JAXBException e) {
            log.error("请求报文格式错误", e);
            return "请求报文格式错误";
        } catch (IOException e) {
            log.error("请求报文格式错误", e);
            return "请求报文格式错误";
        }
        return "";
    }

//    /**
//     * 流水单导入
//     * @param head
//     * @param body
//     * @param content
//     * @return
//     */
//    @WebMethod
//    public ContentResponse ImportFlowSheet(@WebParam(name = "head") HeadModel head, @WebParam(name = "body") BodyModel body, @WebParam(name = "content") ImportFlowSheetRequest content) {
//        log.info(head.toString());
//        log.info(body.toString());
//        log.info(content.toString());
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("head", head);
//        jsonObject.put("body", body);
//        jsonObject.put("content", content);
//
//        JSONObject resultJson = this.doDispatch(jsonObject);
//        JSONObject contentJ = resultJson.getJSONObject("content");
//
//        ContentResponse response = new ContentResponse();
//        response.setTotal(contentJ.getString("total"));
//        response.setCode(contentJ.getString("code"));
//        response.setData(contentJ.getString("data"));
//        response.setSuccess(contentJ.getBoolean("success"));
//        response.setMessage(contentJ.getString("message"));
//
//        JSONObject tr = contentJ.getJSONObject("traceInfo");
//        TraceInfo traceInfo = new TraceInfo();
//        traceInfo.setTraceId(tr.getString("traceId"));
//        traceInfo.setIp(tr.getString("ip"));
//        traceInfo.setDate(tr.getString("date"));
//
//        response.setTraceInfo(traceInfo);
//        return response;
//    }
//
//
//    private JSONObject getJsonObject(String message) {
//        try {
//            BWJSONObject bwjsonObject = XML.toJSONObject(message);
//            return JSON.parseObject(bwjsonObject.getJSONObject("request").toString());
//        } catch (JSONException e) {
//            log.error("请求xml报文解析出错！原因：" + e);
//            throw e;
//        }
//    }
//
//    @Override
//    public void setMessageType(ParamWrapper paramWrapper) {
//        paramWrapper.setMessageType(MessageType.XML);
//    }
}