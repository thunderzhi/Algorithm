package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/31 18:16
 */
public class case135 {

    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        int[] larr= new int[ratings.length];
        int[] rarr= new int[ratings.length];
        larr[0]=1;
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i]>ratings[i-1]){
                larr[i]=larr[i-1]+1;
            }
            else{
                larr[i]=1;
            }
        }
        rarr[ratings.length-1] =1;
        for (int i = ratings.length - 1; i >0 ; i--) {
            if(ratings[i-1]>ratings[i]){
                rarr[i-1]=rarr[i]+1;
            }
            else{
                rarr[i-1]=1;
            }
        }
        //int[] ans = new int[ratings.length];
        int ans  =0;
        for (int i = 0; i < ratings.length; i++) {
            ans += Math.max(larr[i],rarr[i]);
        }
        return ans;
    }
}
