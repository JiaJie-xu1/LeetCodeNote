package com.univers.lib.leetCode;

public class TestThreadLocal {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {

        threadLocal.set("thread----main");
        threadLocal2.set("threadLocal2:thread----main");
        System.out.println("thread main:" + threadLocal.get());
        System.out.println("threadLocal2 main:" + threadLocal2.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread----1");
                System.out.println("thread1:" + threadLocal.get());
                threadLocal.set("thread----change------1");
                System.out.println("thread1:" + threadLocal.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread----2");
                System.out.println("thread2:" + threadLocal.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread----1");
                System.out.println("thread3:" + threadLocal.get());
            }
        }).start();

        threadLocal.set("thread----main2222");
        System.out.println("thread main:" + threadLocal.get());
    }
}
