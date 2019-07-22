package com.baiwang.cloud.model.factory;

import com.baiwang.cloud.enums.InterfaceEnum;
import com.baiwang.cloud.model.base.Data;
import com.baiwang.cloud.model.base.GlobalInfo;
import com.baiwang.cloud.model.base.Interface;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/22 21:36
 */
public class InterfaceFactory {

    private static final String DEFAULT_VERSION = "1.0";
    private static final String CDATA_PREFIX = "<![CDATA[";
    private static final String CDATA_SUFFIX = "]]>";


    private InterfaceFactory(){
    };

    public static final InterfaceFactory getInstance(){
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static InterfaceFactory instance = new InterfaceFactory();
    }

    public static Interface getInterfaceInstance(){
        GlobalInfo globalInfo = new GlobalInfo();
        Data data = new Data();
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    public static Interface getInterfaceInstance(String version){
        GlobalInfo globalInfo = new GlobalInfo();
        Data data = new Data();
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    public static Interface getInterfaceInstance(String version, String interfaceCode){
        GlobalInfo globalInfo = new GlobalInfo(version, interfaceCode);
        Data data = new Data();
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    public static Interface getInterfaceInstance(String version, String interfaceCode, String content){
        GlobalInfo globalInfo = new GlobalInfo(version, interfaceCode);
        Data data = new Data(content);
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    /**
     * 生成发票查询接口实体，配置默认的参数
     * @return
     */
    public static Interface getFpcxDefaultInterfaceInstance(){
        GlobalInfo globalInfo = new GlobalInfo(DEFAULT_VERSION, InterfaceEnum.FPCX.name());
        Data data = new Data();
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    /**
     * 生成发票查询接口实体，配置默认的参数
     * @param content
     * @return
     */
    public static Interface getFpcxDefaultInterfaceInstance(String content){
        GlobalInfo globalInfo = new GlobalInfo(DEFAULT_VERSION, InterfaceEnum.FPCX.name());
        Data data = new Data(content);
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    /**
     * 生成处理结果接口实体，配置默认的参数
     * @return
     */
    public static Interface getCljgDefaultInterfaceInstance(){
        GlobalInfo globalInfo = new GlobalInfo(DEFAULT_VERSION, InterfaceEnum.CLJG.name());
        Data data = new Data();
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    /**
     * 生成处理结果接口实体，配置默认的参数
     * @param content
     * @return
     */
    public static Interface getCljgDefaultInterfaceInstance(String content){
        GlobalInfo globalInfo = new GlobalInfo(DEFAULT_VERSION, InterfaceEnum.CLJG.name());
        Data data = new Data(content);
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    /**
     * 生成银行对账接口实体，配置默认的参数
     * @return
     */
    public static Interface getYhdzDefaultInterfaceInstance(){
        GlobalInfo globalInfo = new GlobalInfo(DEFAULT_VERSION, InterfaceEnum.YHDZ.name());
        Data data = new Data();
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    /**
     * 生成银行对账接口实体，配置默认的参数
     * @param content
     * @return
     */
    public static Interface getYhdzDefaultInterfaceInstance(String content){
        GlobalInfo globalInfo = new GlobalInfo(DEFAULT_VERSION, InterfaceEnum.YHDZ.name());
        Data data = new Data(content);
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    /**
     * 生成银行对账结果接口实体，配置默认的参数
     * @return
     */
    public static Interface getYhdzjgDefaultInterfaceInstance(){
        GlobalInfo globalInfo = new GlobalInfo(DEFAULT_VERSION, InterfaceEnum.YHDZJG.name());
        Data data = new Data();
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    /**
     * 生成银行对账结果接口实体，配置默认的参数
     * @param content
     * @return
     */
    public static Interface getYhdzjgDefaultInterfaceInstance(String content){
        GlobalInfo globalInfo = new GlobalInfo(DEFAULT_VERSION, InterfaceEnum.YHDZJG.name());
        Data data = new Data(content);
        Interface instance = new Interface(globalInfo, data);
        return instance;
    }

    public static void main(String[] args) {
        Interface int1 = getFpcxDefaultInterfaceInstance();
        System.out.println(int1);
    }

}
