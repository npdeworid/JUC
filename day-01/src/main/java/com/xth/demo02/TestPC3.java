package com.xth.demo02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xth
 * @create 2021-08-14 13:39
 *
 * 用Lock代替synchronized和Condition代替wait()和notifyAll()、notify()
 */
public class TestPC3 {
    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
class Data3{

    private int num = 0;

    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();


    //+1的方法
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"--->"+num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    //-1的方法
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num==0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"--->"+num);
            System.out.println("============================================");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}