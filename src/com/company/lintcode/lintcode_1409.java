package com.company.lintcode;

import com.company.base.BaseDemo;

import java.util.HashMap;
import java.util.Map;

public class lintcode_1409 extends BaseDemo {

    @Override
    public void solution() {

    }

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
}
