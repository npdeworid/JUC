package com.xth.demo01;

/**
 * @author xth
 * @create 2021-08-13 15:54
 */
public class Test01 {
    public static void main(String[] args) {
        // new Thread().start();
        //获取CPU核数
        //CPU密集型   IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
        // Thread.sleep(1);
    }
}
