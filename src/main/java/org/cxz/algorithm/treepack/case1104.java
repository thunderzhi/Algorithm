package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/4 14:50
 */
public class case1104 {

    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            int[] pow = new int[31];
            pow[0] = 1;
            for(int i = 1;i<31;i++) pow[i] = pow[i-1]<<1;
            int l = 1,r = 30,mid =0,dep =0;
            while(l<r){
                mid = (l+r)/2;
                int low = pow[mid-1];
                int high = pow[mid]-1;
                if(low<= label&&label<=high){
                    dep = mid;
                    break;
                }
                else if(high<label){
                    l++;
                }
                else if(low>label){
                    r--;
                }
            }
//System.out.println("dep "+dep);
            List<Integer> ans = new ArrayList();
            int oid =0, curid = label;
            int curparent = 0,oparent = 0;
            while(dep>=1){
                // odd oid == curid
                // even oid ==  pow[dep-1]+pow[dep]-1 -curid
                ans.add(curid);
                if(dep==1) break;
                // 1 get orign id from curid in dep
                oid = dep%2==1?curid:(pow[dep-1]+pow[dep]-1 -curid);
                // 2 find orign parent in dep-1
                oparent = oid/2;
                // 3 get curparent from orign in dep-1
                if((dep-1)%2==1){
                    curparent = oparent;
                }
                else{
                    curparent = pow[dep-2]+pow[dep-1]-1-oparent;
                }
                curid = curparent;
                dep--;
            } 
            Collections.reverse(ans);
            return ans;
        }
    }
}
