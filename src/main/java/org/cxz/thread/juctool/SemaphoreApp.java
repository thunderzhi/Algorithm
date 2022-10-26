package org.cxz.thread.juctool;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/17 16:47
 */
public class SemaphoreApp {

    public static void main(String[] args) {
        Semaphore sp = new Semaphore(2);
        TPEService tpeService = new TPEService();
        Executor executor = tpeService.getExecutor();
        for(int i = 0;i<6;i++){
            executor.execute(()->{
                String name = Thread.currentThread().getName();
                System.out.println("enter = " + name);
                try {
                    sp.acquire();

                    System.out.println("----do sth here = " + name);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sp.release();
                System.out.println("end = " + name);
            });
        }
        System.out.println("end main= " );
    }
}
