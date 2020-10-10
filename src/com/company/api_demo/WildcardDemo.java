package com.company.api_demo;

import com.company.base.BaseDemo;

import java.util.ArrayList;
import java.util.List;

public class WildcardDemo extends BaseDemo {
    @Override
    public void solution() throws InterruptedException {
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();

        // 都不合法
        //apples = fruits;
        //fruits = apples;

        // 如果 apples = fruits 可以，fruits 里面可能会被放入非 apples 类型的实例，比如 Banana。
        // 如果 fruits = apples 可以，apples 里面可能会被放入非 apples 类型的实例，比如 Banana。fruits.add(new Banana())

        fruits.add(new Fruit());
        fruits.add(new Apple());

        processElements(fruits);
        // processElements 不能传apples 或 fruits的子类
        //processElements(apples);

        List<?> listUknown = new ArrayList<>();
        // 因为你不知道集合是哪种类型，所以你只能够对集合进行读操作。并且你只能把读取到的元素当成 Object 实例来对待。
        //listUknown.add(new Fruit());

        processElements2(apples);
        processElements2(fruits);

        processElements3(apples);
        processElements3(fruits);

        List<? extends Fruit> fruits1 = new ArrayList<>();
        // 仍然是不能给 fruits1 添加元素, 因为你不知道 fruits1 集合里面的元素是什么类型（Fruit、Apple 还是 Banana 等等）
        //fruits1.add(new Fruit());
    }

    public void processElements(List<Fruit> elements) {
        for(Fruit o : elements)
            System.out.println(o.toString());
    }

    public void processElements2(List<?> elements){
        for(Object o : elements)
            System.out.println(o.toString());
    }

    public void processElements3(List<? extends Fruit> elements){
        for(Fruit a : elements)
            System.out.println(a.toString());
    }


}


    class Fruit {

    }

    class Apple extends Fruit {

    }

    class Banana extends Fruit {

    }


}
