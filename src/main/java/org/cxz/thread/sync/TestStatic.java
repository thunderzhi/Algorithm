package org.cxz.thread.sync;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/14 15:26
 */
public class TestStatic {

    public synchronized static void staticfun1(){
        Thread t = Thread.currentThread();
        System.out.println("name = " + t.getName()+" in f1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + t.getName()+" out f1 ");
    }

    public synchronized static void staticfun2(){
        Thread t = Thread.currentThread();
        System.out.println("name = " + t.getName()+" in f2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + t.getName()+" out f2");
    }
    public synchronized void fun3(){
        Thread t = Thread.currentThread();
        System.out.println("name = " + t.getName()+" in f3");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + t.getName()+" out f3");
    }

    public void fun4(){
        Thread t = Thread.currentThread();
//        synchronized(TestStatic.class){
        synchronized(this){
            System.out.println("name = " + t.getName()+" in f4");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name = " + t.getName()+" out f4");
        }

    }
}
