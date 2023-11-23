package org.cxz.contest.test20231112371week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/12 10:29
 */
public class test1112c {
    int n,INF;
    public int minOperations(int[] nums1, int[] nums2) {
        // f[i][0]   第ith not swap ops
        // f[i][2]   第ith swap ops
        int n = nums1.length;
        int INF = Integer.MAX_VALUE/2;
        if(n==1) return 0;
        // not swap
        int op1 = 0, max1= nums1[n-1],max2= nums2[n-1];
        for (int i = n-2; i >=0 ; i--) {
            int x1 = nums1[i], y1 = nums2[i];
            if(x1<=max1&&y1<=max2) continue;
            if(y1<=max1&&x1<=max2){
                op1++;
                continue;
            }
            op1 = INF;
            break;
        }
        int op2 = 1;
        max1 = nums2[n-1];max2 = nums1[n-1];
        for (int i = n-2; i >=0 ; i--) {
            int x1 = nums1[i], y1 = nums2[i];
            if(x1<=max1&&y1<=max2) continue;
            if(y1<=max1&&x1<=max2){
                op2++;
                continue;
            }
            op2 = INF;
            break;
        }
        if(op1==INF&&op2==INF ) return -1;
        return Math.min(op1,op2);


    }
 
}
