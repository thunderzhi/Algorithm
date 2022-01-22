package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/22 17:21
 */
public class case229 {

    public List<Integer> majorityElement(int[] nums) {
        int a = 0;
        int b = 0;
        int a_cnt = 0;
        int b_cnt = 0;

        for(int i =0;i<nums.length;i++){
            int x = nums[i];
            //miss if else if condition
            if(a_cnt>0&&a==x){
                a_cnt+=1;
            }
            else if(b_cnt>0&&b==x){
                b_cnt+=1;
            }
            else if(a_cnt==0){
                a_cnt+=1;
                a =x;
            }
            else if(b_cnt==0){
                b_cnt+=1;
                b =x;
            }
            else{
                a_cnt-=1;
                b_cnt-=1;
            }
        }
        //System.out.println(" a_cnt: "+a_cnt+" b_cnt: "+b_cnt);
        a_cnt =0;
        b_cnt =0;
        List<Integer> ans = new ArrayList();
        int n = nums.length;
        for(int i =0;i<nums.length;i++){
            if(a==nums[i]){
                a_cnt++;
            }
            else if(b==nums[i]){ // miss else
                b_cnt++;
            }
        }
        if(a_cnt*3>n){
            ans.add(a);
        }
        if(b_cnt*3>n){
            ans.add(b);
        }
        return ans;

    }
}
