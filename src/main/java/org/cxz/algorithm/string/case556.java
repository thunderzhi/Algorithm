package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/8/29 22:46
 */
public class case556 {
    public static void main(String[] args) {

    }
    public int nextGreaterElement(int x) {
        int nums = x;
        List<Integer> m = new ArrayList();
        while(nums>0){
            m.add(0,nums%10);
            nums/=10;
        }
        int len = m.size();
        //System.out.println("len: "+len);
        if(len==1) return -1;
        int i = len-2;
        while(i>=0&&m.get(i)>=m.get(i+1)){
            //System.out.println(i+" : "+m.get(i));
            i--;
        }
        if(i<0) return -1;
        int j = i+1,k =len-1;
        while(k>=j&&m.get(k)<=m.get(i)){
            k--;
        }
        swap(m,k,i);
        reverse(m,j);
        long ans = 0L;
        for(Integer t: m){
            ans = ans*10+t;
        }
        //System.out.println(" ans : "+ans);
        return ans>Integer.MAX_VALUE? -1:(int)ans;
    }
    public void reverse(List<Integer> a, int i){
        int p = a.size()-1;
        while(i<p){
            swap(a,i,p);
            i++;
            p--;
        }
        return;
    }

    public void swap(List<Integer> a,int i,int j){
        Integer t = a.get(i);
        a.set(i,a.get(j));
        a.set(j,t);
        return;
    }
}
