package com.github.liwei1987.hero.task;

import com.github.liwei1987.hero.service.HeroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HeroCountTask implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(HeroCountTask.class.getSimpleName());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 播报间隔秒数
     */
    private static int broadcastIntervalSeconds = 10;

    /**
     * 当前播报轮数
     */
    private static int broadcastTimes;

    @Autowired
    private HeroService heroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            String nowTime = dateFormat.format(new Date());
            long totalHeroCount = heroService.getTotalHeroCount();
            logger.info(String.format("=====> 第 [%d] 轮播报, 峡谷当前共有 [%d] 名英雄加入 ！[%s] <=====", ++broadcastTimes, totalHeroCount, nowTime));
            sleepForNextTime();
        }
    }

    private void sleepForNextTime() throws InterruptedException {
        Thread.sleep(broadcastIntervalSeconds * 1000);
    }
}
