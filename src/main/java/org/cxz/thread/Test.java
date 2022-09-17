package org.cxz.thread;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/10 11:53
 */
public class Test {
    public int a ;
    public int b ;
    public volatile int c ;
    public Object lock;
    public Test(){
        a=0;
        b=0;
        c=0;
    }
    public Test(Object o){
        lock = o;
    }
    public void f1(){
        String name = Thread.currentThread().getName();

        System.out.println("f1 name: "+name+" a:"+a+" b:"+b+" c:"+c);
        a = 1;
        b = 1;
        c = 1;
        try {
            System.out.println("f1 sleep   " );
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("f1 out name: "+name+" a:"+a+" b:"+b+" c:"+c);

    }

    public void f2(){
        String name = Thread.currentThread().getName();
        System.out.println("f2 name: "+name+" a:"+a+" b:"+b+" c:"+c);

        a = 2;
        b = 2;
        c = 2;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("f2 out name: "+name+" a:"+a+" b:"+b+" c:"+c);


    }

    public void test(){
        try {
            String name = Thread.currentThread().getName();
            synchronized (lock){
                System.out.println("T name = " + name +" wait 1");
                Thread.sleep(3000);
                System.out.println("T name = " + name +" wait 2");

                lock.wait();
                System.out.println("T name = " + name +" wait up ");

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }

    public void notifytest(){
        synchronized (lock){
            lock.notifyAll();
        }
    }

}
