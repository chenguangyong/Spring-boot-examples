package com.chen.springbootcxf.services;


import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

/**
 * @Auther: chen
 * @Date: 2018/11/13 14:14
 * @Description:cxf配置
 */
@Configuration
public class CxfConfig {

    @Autowired
    private TestService testService;

    @Autowired
    private Bus bus;


    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, testService);
        endpoint.publish("/TestService");
        return endpoint;
    }


}
