package com.example.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Component
public class DemoFileProcessService {

    @Async("threadPoolTaskExecutor")
     public CompletableFuture<String> processFiles() {

        System.out.println("DemoFileProcessService thread name: "+Thread.currentThread().getName()
        + LocalDateTime.now());

        try{
            TimeUnit.SECONDS.sleep(90);
            System.out.println("Timestamp after waiting for 1.5 mins : "+LocalDateTime.now());
        }catch (Exception e) {
            System.out.println(e);
        }


        return CompletableFuture.completedFuture("waited for 2 mins ");

     }
}
