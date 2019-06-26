package com.njupt.designpattern.handler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author wall
 * @date 2019/6/26  15:22
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHandlerTest {
    @Autowired
    TestHandler testHandler;
    @Test
    public void run() {
        testHandler.run("责任链的第三链");
    }
}