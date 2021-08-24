package com.xth.queue;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author xth
 * @create 2021-08-23 15:08
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        arrayBlockingQueue.add('a');
        arrayBlockingQueue.add('b');
        arrayBlockingQueue.add('c');
        // arrayBlockingQueue.add('d');  java.lang.IllegalStateException: Queue full

        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        // System.out.println(arrayBlockingQueue.remove());  java.util.NoSuchElementException
    }

    /**
     * 不抛出异常  有返回值
     */
    public static void test2() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer('a'));
        System.out.println(arrayBlockingQueue.offer('b'));
        System.out.println(arrayBlockingQueue.offer('c'));
        // System.out.println(arrayBlockingQueue.offer('d'));

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // System.out.println(arrayBlockingQueue.poll());  null
    }

    /**
     * 阻塞  一直等待
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        arrayBlockingQueue.put('a');
        arrayBlockingQueue.put('b');
        arrayBlockingQueue.put('c');
        // arrayBlockingQueue.put('d');  一直等待

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        // System.out.println(arrayBlockingQueue.take()); 没有第4个元素  一直等待
    }

    /**
     * 超时等待
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(arrayBlockingQueue.offer('a'));
        System.out.println(arrayBlockingQueue.offer('b'));
        System.out.println(arrayBlockingQueue.offer('c'));
        // System.out.println(arrayBlockingQueue.offer('d',2, TimeUnit.SECONDS));

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        // System.out.println(arrayBlockingQueue.poll(2, TimeUnit.SECONDS));
    }
}