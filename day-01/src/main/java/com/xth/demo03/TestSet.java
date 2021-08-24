package com.xth.demo03;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author xth
 * @create 2021-08-14 17:52
 */
public class TestSet {
    public static void main(String[] args) {
        /**
         *        Set<String> set = new HashSet<>();
         *
         * 方式1 Set<String> set = Collections.synchronizedSet(new HashSet<>());
         */
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i=1;i<=20;i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,3));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
