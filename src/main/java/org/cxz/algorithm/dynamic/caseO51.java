package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/6 15:42
 */
public class caseO51 {

    public static void main(String[] args) {

    }

    private int[] tmp;
    public int reversePairs(int[] nums) {
        tmp =new int[nums.length];
        return count(nums,0,nums.length-1);

    }

    public int count(int[] nums ,int l ,int r){
        if(l>=r){
            return 0;
        }
        int mid = (l+r)>>1;
        int ans =0;
        ans += count(nums,l,mid);
        ans += count(nums,mid+1,r);
        int k = l, p1 =l, p2 = mid+1;

        while(p1<=mid||p2<=r){
            if((p2>r)||(p1<mid&&nums[p1]<=nums[p2])){
                tmp[k++] = nums[p1++];
            }
            else{
                tmp[k++] = nums[p2++];
                ans += (mid -p1 +1);//from p1 to mid ,there (mid-p1+1) nums bigger than nums[p2]
            }
        }
        for (int i = l; i <=r ; i++) {
            nums[i] = tmp[i];
        }
        return ans;
    }



}
