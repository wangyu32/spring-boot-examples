package com.baiwang.cloud.config;

import com.baiwang.cloud.adapter.WebServiceAdapter;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/18
 */
@Configuration
public class WebServiceConfiguration {

    @Autowired
    private Bus bus;

    @Autowired
    private WebServiceAdapter webServiceAdapter;

    @Bean
    public Endpoint bWWebServiceEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, webServiceAdapter);
        endpoint.publish("/WebServiceAdapter");
        return endpoint;
    }
}