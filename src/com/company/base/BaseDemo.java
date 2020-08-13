package com.company.base;

public abstract class BaseDemo {
    public void launch() {
        System.out.println("-------"+this.getClass().getCanonicalName()+"-------");
        try {
            solution();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    abstract public void solution() throws InterruptedException;
}
