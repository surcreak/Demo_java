package com.company.api_demo;

import com.company.base.BaseDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest extends BaseDemo {
    @Override
    public void solution() throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(10);
        final ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + NO + " arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            exec.submit(runnable);
        }
        System.out.println("Game Start");
        begin.countDown();
        end.await();
        System.out.println("Game Over");
        exec.shutdown();
    }
}
