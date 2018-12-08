package com.company.api_demo;

import com.company.base.BaseDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo extends BaseDemo {

    private volatile int count = 0;

    @Override
    public void launch() {
        super.launch();

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

    }
}
