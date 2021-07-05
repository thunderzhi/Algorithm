package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/5 9:09
 */
public class case977 {

    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        if (nums.length ==1){
            return new int[]{ nums[0]*nums[0]};
        }
        int n = nums.length;
        int[] arr = new int[nums.length];
        int p =0,q=0;
        q = 1;
        while(  q < (n-1)&&nums[p]<0&&nums[p]*nums[q] > 0  ){
            p++;
            q++;
        }
        int k = 0;
        while(p>=0&&q<=(n-1)){
            int a = 0;
            int b = 0;
            int tmp=0;
            a = nums[p]*nums[p];
            b = nums[q]*nums[q];
            if(a<b){
                tmp = a;
                p--;
            }
            else{
                tmp = b;
                q++;
            }
            arr[k++] =tmp;
        }
        while(p>=0){
            arr[k++] = nums[p]*nums[p];
            p--;
        }
        while(q<=n-1){
            arr[k++] = nums[q]*nums[q];
            q++;
        }
        return arr;
    }
}
