package com.chen.springbootdemo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: chen
 * @Date: 2018/12/10 10:46
 * @Description:
 */
@Component
public class Scheduler2Task {

    private int count=0;

   //@Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
