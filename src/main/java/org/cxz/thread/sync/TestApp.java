package org.cxz.thread.sync;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/14 15:28
 */
public class TestApp {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            TestStatic.staticfun1();
        },"t1");
        Thread t2 = new Thread(()->{
            TestStatic.staticfun1();
        },"t2");
        TestStatic ts = new TestStatic();
        Thread t3 = new Thread(()->{
            ts.fun3();
        },"t3");
        Thread t4 = new Thread(()->{
            ts.fun4();
        },"t4");
        t4.start();
        t1.start();
        t2.start();
        t3.start();






    }
}
