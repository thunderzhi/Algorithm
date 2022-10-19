package org.cxz.thread.juctool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/17 16:44
 */
public class CyclicBarrierApp {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4);
        TPEService tpeService = new TPEService();
        Executor executor = tpeService.getExecutor();
        for(int i = 0;i<3;i++){
            executor.execute(()->{
                String name = Thread.currentThread().getName();
                System.out.println("enter = " + name);
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("end = " + name);
            });
        }
        try {

            System.out.println("main await = " );
            cb.await();
            System.out.println("main wake up " );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }
}
