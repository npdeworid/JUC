package com.xth.demo03;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xth
 * @create 2021-08-14 18:00
 */
public class TestMap {
    public static void main(String[] args) {
        //方式一：Map<String, String> map = new Hashtable<>();
        //方式二：Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        //方式三
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i=1;i<=20;i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,3));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
