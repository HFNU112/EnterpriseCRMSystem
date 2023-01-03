package com.itheima.test;

/**
 * @Author: hsp
 * @Date: 2022/12/26-12-26-15:58
 * @Description: com.itheima.test
 * @version: 1.0.0
 */
public class B extends A{

    /**
     * 对象属性的赋值
     * int x = 20;  ==> int x;  x = 20;
     */
    int x = 20;
    //int x;

    //构造器
    public B(){
        super();
        //x = 20;
        run();
    }
    public void run(){
        System.out.println("------B---子类构造器-------->"+x);
    }

}
