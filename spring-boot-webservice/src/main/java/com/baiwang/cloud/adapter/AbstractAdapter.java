package com.baiwang.cloud.adapter;

import com.alibaba.fastjson.JSONObject;
import com.baiwang.cloud.service.DispatchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Map;

/**
 * 适配器抽象类
 *
 * @author liujp
 * @date 2019/1/7
 */
@Slf4j
public abstract class AbstractAdapter
{
    @Autowired
    protected DispatchService dispatchService;
//
//    protected ParamWrapper getParamWrapper(JSONObject head, JSONObject content)
//    {
//        ParamWrapper paramWrapper = new ParamWrapper();
//        paramWrapper.setServiceCode(head.getString("serviceCode"));
//        paramWrapper.setSource(head.getString("requestSys"));
//        paramWrapper.setVersion(head.getString("version"));
//        paramWrapper.setRequestId(head.getString("requestId"));
//        paramWrapper.setRequestJson(content);
//        return paramWrapper;
//    }
//
//
//    protected JSONObject doDispatch(JSONObject requestJson)
//    {
//        log.info("标准Json请求入参：{}", requestJson);
//
//        JSONObject head = requestJson.getJSONObject("head");
//        JSONObject body = requestJson.getJSONObject("body");
//        JSONObject content = requestJson.getJSONObject("content");
//        JSONObject params = requestJson.getJSONObject("params");
//
//        JSONObject checkParamsResult = this.checkParams(head, body, content);
//        if (null != checkParamsResult)
//        {
//            return checkParamsResult;
//        }
//
//        String digestData = body.getString("digestData");
//
//        //Step-1 验证摘要
//        if (StringUtils.isNotBlank(digestData))
//        {
//
//        }
//
//        //Step-2 解密报文
//        if ("1".equals(body.getString("encryptCode")))
//        {
//
//        }
//
//        //Step-3 解压缩报文
//        if ("1".equals(body.getString("zipCode")))
//        {
//
//        }
//
//        //Step-1 设置入参
//        ParamWrapper paramWrapper = this.getParamWrapper(head, content);
//
//        paramWrapper.setParams(params);
//
//        this.setMessageType(paramWrapper);
//
//        //Step-2 请求处理
//        this.dispatchService.doService(paramWrapper);
//
//        //Step-3 设置返回head
//        JSONObject responseJson = paramWrapper.getResponseJson();
//
//        this.setResponseHead(head, responseJson);
//
//        JSONObject resultJson = new JSONObject();
//
//        resultJson.put("head", head);
//        resultJson.put("body", body);
//        resultJson.put("content", responseJson);
//
//        log.info("标准Json出参：{}", resultJson);
//        return resultJson;
//    }
//
//    private JSONObject checkParams(JSONObject head, JSONObject body, JSONObject content)
//    {
//
//        if (null == head)
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文中head不能为空！");
//            return resultJson;
//        }
//
//        if (null == body)
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文中body不能为空！");
//            return resultJson;
//        }
//
//        if (null == content)
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文中content不能为空！");
//            return resultJson;
//        }
//
//        if (StringUtils.isBlank(head.getString("serviceCode")))
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文head中serviceCode不能为空！");
//            return resultJson;
//        }
//
//        if (StringUtils.isBlank(head.getString("requestId")))
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文head中requestId不能为空！");
//            return resultJson;
//        }
//
//        if (StringUtils.isBlank(head.getString("requestTime")))
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文head中requestTime不能为空！");
//            return resultJson;
//        }
//
//        if (StringUtils.isBlank(head.getString("version")))
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文head中version不能为空！");
//            return resultJson;
//        }
//
//        String zipCode = body.getString("zipCode");
//        if (!"0".equals(zipCode) && !"1".equals(zipCode) )
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文body中zipCode只能为0或1！");
//            return resultJson;
//        }
//
//        String encryptCode = body.getString("encryptCode");
//        if (!"0".equals(encryptCode) && !"1".equals(encryptCode) )
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文body中encryptCode只能为0或1！");
//            return resultJson;
//        }
//
//        String encryptKey = body.getString("encryptKey");
//        if ("1".equals(encryptCode) && StringUtils.isBlank(encryptKey))
//        {
//            JSONObject resultJson = new JSONObject();
//            resultJson.put("success", false);
//            resultJson.put("code", -1);
//            resultJson.put("message", "请求报文body中encryptCode为1时，encryptKey必填！");
//            return resultJson;
//        }
//        return null;
//    }

//
//    public void setMessageType(ParamWrapper paramWrapper)
//    {
//        paramWrapper.setMessageType(MessageType.JSON);
//    }
//
//
//    protected void setResponseHead(JSONObject head, JSONObject responseJson)
//    {
//        Object traceInfo = responseJson.get("traceInfo");
//
//        head.put("responseTime", new Date());
//
//        if (traceInfo instanceof Map)
//        {
//            ((Map) traceInfo).remove("param");
//            head.put("traceId", ((Map) traceInfo).get("traceId"));
//            head.put("traceIp", ((Map) traceInfo).get("ip"));
//        }
//
//        if (traceInfo instanceof JSONObject)
//        {
//            ((JSONObject) traceInfo).remove("param");
//            head.put("traceId", ((JSONObject) traceInfo).getString("traceId"));
//            head.put("traceIp", (((JSONObject) traceInfo).getString("ip")));
//        }
//    }
}