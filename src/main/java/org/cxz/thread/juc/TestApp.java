package org.cxz.thread.juc;

import javax.lang.model.SourceVersion;
import java.util.concurrent.locks.LockSupport;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/15 17:58
 */
public class TestApp {

    public static void main(String[] args) {
        TestJUC tj = new TestJUC();
        Thread  t1 = new Thread(()->{
            boolean res = tj.parkAndCheckInterrupt();
            System.out.println("res = " + res);
        },"t1");
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wakeup = " );
        LockSupport.unpark(t1);



    }
}
