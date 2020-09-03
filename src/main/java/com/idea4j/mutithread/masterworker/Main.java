package com.idea4j.mutithread.masterworker;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Master master = new Master(new PlusWorker(), 5);
        for (int i = 0; i < 100; i++) {
            master.submit(i);
        }
        master.execute();
        int result = 0;

        Map<String, Object> resultMap = master.getResultMap();
        while (resultMap.size() > 0 || !master.isComplete()) {
            Set<String> keys = resultMap.keySet();
            String key = null;
            for (String s : keys) {
                key = s;
                break;
            }
            Integer i = null;
            if (key != null) {
                i = (Integer) resultMap.get(key);
            }
            if (i != null) {
                result+=i;
            }
            if (key != null) {
                resultMap.remove(key);
            }
        }
        System.out.println(result);
    }
}
