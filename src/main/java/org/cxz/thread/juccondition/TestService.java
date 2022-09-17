package org.cxz.thread.juccondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/16 11:07
 */
public class TestService {
    public ReentrantLock lock = new ReentrantLock();
    public Condition c1 = lock.newCondition();
    public Condition c2 = lock.newCondition();
    public volatile boolean flag = false;



}
