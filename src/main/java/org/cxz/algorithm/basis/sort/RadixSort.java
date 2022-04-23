package org.cxz.algorithm.basis.sort;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/22 16:48
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] ans = new int[]{
                11,22,33,44,55,66,
                -88,-99,-77,-66
        };
        new RadixSort().RadixSortTemplate(ans);
        System.out.println("Arrays.toString() = " + Arrays.toString(ans));
    }
    //low 16 bit
    public int l16(int x){
        return x&0xffff;
    }
    public int __high16(int x){
        return (x&0xffff0000)>>16;
    }
    //high 16 bit contain negetive
    public int h16(int x){
        int h = __high16(x);
        return h>32767?(h-32768):(h+32768);
    }


    public void RadixSortTemplate(int[] nums){
        int m = (1<<16);//65536
        int n = nums.length;
        int[] cnt = new int[m];
        int[] tmp = new int[n];
        for(int i =0;i<n;i++ ) cnt[l16(nums[i])]+=1;
        for(int i=1;i<m;i++) cnt[i]+=cnt[i-1];
        for(int i =n-1;i>=0;--i ) tmp[--cnt[l16(nums[i])]] = nums[i];
        Arrays.fill(cnt,0);// dont miss
        for(int i =0;i<n;i++ ) cnt[h16(tmp[i])]+=1;
        for(int i=1;i<m;i++) cnt[i]+=cnt[i-1];
        for(int i =n-1;i>=0;--i ) nums[--cnt[h16(tmp[i])]] = tmp[i];
        return;
    }

}
