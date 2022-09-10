package org.cxz.thread;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/10 11:53
 */
public class Test {
    public int a ;
    public int b ;
    public volatile int c ;
    public Test(){
        a=0;
        b=0;
        c=0;
    }
    public void f1(){
        String name = Thread.currentThread().getName();

        System.out.println("f1 name: "+name+" a:"+a+" b:"+b+" c:");
        a = 1;
        b = 1;
        //c = 1;
        System.out.println("f1 name: "+name+" a:"+a+" b:"+b+" c:");
        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void f2(){
        String name = Thread.currentThread().getName();
        System.out.println("f2 name: "+name+" a:"+a+" b:"+b+" c:");

        a = 2;
        b = 2;
        //c = 2;
        System.out.println("f2 name: "+name+" a:"+a+" b:"+b+" c:");

        try {
            Thread.currentThread().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
