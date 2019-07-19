package cn.xiaojf.temple.netbar.service;

import cn.xiaojf.temple.netbar.service.model.Person;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 *  网吧web services 接口实现
 * @author xiaojf 2017/7/24 21:38
 */
@WebService(serviceName = "NetbarServices"//服务名
        ,targetNamespace = "http://service.netbar.temple.xiaojf.cn"//报名倒叙，并且和接口定义保持一致
        ,endpointInterface = "cn.xiaojf.temple.netbar.service.NetbarServices")//包名
@Component
public class NetbarServicesImpl implements NetbarServices {
    @Override
    public String sayHello(String name) {
        return "hello , "+ name;
    }

    @Override
    public String addPerson(Person person) {
        System.out.println(person.toString());
        return person.toString();
    }
}