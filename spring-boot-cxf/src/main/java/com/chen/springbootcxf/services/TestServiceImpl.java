package com.chen.springbootcxf.services;



import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @Auther: chen
 * @Date: 2018/11/13 14:10
 * @Description:webservice测试接口实现
 */
@WebService(serviceName = "TestService", // 与接口中指定的name一致
        targetNamespace = "http://services.springbootcxf.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.chen.springbootcxf.services.TestService"// 接口地址
)
@Component
public class TestServiceImpl implements TestService {

    @Override
    public String sendMessage(String username) {

            return "hello "+username;

    }
}
