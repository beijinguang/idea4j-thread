package com.idea4j.mutithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue {
    private List list = new ArrayList();

    public synchronized Object pop() throws InterruptedException {
        while (list.size() == 0) {
            this.wait();
        }
        if (list.size() > 0) {
            return list.remove(0);
        } else {
            return null;
        }
    }

    public synchronized void put(Object o) {
        list.add(o);
        this.notify();
    }

    public static void main(String[] args) {
        new BlockQueue();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {

        }finally {
            reentrantLock.unlock();
        }
    }
}
