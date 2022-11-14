package org.cxz.thread.block;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/29 15:28
 */
public class TestBlock {

    public static void main(String[] args) {
        testService ts = new testService();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ts.f1();
        },"t1");
        Thread t2 = new Thread(() -> {

            ts.f1();
        },"t2");
        t1.start();
        t2.start();
    }
}
