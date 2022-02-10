package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/10 18:04
 */
public class case179 {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[]  strs = new String[n];
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){
            int x = nums[i];
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(o1, o2)->{
            String s1 = o1+o2;
            String s2 = o2+o1;
            return s2.compareTo(s1);
        });
        for(String s : strs){
            sb.append(s);
        }
        String ans = sb.toString();
        int k = 0;
        while(k<ans.length()-1&&ans.charAt(k)=='0'){
            k++;
        }
        return ans.substring(k);
    }
}
