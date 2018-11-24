package com.company;

import java.security.KeyPair;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int arr[][] = {{1,2,3}, {3,4,2}, {2,1,8}};
	    System.out.println(findingNumber_1409(arr));
    }

    //*********************************
    //1409
    public static int findingNumber_1409(int[][] mat) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                if (map.containsKey(mat[i][j])) {
                    if (map.get(mat[i][j]) == i-1) {
                        map.put(mat[i][j], i);
                    }
                } else {
                    if (i == 0) {
                        map.put(mat[i][j], i);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mat.length - 1) {
                System.out.println(entry.getKey());
                ans = Math.min(entry.getKey(), ans);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        return ans;
    }

    //*****************************************
    //139
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
