package com.baiwang.cloud.service.business.impl;

import com.baiwang.cloud.common.enums.BizErrorEnum;
import com.baiwang.cloud.common.enums.YhdzjgEnum;
import com.baiwang.cloud.common.enums.InterfaceEnum;
import com.baiwang.cloud.common.model.base.Interface;
import com.baiwang.cloud.common.model.business.yhdzjg.request.YhdzjgRequest;
import com.baiwang.cloud.common.model.business.yhdzjg.response.YhdzjgResponse;
import com.baiwang.cloud.common.model.business.yhdzjg.response.Data;
import com.baiwang.cloud.common.model.business.common.BusinessResponse;
import com.baiwang.cloud.common.model.business.yhdzjg.response.Yhmx;
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
public class YhdzjgServiceImpl implements FpcxService {

    @Autowired
    private BusinessRegisterService businessRegisterService;

    //每个具体业务处理接口均需要注册
    @PostConstruct
    public void register() {
        businessRegisterService.register(InterfaceEnum.CLJG, this, YhdzjgRequest.class, YhdzjgResponse.class);
    }

    @Override
    public BusinessResponse doBusiness(Interface interfaceFromXml) {
        log.info("接收到业务报文：{}", interfaceFromXml.toXml());

        //业务报文
        String content = interfaceFromXml.getData().getContent();

        YhdzjgResponse response = null;
        try {
            YhdzjgRequest request = JaxbUtil.xmlToBean(content, YhdzjgRequest.class);
            //TODO 具体业务处理

            response = success();
            response.setMessage("成功");

            Random random = new Random();
            int size = random.nextInt(3) + 1;
            List<Yhmx> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Yhmx yhmx = new Yhmx();
                yhmx.setQqlsh(System.currentTimeMillis() + "");
                yhmx.setErrcode(YhdzjgEnum.SUCCESS.getCode());
                list.add(yhmx);
            }
            Data data = new Data();
            data.setSize(size);
            data.setYhmx(list);
            response.setData(data);
        } catch (JAXBException e) {
            log.error(BizErrorEnum.MESSAGE_FORMAT_ERROR.getMessage(), e);
//            return failed(BizErrorEnum.MESSAGE_FORMAT_ERROR);
        }

        return response;
    }

    private YhdzjgResponse success(){
        YhdzjgResponse response = new YhdzjgResponse();
        response.setCode(YhdzjgEnum.SUCCESS.getCode());
        return response;
    }

    private YhdzjgResponse failed(YhdzjgEnum itemEnum){
        YhdzjgResponse response = new YhdzjgResponse();
        response.setCode(itemEnum.getCode());
        return response;
    }

}
