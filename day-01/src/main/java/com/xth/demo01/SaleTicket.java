package com.xth.demo01;

/**
 * @author xth
 * @create 2021-08-13 17:17
 *
 * 卖票(传统的synchronized)
 *
 * 线程就是一个单独的资源类，没有任何附属操作
 *   1.属性、方法
 */
public class SaleTicket {
    public static void main(String[] args) {
        //并发就是多个线程操作同一个资源类，把资源类丢入线程
        Ticket ticket = new Ticket();

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
class Ticket{
    //属性、方法

    //有多少张票
    private int nums = 50;

    //卖票的方式
    public synchronized void sale(){
        if (nums>0){
            System.out.println(Thread.currentThread().getName()+"卖出了第"+(nums--));
        }
    }
}
