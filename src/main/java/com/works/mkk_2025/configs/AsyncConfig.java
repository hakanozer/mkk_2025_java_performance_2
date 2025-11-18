package com.works.mkk_2025.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // CPU core sayısına göre
        executor.setMaxPoolSize(50); // Beklenen max eşzamanlı istek
        executor.setQueueCapacity(100); // Kuyruk boyutu
        executor.setThreadNamePrefix("Async-");
        //executor.setRejectedExecutionHandler( new ThreadPoolExecutor.CallerRunsPolicy());
        // Reddetme stratejisi
        executor.initialize();
        return executor;
    }
}