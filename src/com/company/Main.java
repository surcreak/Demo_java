 package com.company;

 import com.company.api_demo.CopyOnWriteArrayListDemo;
 import com.company.api_demo.CountDownLatchTest;
 import com.company.api_demo.ScheduledExecutorServiceDemo;
 import com.company.api_demo.TimerTaskDemo;
 import com.company.base.BaseDemo;
 import com.company.lintcode.Lintcode_1006;
 import com.company.lintcode.Lintcode_139;

public class Main {
    public static void main(String[] args) {
         BaseDemo demo = new ScheduledExecutorServiceDemo();
         demo.launch();
    }
}
