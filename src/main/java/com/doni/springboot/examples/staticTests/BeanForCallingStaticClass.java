package com.doni.springboot.examples.staticTests;

import org.springframework.stereotype.Component;

@Component
public class BeanForCallingStaticClass {

    public String callStaticMethod(){
        return StaticClass.callStaticMethod();
    }
}
