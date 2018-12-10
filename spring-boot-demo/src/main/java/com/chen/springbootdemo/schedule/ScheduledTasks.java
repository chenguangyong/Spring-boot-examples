package com.chen.springbootdemo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * @Auther: chen
 * @Date: 2018/12/10 10:27
 * @Description:自定义定时任务
 */
@Component
public class ScheduledTasks {
    // 日志
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private int fixedDelayCount = 1;
    private int fixedRateCount = 1;
    private int initialDelayCount = 1;
    private int cronCount = 1;
    /**
     * @Title: testFixDelay
     * @Description:表示上一次任务执行完成后多久再次执行，参数类型为long，单位ms;
     */
    //@Scheduled(fixedDelay = 5000)//5s
    public void testFixDelay() {
        log.info(MessageFormat.format("fixedDelay()第{0}次执行", fixedDelayCount++));
    }
    /**
     *
     * @Title: testFixedRate
     * @Description:fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
     */
    //@Scheduled(fixedRate = 5000)
    public void testFixedRate() {
        log.info(MessageFormat.format("fixedRate: 第{0}次执行方法", fixedRateCount++));
    }

    /**
     *
     * @Title: testInitialDelay
     * @Description:initialDelay =1000表示延迟1000ms执行第一次任务
     */
    //@Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void testInitialDelay() {
        log.info(MessageFormat.format("initialDelay: 第{0}次执行方法", initialDelayCount++));
    }
    /**
     * @Title: testCron
     * @Description:cron接受cron表达式，根据cron表达式确定定时规则
     */
    @Scheduled(cron = "*/6 * * * * ?")
    public void testCron() {
        log.info(MessageFormat.format("core: 第{0}次执行方法", cronCount++));
    }

}
