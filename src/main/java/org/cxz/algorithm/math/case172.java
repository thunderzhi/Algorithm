package org.cxz.algorithm.math;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/8 21:16
 */
public class case172 {
    public static void main(String[] args) {

    }

    public int trailingZeroes(int n) {
        int res =0;
        int m =5;
        while(n/m>0){
            res+= n/m;
            m =m*5;
        }
        return res;
    }
}
