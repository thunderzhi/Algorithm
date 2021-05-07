package org.cxz.algorithm.queue;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/24 17:18
 */
public class demopriorityblockingQ {



    public static void main(String[] args) throws Exception {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>(5,new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        queue.add(100);
        queue.add(10);
        queue.add(20);

        while (!queue.isEmpty()){
            System.out.println(queue.take());
        }

    }


}
