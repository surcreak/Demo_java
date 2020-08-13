package com.company.api_demo;

import com.company.base.BaseDemo;

import java.util.concurrent.*;

public class ScheduledExecutorServiceDemo extends BaseDemo {

    private volatile int count = 0;

    /**
     * 线程池定时关闭操作。
     */
    @Override
    public void solution() {
        //测试shutdown
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("count="+count);
                if (count > 5) {
                    service.shutdown();
                }
                count++;
            }
        };
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);

        //测试线程池重复放入同一个线程
        ExecutorService service2 = Executors.newCachedThreadPool();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable2");
            }
        };
        service.execute(runnable1);
        service.execute(runnable1);
        service.execute(runnable1);
        service.execute(runnable1);
        //每次都执行一次
    }
}
