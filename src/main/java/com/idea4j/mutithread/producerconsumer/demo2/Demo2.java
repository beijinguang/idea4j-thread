package com.idea4j.mutithread.producerconsumer.demo2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用 Condition 实现生产者消费者模式
 */
public class Demo2 {
    private Queue queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public Demo2(int max) {
        this.max = max;
        queue = new LinkedList();
    }

    public void put(Object o) throws InterruptedException {
        lock.lock();
              try  {
                      while  (queue.size()  ==  max)  {
                              notFull.await();
                      }
                      queue.add(o);
                      notEmpty.signalAll();
              }  finally  {
                      lock.unlock();
              }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size()==0){
                notEmpty.await();
            }
            Object o = queue.remove();
            notFull.signalAll();
            return o;
        }finally {
            lock.unlock();
        }

    }
}
