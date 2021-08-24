package com.xth.demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xth
 * @create 2021-08-13 18:07
 *
 * Lock锁
 */
public class SaleTicket2 {
    public static void main(String[] args) {
        //并发就是多个线程操作同一个资源类，把资源类丢入线程
        Ticket2 ticket = new Ticket2();

        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //
        //     }
        // }).start();
        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 55; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}
//资源类 OOP
class Ticket2{
    //属性、方法

    //有多少张票
    private int nums = 50;

    Lock lock = new ReentrantLock();

    //卖票的方式
    public void sale(){
        //加锁
        lock.lock();
        try {
            if (nums>0){
                System.out.println(Thread.currentThread().getName()+"卖出了第"+(nums--));
            }
        } finally {
            //解锁
            lock.unlock();
        }
    }
}