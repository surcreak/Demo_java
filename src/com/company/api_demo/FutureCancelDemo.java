package com.company.api_demo;

import com.company.base.BaseDemo;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;


public class FutureCancelDemo extends BaseDemo {
    @Override
    public void solution() throws InterruptedException {
        futureCancel();
    }

    /**
     * 通过 Future 实现取消
     */
    private void futureCancel() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> task = executorService.submit(new TestTask());

        try {
            int x = task.get(3, TimeUnit.SECONDS);
            System.out.println(" task result x = " + x);
        } catch (TimeoutException e) {
            System.out.println("task TimeoutException");
        } catch (ExecutionException e) {

        } catch (InterruptedException e) {
            //e.printStackTrace();
        } finally {
            task.cancel(true);
            System.out.println("task cancel");
            executorService.shutdown();
        }

    }

    class TestTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            try {
                Thread.sleep(6000);
                return 12;
            } catch (InterruptedException e) {
                System.out.println("run InterruptedException");
                //e.printStackTrace();
            } finally {
                System.out.println("run end");
                return 12;
            }
        }
    }
}
