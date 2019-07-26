package com.baiwang.cloud.service.business.impl;

import com.baiwang.cloud.common.enums.BizErrorEnum;
import com.baiwang.cloud.common.enums.ws.CljgEnum;
import com.baiwang.cloud.common.enums.ws.InterfaceEnum;
import com.baiwang.cloud.common.model.ws.base.Interface;
import com.baiwang.cloud.common.model.ws.business.cljg.request.CljgRequest;
import com.baiwang.cloud.common.model.ws.business.cljg.response.CljgResponse;
import com.baiwang.cloud.common.model.ws.business.cljg.response.Data;
import com.baiwang.cloud.common.model.ws.business.common.BusinessResponse;
import com.baiwang.cloud.common.model.ws.business.common.Fpmx;
import com.baiwang.cloud.common.model.ws.business.common.Fpmxs;
import com.baiwang.cloud.service.BusinessRegisterService;
import com.baiwang.cloud.service.business.FpcxService;
import com.baiwang.cloud.common.util.JaxbUtil;
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
public class CljgServiceImpl implements FpcxService {

    @Autowired
    private BusinessRegisterService businessRegisterService;

    //每个具体业务处理接口均需要注册
    @PostConstruct
    public void register() {
        businessRegisterService.register(InterfaceEnum.CLJG, this, CljgRequest.class, CljgResponse.class);
    }

    @Override
    public BusinessResponse doBusiness(Interface interfaceFromXml) {
        log.info("接收到业务报文：{}", interfaceFromXml.toXml());

        //业务报文
        String content = interfaceFromXml.getData().getContent();

        CljgResponse response = null;
        try {
            CljgRequest request = JaxbUtil.xmlToBean(content, CljgRequest.class);
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
                fpmx.setFpxzm("http://www.baidu.com");
                list.add(fpmx);
            }
            Fpmxs fpmxs = new Fpmxs();
            fpmxs.setSize(size);
            fpmxs.setFpmx(list);
            Data data = new Data();
            data.setQqlsh(request.getQqlsh());
            data.setFpmxs(fpmxs);
            response.setData(data);
        } catch (JAXBException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
//            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        }

        return response;
    }

    private CljgResponse success(){
        CljgResponse response = new CljgResponse();
        response.setCode(CljgEnum.SUCCESS.getCode());
        return response;
    }

    private CljgResponse failed(CljgEnum itemEnum){
        CljgResponse response = new CljgResponse();
        response.setCode(itemEnum.getCode());
        return response;
    }

}
