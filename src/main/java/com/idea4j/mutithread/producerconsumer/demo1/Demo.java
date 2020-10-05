package com.idea4j.mutithread.producerconsumer.demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用 BlockingQueue 实现生产者消费者模式
 */
public class Demo {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(20);

        Runnable producer = () -> {
            while (true) {
                try {

                    blockingQueue.put(new Object());
                    System.out.println("producor:" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
            while (true) {
                try {
                    System.out.println("consumer:" + blockingQueue.size());
                    blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();

    }

}
