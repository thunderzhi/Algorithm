package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/26 15:31
 */
public class case457 {


    public boolean circularArrayLoop(int[] nums) {
        for(int i =0;i<nums.length;i++){
            if(Math.abs(nums[i])>1000){
                continue;
            }
            int slow = i; int fast = i;
            do{
                slow = getNext(slow,nums);
                fast = getNext(getNext(fast,nums),nums);
            }while(slow!=fast);

            int neg = 0;
            int postive = 0;
            int l =0;
            do{
                fast = getNext(fast,nums);
                if(nums[fast]>0){postive++;}
                else{ neg++;}
                l++;
            }while(slow!=fast);
            if(l>1&&(neg==0||postive==0)){ return true;}

        }
        return false;
    }

    public int getNext(int i,int[] arr){
        int n = arr.length;
        int d = 1007*n;
        if(arr[i]<0){
            d*=-1;// cause keep orign symbol
        }
        arr[i] +=d;
        return ((i+arr[i])%n+n)%n;
    }
}
