package com.example.springbootRest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


@Configuration
@EnableAsync
public class SpringAsyncConfig {

    @Value("${service.threadpool.corepoolsize}")
    private int corepoolsize;

    @Value("${service.threadpool.maxpoolsize}")
    private int maxpoolsize;

    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        if(corepoolsize > maxpoolsize) {
            executor.setMaxPoolSize(corepoolsize + 5);
        }else {
            executor.setMaxPoolSize(maxpoolsize);
        }

        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadGroupName("Demo Grp");
        executor.setThreadNamePrefix("Demo Async Thread: ");
        return  executor;
    }

    @Bean(name = "taskExecutor")
    public Executor threadPoolTaskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(11);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadGroupName("MainTaskExecutor Grp");
        executor.setThreadNamePrefix("MainTaskExecutor Async Thread: ");
        return executor;

    }

}
