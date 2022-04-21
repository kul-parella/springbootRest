package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoFileProcessService demoFileProcessService;

    @Value("${service.directory.loadLocation}")
    private String loadLocation;

    @Override
    public void fileProcess() {
        System.out.println("fileProcess thread name: "+Thread.currentThread().getName()+
                LocalDateTime.now());
        System.out.println("Processing files from load location: "+loadLocation);

        List<CompletableFuture<String>> asyncList = new ArrayList<>();

        CompletableFuture<String> async = demoFileProcessService.processFiles();
        asyncList.add(async);
        waitForFilesProcessing(asyncList);
    }


    private void waitForFilesProcessing(List<CompletableFuture<String>> asyncList){

        try {
            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                    asyncList.toArray(new CompletableFuture[asyncList.size()]));

            CompletableFuture<List<String>> allCompletableFuture = allFutures.thenApply(future -> {
                return asyncList.stream().map(completableFuture -> completableFuture.join())
                        .collect(Collectors.toList());
            });

            List<String> futureList = allCompletableFuture.get();

            for(String str : futureList) {
                System.out.println("Timestamp while printing the future string: "+LocalDateTime.now());
                System.out.println("futureList: "+str);
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
