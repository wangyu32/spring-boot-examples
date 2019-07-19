package com.baiwang.cloud.config;

import com.baiwang.cloud.adapter.WebServiceAdapter;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Endpoint;

/**
 * @author liujp
 * @date 2018/12/26
 */
@Configuration
public class WebServiceConfiguration
{

    @Autowired
    private Bus bus;

    @Autowired
    private WebServiceAdapter webServiceAdapter;

    @Bean
    public Endpoint bWWebServiceEndpoint()
    {
        EndpointImpl endpoint = new EndpointImpl(bus, webServiceAdapter);
        endpoint.publish("/WebServiceAdapter");
        return endpoint;
    }

//    @Bean
//    RestTemplate restTemplate(RestTemplateBuilder builder)
//    {
//        return builder.build();
//    }
}