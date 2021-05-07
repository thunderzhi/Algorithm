package org.cxz.algorithm.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/24 17:18
 */
public class demoarrayblockingQ {

    static ArrayBlockingQueue arrayBlockingQueue = new
            ArrayBlockingQueue(3);

    public static void main(String[] args) throws Exception {
        System.out.println(arrayBlockingQueue.size());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    addQueue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        arrayBlockingQueue();
    }

    public static void arrayBlockingQueue() throws Exception{
        arrayBlockingQueue.put(1);
        arrayBlockingQueue.put(2);
        arrayBlockingQueue.put(3);
        while (true){
            TimeUnit.SECONDS.sleep(3);
            System.out.println(arrayBlockingQueue.size()+"--"+arrayBlockingQueue.take());
        }
    }


    public static void addQueue() throws InterruptedException {
        while (true){
            TimeUnit.SECONDS.sleep(2);
            int i = new Random().nextInt(100);
            System.out.println("add "+ i);
            arrayBlockingQueue.put(i);
        }
    }
}
