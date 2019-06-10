package com.company.lintcode;

import com.company.base.BaseDemo;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * 诸如discuss.lintcode.com这样的域名由各种子域名构成。最顶层是com，下一层是lintcode.com，
 * 最底层是discuss.lintcode.com.当访问discuss.lintcode.com时，会隐式访问子域名lintcode.com和com.
 * 现给出域名的访问计数格式为“空格 地址”。 示例：9001 discuss.lintcode.com.
 * 给出计数列表cpdomains. 返回每个子域名（包含父域名）的访问次数（与输入格式相同，顺序任意）.
 *
 * 解决：
 * 分割字符串（“.”需要转义），使用map，key是域名，value是计数。
 */
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
