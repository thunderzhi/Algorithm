package org.cxz.thread.juctool;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/17 16:31
 */
public class TPEService {
    public static volatile Executor instance = null;

    public Executor getExecutor(){
        if(instance==null){
            synchronized (this){
                if(instance==null){
                    instance = new ThreadPoolExecutor(3,
                            6,
                            60L,
                            TimeUnit.MILLISECONDS,
                            new LinkedBlockingDeque<>());
                }
            }
        }
        return instance;
    }
}