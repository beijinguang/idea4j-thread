package com.idea4j.mutithread.masterworker;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable {
    protected Queue<Object> workQueue;

    protected Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
    @Override
    public void run() {
        while (true) {
            Object input = workQueue.poll();
            if (input == null) {
                break;
            }
            Object re = handle(input);
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }

    public Object handle(Object input) {
        return input;
    }
}
