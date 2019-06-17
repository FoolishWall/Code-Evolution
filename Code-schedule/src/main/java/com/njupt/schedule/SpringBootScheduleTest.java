package com.njupt.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author wall
 * @date 2019/6/17  11:05
 * @description
 */
@Service
public class SpringBootScheduleTest {
    @Scheduled(cron="0/5 * * * * ?")
    public void job(){
        System.out.println("测试SpringBoot自带的定时工具，每五秒执行一次");
    }
}
