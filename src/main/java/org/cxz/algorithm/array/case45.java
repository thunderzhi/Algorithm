package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/1 10:14
 */
public class case45 {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        if(nums.length <=1){
            return 0;
        }
        int pre = 1;
        int pos =nums[0];
        int cnt =1;
        while(pos+1<nums.length){
            int j = pre;
            for (int i = pre+1;i<=pos;i++){
                if(i+nums[i]>j+nums[j]){
                    j = i;
                }
            }
            pre = pos+1;
            pos = j+ nums[j];
            cnt+=1;
        }
        return cnt;
    }
}
