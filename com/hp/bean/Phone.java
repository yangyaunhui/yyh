package com.hp.bean;
/*
    标准的单例模式 步骤如下:1,2,3
    Spring 框架模式  单例模式
 */
public class Phone {
    //2.在对象本身new自己 而且是一个static修饰的
    private static Phone ourInstance = new Phone();
    //3.写出自身对象的方法的返回值
    public static Phone getInstance() {
        return ourInstance;
    }
    //1.无参构造方法私有化
    private Phone() {
    }
}
