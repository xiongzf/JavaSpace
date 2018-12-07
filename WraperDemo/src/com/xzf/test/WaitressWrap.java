package com.xzf.test;

public class WaitressWrap implements Waiter {

    Waiter waiter = null;

    public WaitressWrap(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void service() {
        System.out.println("微笑");
        waiter.service();
    }

}
