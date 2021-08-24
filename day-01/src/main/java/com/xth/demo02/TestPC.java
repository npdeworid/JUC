package com.xth.demo02;

/**
 * @author xth
 * @create 2021-08-13 18:53
 *
 * 有一个数字num = 0;
 * 两个线程：A线程对num进行+1操作，B线程对num进行-1操作
 *
 */
public class TestPC {
    public static void main(String[] args) {
        Data data = new Data();

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

//资源类 数据
class Data{

    private int num = 0;

    //+1的方法
    public synchronized void increment() throws InterruptedException {
        while (num!=0){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"--->"+num);
        this.notifyAll();
    }
    //-1的方法
    public synchronized void decrement() throws InterruptedException {
        while (num==0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"--->"+num);
        System.out.println("============================================");
        this.notifyAll();
    }
}
