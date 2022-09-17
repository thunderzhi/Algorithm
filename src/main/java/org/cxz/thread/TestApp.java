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
        Object o = new Object();
        Test test = new Test(o);
        Thread t1 = new Thread(()->{
            test.f1();

        },"t1");
        Thread t2 = new Thread(()->{
            test.f2();
        },"t2");

        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("notifyAll = " );
        //test.notifytest();

        System.out.println("test.a = " + test.a+" test.a = " + test.b+" test.c = " + test.c);
    }
}
