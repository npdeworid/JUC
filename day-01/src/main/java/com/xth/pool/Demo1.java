package com.xth.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xth
 * @create 2021-08-23 22:06
 */
public class Demo1 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        try {
            for (int i = 1;i <= 5;i++) {
                es.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"----ok");
                });
            }
        } finally {
            es.shutdownNow();
        }
    }
}
