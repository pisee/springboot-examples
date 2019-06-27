package com.doni.springboot.examples.servicelocator.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.doni.springboot.examples.servicelocator.configure.MyServiceFactory;

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
