package com.company.lintcode;

import com.company.base.BaseDemo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 问题：给定一个整数数组，找到一个和最接近于零的子数组。
 * 返回第一个和最右一个指数。你的代码应该返回满足要求的子数组的起始位置和结束位置
 *
 * 解决：
 * 1、用pair数组，pair中first保存从0到当前数组总和，second保存当前的数组位置
 * 2、将pair非递减排序。
 * 3、找出其中相邻相减最小的两个pair。
 * 4、将这两个pair的位置排序。
 */
public class Lintcode_139 extends BaseDemo {

    @Override
    public void solution() {
        int [] array = {-3,1,1,-3,5};
        int [] result = subarraySumClosest_139(array);
        System.out.println(Arrays.toString(result));
    }

    private int[] subarraySumClosest_139(int[] nums) {
        int [] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;
        if (length == 1) {
            result[0] = result[1] = 0;
            return result;
        }

        Pair[] pairs = new Pair[length+1];
        pairs[0] = new Pair(0, 0);
        int preSum = 0;

        for (int i = 1; i <= length; i++) {
            pairs[i] = new Pair(nums[i-1] + preSum, i);
            preSum = pairs[i].sum;
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            if (ans > pairs[i].sum - pairs[i-1].sum) {
                ans = pairs[i].sum - pairs[i-1].sum;
                int temp[] = new int[] {pairs[i].index-1, pairs[i-1].index-1};
                Arrays.sort(temp);
                result[0] = temp[0] + 1;
                result[1] = temp[1];
            }
        }

        return result;
    }

    static class Pair {
        public int sum;
        public int index;

        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}
