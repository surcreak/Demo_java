package com.company;

import com.company.api_demo.ScheduledExecutorServiceDemo;
import com.company.api_demo.TimerTaskDemo;
import com.company.base.BaseDemo;

import static com.company.lintcode.lintcode_1409_findingNumber.findingNumber_1409;

public class Main {
    public static void main(String[] args) {

	    int arr[][] = {{1,2,3}, {3,4,2}, {2,1,8}};
	    System.out.println(findingNumber_1409(arr));

        BaseDemo demo = new ScheduledExecutorServiceDemo();
        demo.launch();
    }
}
