package com.xth.demo03;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xth
 * @create 2021-08-14 16:55
 *
 * 普通的ArrayList
 */
public class TestList {
    public static void main(String[] args) {
        /**
         * ArrayList是不安全的List list = new ArrayList<>();
         * 将ArrayList变安全：
         * 方式 1、List list = new Vector();
         * 方式 2、List list = Collections.synchronizedList(new ArrayList<>());
         * 方式 3、List list = new CopyOnWriteArrayList();
         */
        List list = new CopyOnWriteArrayList();
        for (int i=1;i<=10;i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,3));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
