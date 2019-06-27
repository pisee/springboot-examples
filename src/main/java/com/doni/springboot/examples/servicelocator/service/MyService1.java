package com.doni.springboot.examples.servicelocator.service;

import org.springframework.stereotype.Service;

@Service
public class MyService1 implements MyService {
    @Override
    public void doService(String name) {
        System.out.println("MyService1 : " + name + " / " + this.hashCode());
    }
}
