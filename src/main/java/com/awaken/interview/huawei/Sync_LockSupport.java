package com.awaken.interview.huawei;

import java.util.concurrent.locks.LockSupport;

public class Sync_LockSupport {

    private static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        char[] arr1 = "1234567".toCharArray();
        char[] arr2 = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char a : arr1) {
                System.out.print(a);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char b : arr2){
                LockSupport.park();
                System.out.print(b);
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();

    }

}
