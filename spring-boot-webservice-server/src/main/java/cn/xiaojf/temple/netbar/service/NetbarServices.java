package cn.xiaojf.temple.netbar.service;

import cn.xiaojf.temple.netbar.service.model.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 网吧web services 接口
 * @author xiaojf 2017/7/24 21:35
 */
@WebService(targetNamespace = "http://service.netbar.temple.xiaojf.cn")// 命名空间,一般是接口的包名倒序
public interface NetbarServices {
    @WebMethod
    String sayHello(@WebParam(name = "userName") String name);

    @WebMethod
    String addPerson(@WebParam(name = "person") Person person);

}