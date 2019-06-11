package com.doni.springboot.examples.service;

import com.doni.springboot.examples.configure.MyServiceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTest {

    @Resource
    MyServiceFactory myServiceFactory;

    @Test
    public void doTest(){
        MyService service1Instance1 = myServiceFactory.getMyService("myService1");
        service1Instance1.doService("doni");

        MyService service1Instance2 = myServiceFactory.getMyService("myService1");
        service1Instance2.doService("doni");

        assertEquals(service1Instance1, service1Instance2);

        MyService service = myServiceFactory.getMyService("myService2");
        service.doService("dany");
    }
}
