package com.idea4j.mutithread.future;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        Data data = client.request("name");
        System.out.println("request over");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Data = " + data.getResult());
    }
}
