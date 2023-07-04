package org.cxz.algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: this is from  352 week test
 * @date 2023/7/4 9:40
 */
public class case2761 {

    private static boolean[] flag = new boolean[1000000];
    static {
        for (int i = 2; i*i <= flag.length; i++) {
            if (!flag[i]) {
                for (int j = i*i; j < flag.length; j+= i) {
                    flag[j] = true;
                }
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (!flag[i] &&!flag[n-i]){
                list.add(Arrays.asList(i,n-i));
//                list.add(List.of(i, n - i));   // list.of supported by  java 9
            }
        }
        return list;
    }

}
