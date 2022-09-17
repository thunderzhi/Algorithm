package org.cxz.thread.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/15 17:58
 */
public class TestJUC {

    public final boolean parkAndCheckInterrupt() {
        System.out.println("TestJUC exc ");
        LockSupport.park(this);
        System.out.println("TestJUC = ");
        return Thread.interrupted();
    }




}
