package com.example.scheduler;

import com.example.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DemoScheduler {

    @Autowired
    DemoService demoService;

    @Scheduled(initialDelayString = "${service.scheduler.delay}", fixedDelayString = "${service.scheduler.frequency}")
   //@Scheduled(cron = "* * * * *")
    public void scheduleTasks() {
        try {
            System.out.println("Thread Name: "+ Thread.currentThread().getName()+ LocalDateTime.now());
            demoService.fileProcess();
        }catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            // finally performed operations
        }
    }
}
