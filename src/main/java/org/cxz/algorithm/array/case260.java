package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/16 16:04
 */
public class case260 {
    public int[] singleNumber(int[] nums) {
        int t = 0;
        for(int x: nums) t^=x;
        int lb = t&(-t);
        int[] ans = new int[2];
        int min =Integer.MIN_VALUE,max = Integer.MAX_VALUE;
        System.out.println(" min "+min+ " min^1 "+(min^1)+ " t "+t+" -t"+ (-t));
        System.out.println(" lb "+lb);
        System.out.println(" max "+max+" max+1 "+(max+1));
        System.out.println(" min "+min+" min-1 "+(min-1));
        System.out.println(" max   "+Integer.toBinaryString(max));
        System.out.println(" max+1 "+Integer.toBinaryString(max+1));
        System.out.println(" -1 "+Integer.toBinaryString(-1));
        System.out.println(" 0  "+Integer.toBinaryString(0));


        for(int x: nums){
            int id = (x&lb)==0?0:1;
            ans[id] ^= x;
        }
        return ans;
    }
}
