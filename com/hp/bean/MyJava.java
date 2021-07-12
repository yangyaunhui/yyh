package com.hp.bean;

import java.util.ArrayList;

public class MyJava {
    //main 方法快捷键是 psvm
    public static void main(String[] args) {
        System.out.println("输出的快捷键是 sout"); //sout 输出的快捷键
        String name = "小灰灰";
        System.out.println("name = " + name); //soutv 可以显示出 变量
        System.out.println("Atm.main"); //soutm 是输出 方法的名称
        System.out.println("args = [" + args + "]"); //soutp 是输出  方法的参数
        int age = 16;
        //如果  小于18 显示未成年
        if (age < 18 ){
            System.out.println("此狼未成年");  //if 的快捷键是 ifn
        }
        ArrayList<String> strings = new ArrayList<>();//万能快捷键  alt + enter
        strings.add("蕉太狼");//ctrl + d 快速复制一行
        strings.add("灰太狼");//多行编辑 alt + 光标
        strings.add("红太狼");//
        strings.add("香太狼");//ctrl + y 快速删除一行
        //ctrl + z 是 一步撤销 ctrl+shift+z 是 多步撤销
        for (String string : strings) { //遍历循环的快捷键 iter
            System.out.println("string = " + string);
        }

        //创建电脑
        Computer c1 = new Computer();
        c1.setPrice(5555.0D);
        c1.setColor("红色");
        c1.setTypeName("机械革命code555");
        System.out.println("c1 = " + c1);//c1 = myjava.Computer@74a14482 内存

        //内存地址是否一样，是判断对象是否相等的依据
        Computer c2 = new Computer();
        c2.setPrice(5555.0D);
        c2.setColor("红色");
        c2.setTypeName("机械革命code555");
        System.out.println("c2 = " + c2);

        //判断c1，c2是否相等
        System.out.println(c1 == c2);//flase

        //测试单例模式
        //Phone p1 = new phone(); //无参构造私有化了
        Phone p1 = Phone.getInstance();
        Phone p2 = Phone.getInstance();
        System.out.println(p1 == p2);//true
    }
}
