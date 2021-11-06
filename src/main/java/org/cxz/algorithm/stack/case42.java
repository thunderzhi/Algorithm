package org.cxz.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/6 16:46
 */
public class case42 {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int ans =0;
        Deque<Integer> s = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while(!s.isEmpty()&&height[i]>height[s.peekLast()]){
                int ind = s.pollLast();
                if(s.size()>0){
                    int a = i-s.peekLast()-1;
                    int b = Math.min( height[s.peekLast()]-height[ind],height[i]-height[ind]);
                    ans += a*b;
                }
            }
            s.offerLast(i);
        }
        return ans;
        
    }
}
