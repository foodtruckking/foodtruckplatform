package com.foodtruck.platform.Schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by narumi12 on 2017. 7. 2..
 */
@Component
public class FoodTruckCrawlingSchedule {


    @Scheduled(cron = "* * * * * *")
    public void test(){
        System.out.println("time#####");
    }
}
