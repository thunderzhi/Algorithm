package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/17 15:30
 */
public class case60 {

    public int pick(int n ,int[] nums){
        int i =0;
        int cnt = 0;
        while (cnt<n) {
            i++;
            if (nums[i] == 0) {
                cnt++;
            }
        }
        nums[i] =1;//miss
        return i;
    }
    public String getPermutation(int n, int k) {
        int base = 1;
        int[] mark = new int[n+1];
        for (int i = 2; i <n ; i++) {
            base *= i;
        }//(n-1)!//miss
        StringBuffer sb = new StringBuffer();
        for(int i =n;i>=1;i--){//miss
            int id = 1+(k-1)/base;//miss
            int ind = pick(id,mark);//miss
            sb.append(ind);//miss
            k-=(id-1)*base;//miss
            if(i>1){
                base = base/(i-1);//miss
            }
        }
        return sb.toString();
    }
}
