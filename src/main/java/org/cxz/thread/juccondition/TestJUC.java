package org.cxz.thread.juccondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/15 17:58
 */
public class TestJUC {
//    public  void set1(){
//        lock.lock();
//        try {
//
//            while (hasValue==true){
//                condition.await();
//            }
//            System.out.println("print  ★");
//            hasValue = true;
//            condition.signal();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }
    public void fun1(TestService testService) {
        Thread t = Thread.currentThread();
        System.out.println("enter name = " + t.getName()+" in f1");
        System.out.println("sleep name = " + t.getName()+" in f1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep end name = " + t.getName()+" in f1");
        testService.lock.lock();
        System.out.println("get lock name = " + t.getName()+" in f1");
        try {

            while(!testService.flag){
                System.out.println("c1 await = " + t.getName()+" in f1");
                testService.c1.await();
            }
            System.out.println("c1 signal = " + t.getName()+" in f1");
            testService.c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            testService.lock.unlock();
        }
        System.out.println("name = " + t.getName()+" out f1");
    }

    public void fun2(TestService testService){
        Thread t = Thread.currentThread();
        System.out.println("enter name = " + t.getName()+" in f2");
        testService.lock.lock();
        try {
//            System.out.println("sleep name = " + t.getName()+" in f2");
//            Thread.sleep(2000);
//            System.out.println("sleep end name = " + t.getName()+" in f2");
            while(testService.flag){
                System.out.println("c2 await = " + t.getName()+" in f2");
                testService.c2.await();
            }
            System.out.println("c2 signal = " + t.getName()+" in f2");
            testService.c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            testService.lock.unlock();
        }
        System.out.println("name = " + t.getName()+" out f2");
    }




}
