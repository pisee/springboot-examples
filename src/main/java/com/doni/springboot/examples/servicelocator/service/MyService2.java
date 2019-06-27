package com.doni.springboot.examples.servicelocator.service;

import org.springframework.stereotype.Service;

@Service
public class MyService2 implements MyService {
    @Override
    public void doService(String name) {
        System.out.println("MyService2 : " + name);
    }
}
