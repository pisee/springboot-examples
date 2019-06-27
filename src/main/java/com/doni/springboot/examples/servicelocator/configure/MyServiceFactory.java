package com.doni.springboot.examples.servicelocator.configure;

import com.doni.springboot.examples.servicelocator.service.MyService;

public interface MyServiceFactory {
    MyService getMyService(String name);
}
