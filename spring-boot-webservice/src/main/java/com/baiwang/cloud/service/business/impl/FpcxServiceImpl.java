package com.baiwang.cloud.service.business.impl;

import com.baiwang.cloud.enums.BizErrorEnum;
import com.baiwang.cloud.enums.CurrencyEnum;
import com.baiwang.cloud.enums.FpcxEnum;
import com.baiwang.cloud.enums.InterfaceEnum;
import com.baiwang.cloud.model.base.Interface;
import com.baiwang.cloud.model.business.common.BusinessResponse;
import com.baiwang.cloud.model.business.common.Fpmx;
import com.baiwang.cloud.model.business.common.Fpmxs;
import com.baiwang.cloud.model.business.fpcx.request.FpcxRequest;
import com.baiwang.cloud.model.business.fpcx.response.Data;
import com.baiwang.cloud.model.business.fpcx.response.FpcxResponse;
import com.baiwang.cloud.service.BusinessRegisterService;
import com.baiwang.cloud.service.business.FpcxService;
import com.baiwang.cloud.util.JaxbUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/25 15:44
 */
@Slf4j
@Service
public class FpcxServiceImpl implements FpcxService {

    @Autowired
    private BusinessRegisterService businessRegisterService;

    //每个具体业务处理接口均需要注册
    @PostConstruct
    public void register() {
        businessRegisterService.register(InterfaceEnum.FPCX, this, FpcxRequest.class, FpcxResponse.class);
    }

    @Override
    public BusinessResponse doBusiness(Interface interfaceFromXml) {
        log.info("接收到业务报文：{}", interfaceFromXml.toXml());

        //业务报文
        String content = interfaceFromXml.getData().getContent();

        FpcxResponse response = null;
        try {
            FpcxRequest request = JaxbUtil.xmlToBean(content, FpcxRequest.class);
            //TODO 具体业务处理

            response = success();
            response.setMessage("成功");

            Random random = new Random();
            int size = random.nextInt(3) + 1;
            List<Fpmx> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Fpmx fpmx = new Fpmx();
                fpmx.setFpdm("100020003000");
                fpmx.setFphm("11112222");
                fpmx.setZje("100.0");
                fpmx.setJe("10.0");
                fpmx.setYhzh("北京银行 12345678909876");
                fpmx.setFpxzm("http://www.baidu.com");
                list.add(fpmx);
            }
            Fpmxs fpmxs = new Fpmxs();
            fpmxs.setSize(size);
            fpmxs.setFpmx(list);
            Data data = new Data();
            data.setBb(CurrencyEnum.CNY.name());
            data.setQqlsh(request.getQqlsh());
            data.setPtlsh(System.currentTimeMillis() + "");
            data.setFpmxs(fpmxs);
            response.setData(data);
        } catch (JAXBException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
//            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        }

        return response;
    }

    private FpcxResponse success(){
        FpcxResponse response = new FpcxResponse();
        response.setCode(FpcxEnum.SUCCESS.getCode());
        return response;
    }

    private FpcxResponse failed(FpcxEnum itemEnum){
        FpcxResponse response = new FpcxResponse();
        response.setCode(itemEnum.getCode());
        return response;
    }

}
