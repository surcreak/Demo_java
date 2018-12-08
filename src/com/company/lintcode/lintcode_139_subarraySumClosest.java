package com.company.lintcode;

import com.company.base.BaseDemo;

import java.util.Arrays;
import java.util.Comparator;

public class lintcode_139_subarraySumClosest extends BaseDemo {

    @Override
    public void launch() {
        super.launch();
    }

    static class Pair {
        public int sum;
        public int index;

        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public static int[] subarraySumClosest_139(int[] nums) {
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
}
