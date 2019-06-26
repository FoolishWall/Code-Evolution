package com.njupt.designpattern.springObserver;

import com.njupt.designpattern.DesignpatternApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author wall
 * @date 2019/6/26  9:57
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DetailEventTest {
    @Autowired
    DetailEvent detailEvent;
    @Test
    public void run() {
        detailEvent.run();
    }
}