package org.cxz.algorithm.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/15 17:30
 */
public class case066 {

    //prue moni
    public int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length];
        int p = digits.length-1;
        Deque<Integer> st = new LinkedList();
        int mark = 0;
        while(p>=0){
            int i = digits[p];
            if(st.isEmpty()){ i +=1;}
            if(mark==1){
                i++;
                mark =0;
            }
            st.offerLast(i%10);
            mark = i/10;
            p--;
        }
        if(mark==1){
            ans = new int[digits.length+1];
            ans[0] =1;
            for(int i=1;i<ans.length;i++){
                ans[i] = st.pollLast();
            }
            return ans;
        }
        for(int i=0;i<ans.length;i++){
            ans[i] = st.pollLast();
        }
        return ans;
    }

    public int[] plusOne2(int[] digits) {
        int p = digits.length-1;
        while(p>=0){
            if(digits[p]!=9){
                digits[p]++;
                return digits;
            }
            digits[p--]=0;
        }
        int[] ans = new int[digits.length+1];
        ans[0] =1;
        return ans;
    }
}
