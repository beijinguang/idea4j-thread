package com.idea4j.mutithread.producerconsumer.demo3;

import java.util.LinkedList;

/**
 * 用 wait/notify 实现生产者消费者模式
 */
public class Demo3 {
    private int maxSize;
    private LinkedList<Object> storage;

    public Demo3(int maxSize) {
        this.maxSize = maxSize;
        storage = new LinkedList<>();
    }

    public synchronized void put(Object o) throws InterruptedException {
        while (storage.size() == maxSize) {
            wait();
        }
        storage.add(o);
        notifyAll();
    }

    public synchronized Object take() throws InterruptedException {
        while (storage.size() == 0) {
            wait();
        }
        Object o = storage.remove();
        notifyAll();
        return o;
    }

    public static void main(String[] args) {

    }
}
