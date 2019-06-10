package com.company.api_demo;

import com.company.base.BaseDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CopyOnWriteArrayList写操作时copy一份，写完再设置成新的数据
 * 适用于读多写少的并发场景
 * 测试：
 *      使用线程池最大10个线程，开启读线程和写线程。
 */
public class CopyOnWriteArrayListDemo extends BaseDemo {

    @Override
    public void solution() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add("First");
        copyOnWriteArrayList.add("second");

        Iterator<String> iterator = copyOnWriteArrayList.iterator();

        copyOnWriteArrayList.add("third");

        Iterator<String> iterator2 = copyOnWriteArrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println("-----------------");


        final int NUM = 10;
        //使用ArrayList报错,ConcurrentModificationException
        //List<String> list = new ArrayList<String>();
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < NUM; i++) {
            list.add("demo_"+i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(NUM);
        for (int i = 0; i < NUM; i++) {
            executorService.execute(new ReadTask(list));
            executorService.execute(new WriteTask(list, i));
        }
        executorService.shutdown();
    }

    private static class ReadTask implements Runnable {
        List<String> list;

        public ReadTask(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    private static class WriteTask implements Runnable {
        List<String> list;
        int index;

        public WriteTask(List<String> list, int index) {
            this.list = list;
            this.index = index;
        }

        @Override
        public void run() {
            list.remove(index);
            list.add(index, "write_"+index);
        }
    }
}
