package com.yemu.mallportal.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author yemuc
 * @date 2020/4/29
 * 异步配置
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        // 配置线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 线程池核心线程数，控制每次开启子线程数量
        taskExecutor.setCorePoolSize(5);
        // 线程池维护线程的最大数量
        taskExecutor.setMaxPoolSize(10);
        // 线程池所使用的缓冲队列
        taskExecutor.setQueueCapacity(25);
        // 线程池维护线程所允许的空闲时间
        taskExecutor.setKeepAliveSeconds(30000);
        taskExecutor.initialize();
        return taskExecutor;
    }
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
