package org.cxz.thread.juctool;

import java.util.concurrent.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/17 16:29
 */
public class CountDownLatchApp {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(3);
        TPEService tpeService = new TPEService();
        Executor executor = tpeService.getExecutor();
        for(int i = 0;i<3;i++){
            executor.execute(()->{
                String name = Thread.currentThread().getName();
                System.out.println("enter = " + name);
                cdl.countDown();
                System.out.println("end = " + name);
            });
        }
        try {
            System.out.println("await = " );
            cdl.await();
            System.out.println("wake up " );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
