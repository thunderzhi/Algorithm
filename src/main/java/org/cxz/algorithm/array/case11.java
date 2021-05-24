package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/19 21:57
 */
public class case11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int n =height.length;
        int l=0;
        int r=n-1;
        int ans =0;
        while(l<r){
            int x = r-l;
            if(height[l]<height[r]){
                ans = Math.max(ans,x*height[l]);
                l++;
            }else{
                ans = Math.max(ans,x*height[r]);
                r--;
            }
        }
        return ans;
    }


}
