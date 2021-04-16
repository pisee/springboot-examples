package com.doni.springboot.examples.staticTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PrepareForTest(StaticClass.class)
@ActiveProfiles("h2")
//@PowerMockIgnore("javax.management.*")
public class StaticClassTest {

    @Resource
    BeanForCallingStaticClass beanForCallingStaticClass;

    @Test
    public void callStaticMethodTest() {
        PowerMockito.mockStatic(StaticClass.class);
        Mockito.when(StaticClass.callStaticMethod()).thenReturn("stub");

        String  call = beanForCallingStaticClass.callStaticMethod();

        assertEquals("stub", call);

    }

}
