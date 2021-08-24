package com.xth.counter;

import java.util.concurrent.CountDownLatch;

/**
 * @author xth
 * @create 2021-08-21 13:35
 *
 * 减法计数器
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"出去了");
                countDownLatch.countDown();//数量 -1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零，然后再向下执行
        
        System.out.println("关门");
    }
}
