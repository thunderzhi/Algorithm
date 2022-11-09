package org.cxz.thread;

/**
 * @author
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/27 11:05
 */
public class testsale {

    public static void main(String[] args) throws InterruptedException {
        ticket tic = new ticket();
        Thread t1 = new Thread(()->{

            for (int i = 0; i < 100000; i++) {
                tic.sale();
                if(i%1000==0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                tic.sale();
                if(i%10000==0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t2");

        Thread t3 = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                tic.sale();
                if(i%100==0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t3");
        
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(2000);
        System.out.println("tic.cnt = " + tic.cnt);
    }
}
