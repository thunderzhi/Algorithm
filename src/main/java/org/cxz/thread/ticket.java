package org.cxz.thread;

import javax.lang.model.SourceVersion;

/**
 * @author  
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/27 11:06
 */
public class ticket {

    public int cnt=300000;
    public void sale(){
        cnt--;

        //System.out.println("T name = " + Thread.currentThread().getName() + " cnt "+ cnt);
    }
}
