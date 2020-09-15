package com.idea4j.mutithread.threadlocal;

/**
 * ThreadLocal在子线程中无法访问在父线程中设置的本地线程变量
 * InheritableThreadLocal
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> requestIdThreadLocal = new ThreadLocal<Integer>();
    private static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();

    public static void main(String[] args) {
        Integer reqId = new Integer(5);
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.setRequestId(reqId);
    }

    public void setRequestId(Integer requestId) {
        requestIdThreadLocal.set(requestId);
        inheritableThreadLocal.set(requestId);
        doBussiness();
    }

    public void doBussiness() {
        System.out.println("ThreadLocal 首先打印requestId:" + requestIdThreadLocal.get());
        System.out.println("inheritableThreadLocal 首先打印requestId:" + inheritableThreadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程启动");
                System.out.println("ThreadLocal 在子线程中访问requestId:" + requestIdThreadLocal.get());
                System.out.println("inheritableThreadLocal 在子线程中访问requestId:" + inheritableThreadLocal.get());
            }
        }).start();
    }

}
