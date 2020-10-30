package com.company.api_demo;

import com.company.Main;
import com.company.base.BaseDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class WenLongdemo extends BaseDemo {

    private static HashMap<String, Handler> map;

    @Override
    public void solution() throws InterruptedException {
        map = new HashMap();
        Constructor<WenLongdemo> constructor = null;
        try {
            constructor = WenLongdemo.class.getConstructor();
            WenLongdemo main = constructor.newInstance();
            Class<? extends WenLongdemo> mainClass = main.getClass();
            Method[] methods = mainClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(WenLongdemo.GG.class)) {
                    WenLongdemo.GG annotation = method.getAnnotation(WenLongdemo.GG.class);
                    String name = annotation.name();
                    registerHandler(new Handler() {
                        @Override
                        public String name() {
                            return name;
                        }

                        @Override
                        public void invoke(String req) throws InvocationTargetException, IllegalAccessException {
                            method.invoke(main, req);
                        }
                    });

                }
            }

            System.err.println(map.keySet().toString());

            String client = "fucker";
            Handler handler = map.get(client);
            handler.invoke("client");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @WenLongdemo.GG(name = "fucker")
    public void fuck(String name) {
        System.err.println(String.format("fuck %s!", name));
    }

    public static void registerHandler(Handler handler) {
        map.put(handler.name(), handler);
    }

    public static interface Handler {
        String name();

        void invoke(String req) throws InvocationTargetException, IllegalAccessException;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface GG {
        String name();
    }

    public static class GGs {

        String socket;

        @GG(name = "anime")
        public void XX(String req, String resp) {
            socket.split("");
        }
    }
}
