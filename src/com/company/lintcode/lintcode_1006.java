package com.company.lintcode;

import com.company.base.BaseDemo;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class lintcode_1006 extends BaseDemo {

    @Override
    public void solution() {
        String [] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        Map<String, Integer> map = new HashMap();
        for (String s : cpdomains) {
            String [] array = s.split(" ");
            String [] array1List = array[1].split("\\.");
            String key = array1List[array1List.length - 1];
            addCount(map, key, Integer.valueOf(array[0]));
            if (array1List.length>=2) {
                key = array1List[array1List.length - 2]+"."+array1List[array1List.length - 1];
                addCount(map, key, Integer.valueOf(array[0]));
            }
            if (array1List.length>=3) {
                key = array1List[array1List.length - 3]+"."+array1List[array1List.length - 2]+"."+array1List[array1List.length - 1];
                addCount(map, key, Integer.valueOf(array[0]));
            }
        }
        List<String> list = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            list.add(entry.getValue()+" "+entry.getKey());
        }
        System.out.println(list);
    }

    private void addCount(Map<String, Integer> map, String key, int addCount) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + addCount);
        } else {
            map.put(key, addCount);
        }
    }
}
