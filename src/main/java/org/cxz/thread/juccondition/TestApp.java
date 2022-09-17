package org.cxz.thread.juccondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/15 17:58
 */
public class TestApp {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        TestJUC tj = new TestJUC();
        TestService ts = new TestService();

        Thread  t1 = new Thread(()->{
            tj.fun1(ts);
        },"t1");
        Thread  t3 = new Thread(()->{
            tj.fun1(ts);
        },"t3");
        Thread  t2 = new Thread(()->{
            tj.fun2(ts);
        },"t2");
        t1.start();
        t3.start();
        //t2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ts.c1.signal();
        System.out.println("wakeup = " );
        //LockSupport.unpark(t1);



    }
}
