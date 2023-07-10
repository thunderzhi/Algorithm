package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/9 16:55
 */
public class case1224 {
    public void del(Map<Integer,Integer> m1
            ,Map<Integer,Integer> numfreq
            ,int val){
        int f = numfreq.get(val);
        if(f-1==0){
            numfreq.remove(val);
            m1.put(f,m1.get(f)-1);
        }
        else{
            numfreq.put(val,f-1);
            m1.put(f,m1.get(f)-1);
            m1.put(f-1,m1.getOrDefault(f-1,0)+1);
        }
        if(m1.get(f)==0)  m1.remove(f);

        return;
    }
    public boolean check(Map<Integer,Integer> m1
            ,Map<Integer,Integer> numfreq){
        //System.out.println("size : "+m1.size());
        if(m1.size()>2) return false;
        if(m1.size()==1){
            for(int key: numfreq.keySet()){
                int f = numfreq.get(key);
                //System.out.println(" f: "+f);
                if(f>1&&numfreq.size()==1) return true;
                return f ==1;
            }
        }
        //freq ==2
        int f1=0,f2 =0;
        for(int val: numfreq.values()){
            if(f1!=0&&f2!=0) break;
            //System.out.println(" val: "+val);
            if(f1==0){
                f1 = val;
            }
            else if(f1!=val&&f2==0){
                f2=val;
            }
        }
        // System.out.println("f1: "+f1+ " f2 "+f2);
        // System.out.println("f1cnt: "+m1.get(f1)+ " f2cnt "+m1.get(f2));
        if((f1==1&&m1.get(f1)==1)||
                (f2==1&&m1.get(f2)==1)) return true;
        int maxf = Math.max(f1,f2);

        if(Math.abs(f1-f2)==1&&m1.get(maxf)==1){
            return true;
        }
        return false;
    }
    public int maxEqualFreq(int[] nums) {
        int n = nums.length;
        //System.out.println(" n "+n);

        Map<Integer,Integer> freqtoNummap = new HashMap();
        Map<Integer,Integer> numfreq= new HashMap();
        for(int num: nums){
            numfreq.put(num,numfreq.getOrDefault(num,0)+1);
        }
        for(int k: numfreq.keySet()){
            int v = numfreq.get(k);
            freqtoNummap.put(v,freqtoNummap.getOrDefault(v,0)+1);
        }
        if(check(freqtoNummap,numfreq)) return n;
        for(int i = n-1;i>=2;i--){
            del(freqtoNummap,numfreq,nums[i]);
            //System.out.println("----del: i "+i+ " : "+nums[i]);
            if(check(freqtoNummap,numfreq)) return i;
        }
        return 2;
    }

    //  ver2
    static int[] cnt = new int[100010], sum = new int[100010];
    public int maxEqualFreq2(int[] nums) {
        Arrays.fill(cnt, 0); Arrays.fill(sum, 0);
        int n = nums.length, max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i], cur = ++cnt[t], len = i + 1;
            sum[cur]++; sum[cur - 1]--;
            max = Math.max(max, cur);
            if (max == 1) ans = len;
            if (max * sum[max] + 1 == len) ans = len;
            if ((max - 1) * (sum[max - 1] + 1) + 1 == len) ans = len;
        }
        return ans;
    }

}
