package org.cxz.thread.LC;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/12 18:26
 */
public class case1226 {
    public ReentrantLock[] forks;
    public Semaphore limit;
    public final int n = 5;
    public case1226() {
        forks = new ReentrantLock[5];
        for(int i =0;i<5;i++) forks[i] =new ReentrantLock();
        limit = new Semaphore(4);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        //0 1 2 3 4
        limit.acquire();
        int id = philosopher;
        int left = (id+1)%n,right = id;
        forks[left].lock();
        forks[right].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();
        forks[right].unlock();
        forks[left].unlock();

        limit.release();
    }
}
