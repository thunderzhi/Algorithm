package org.cxz.algorithm.off.I;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/26 17:59
 */
public class caseOff045 {
    //ver1 custom compare rule
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] numsarr = new String[nums.length];
        for(int i = 0;i<n;i++){
            numsarr[i] =String.valueOf(nums[i]);
        }
        Arrays.sort(numsarr,(o1, o2)->{
            if(o1.equals(o2)) return 0;
            String a = o1+o2;
            String b = o2+o1;
            return a.compareTo(b);
        });
        //System.out.println("numarr: "+ Arrays.toString(numsarr));
        StringBuffer sb = new StringBuffer();
        for(String s : numsarr){
            sb.append(s);
        }
        return sb.toString();
    }

}
