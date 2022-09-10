package org.cxz.thread;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/10 11:54
 */
public class TestApp {
    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(()->{
            test.f1();

        },"t1");
        Thread t2 = new Thread(()->{
            test.f2();
        },"t2");
        t1.start();
        t2.start();
        System.out.println("test.a = " + test.a+" test.a = " + test.b+" test.c = " + test.c);
    }
}
