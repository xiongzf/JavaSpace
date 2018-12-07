package com.xzf.test;

public class MainTest {

    public static void main(String[] args) {
//		Waiter waiter = new Waitress();
//		waiter.service();

        WaitressWrap wrap = new WaitressWrap(new Waitress());
        wrap.service();

    }

}
