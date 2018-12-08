package com.company.base;

public abstract class BaseDemo {
    public void launch() {
        System.out.println("-------"+this.getClass().getCanonicalName()+"-------");
    }
}
