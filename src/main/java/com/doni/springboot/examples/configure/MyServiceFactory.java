package com.doni.springboot.examples.configure;

import com.doni.springboot.examples.service.MyService;

public interface MyServiceFactory {
    MyService getMyService(String name);
}
