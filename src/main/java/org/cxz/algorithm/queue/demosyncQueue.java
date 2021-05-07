package org.cxz.algorithm.queue;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/24 17:57
 */
public class demosyncQueue {
    public static void main(String[] args) throws Exception {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        int i = new Random().nextInt(100);
                        queue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.println(queue.take());

        }

    }
}
