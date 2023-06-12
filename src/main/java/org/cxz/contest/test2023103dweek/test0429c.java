package org.cxz.contest.test2023103dweek;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/29 22:20
 */
public class test0429b {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
//：A = [2,3,1], B = [3,1,2]
        // 0 1 2->  2,0,1      0 1 2 -> 1,2,0
        int n = A.length;
        int[] C = new int[n];
        Set<Integer> setb = new HashSet<>();
        Set<Integer> seta = new HashSet<>();
        for (int i = 0; i < n; i++) {
            C[i] = i>0?C[i-1]:0;
            if(A[i]==B[i]){
                seta.add(A[i]);
                setb.add(B[i]);
                C[i] += 1;
                continue;
            }
            if(seta.contains(B[i])){
                System.out.println("seta.contains  " + B[i]);

                C[i]++;
            }
            seta.add(A[i]);
            if(setb.contains(A[i])){
                System.out.println("setb.contains  " + A[i]);


                C[i]++;
            }
            setb.add(B[i]);
            System.out.println("C["+i+"] = " + C[i]);
        }
        return C;



    }
}
