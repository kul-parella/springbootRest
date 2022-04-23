package com.example.services;

import com.example.model.JsonConfigData;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoFileProcessService demoFileProcessService;

    @Value("${service.directory.loadLocation}")
    private String loadLocation;

    @Value("${workspace.configDir}")
    private String configdir;

    @Override
    public void fileProcess() {
        System.out.println("fileProcess thread name: "+Thread.currentThread().getName()+
                LocalDateTime.now());
        System.out.println("Processing files from load location: "+loadLocation);

        Map<String, JsonConfigData> configMap = new HashMap<>();

        try {
           configMap = getConfigData();
        }catch (Exception e) {
            System.out.println(e);
        }

        configMap.forEach( (k,v) -> System.out.println(k + " : " +v));

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


    public Map<String, JsonConfigData> getConfigData() throws FileNotFoundException {

        Map<String, JsonConfigData> jsonConfigDataMap = new HashMap<>();
        JsonConfigData configData;
        Gson gson = new Gson();

        File jsonConfigFolder = new File(configdir);
        System.out.println("Local jsonconfig files path : "+ jsonConfigFolder.getParentFile());
        File[] configFiles = jsonConfigFolder.listFiles();

        for(File file: configFiles) {
            configData = gson.fromJson(new FileReader(file), JsonConfigData.class);
            jsonConfigDataMap.put(file.getName(), configData);
        }

        return jsonConfigDataMap;
    }
}
