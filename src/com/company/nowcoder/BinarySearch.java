package com.company.nowcoder;

import com.company.base.BaseDemo;

import java.util.Scanner;

//二分查找
public class BinarySearch extends BaseDemo {

    // https://www.nowcoder.com/practice/7bc4a1c7c371425d9faa9d1b511fe193?tpId=188&&tqId=35618&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    @Override
    public void solution() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(",");
        int [] diffcult = new int[Integer.parseInt(nums[0])];
        for (int i=0; i < nums.length - 2; i++) {
            diffcult[i] = Integer.valueOf(nums[i+2]);
        }
        int result = upper_bound_(diffcult.length, Integer.parseInt(nums[1]), diffcult);
        System.out.println(result);
    }


    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int low = 0;
        int high = n;
        int mid = low + (high - low)/2;
        while (low < high) {
            mid = low + (high - low)/2;
            if (a[mid] < v) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low + 1;
    }
}
