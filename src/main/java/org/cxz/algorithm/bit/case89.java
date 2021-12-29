package org.cxz.algorithm.bit;

import com.sun.org.apache.regexp.internal.REUtil;
import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/29 12:14
 */
public class case89 {

    public static void main(String[] args) {

    }

    public List<Integer> grayCode( int n) {
        Integer[] ans = new Integer[1<<n];
        //List<Integer> ans = new ArrayList<>();
        if(n==0){
            ans[0]=0;
            return new ArrayList<Integer>(Arrays.asList(ans));
        }
        List<Integer> arr_n_1 = grayCode(n-1);
        int len_n_1 = arr_n_1.size();
        for (int i = 0; i < len_n_1; i++) {
            //mirror
            ans[i] = arr_n_1.get(i)<<1;
            ans[2*len_n_1-i-1] =(arr_n_1.get(i)<<1)|1;
        }

        return new ArrayList<Integer>(Arrays.asList(ans));
    }


}
