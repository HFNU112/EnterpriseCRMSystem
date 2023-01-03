package com.itheima.test;

/**
 * @Author: hsp
 * @Date: 2022/12/26-12-26-15:57
 * @Description: com.itheima.test
 * @version: 1.0.0
 */
public class A {

    /**
     * 对象属性的赋值：
     * int x = 10;  ==> int x;  x = 10;
     * 对象的属性用 = 赋值, 编译器拆成两行代码。
     */
    int x = 10;
    //int x;

    public A(){
        super();
        //x = 10;
        run();
    }
    public void run(){
        System.out.println("-------A--父类构造器----->"+x);
    }

}
