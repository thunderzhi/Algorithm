package org.cxz.algorithm.stack;

import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/23 15:39
 */
public class case1124b {
    public static void main(String[] args) {
        int[] ints = {9, 9, 6, 0, 6, 6, 9};
        //1,1,-1,-1,-1,-1,1
      //0 1,2,1,0,-1,-2,-1

        int i = new case1124b().longestWPI2(ints);

    }

    public int longestWPI(int[] hours) {
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        for (int i = 0; i < hours.length; i++){
            if (hours[i] > 8) {
                sum++;
            } else {
                sum--;
            }
            if (sum > 0) {
                res = i + 1;
            }
            else {
                if (!sumToIndex.containsKey(sum)){
                    sumToIndex.put(sum, i);
                }
                if (sumToIndex.containsKey(sum - 1)) {
                    res = Math.max(res, i - sumToIndex.get(sum - 1));
                }
            }
        }
        return res;
    }

    public int longestWPI2(int[] hours) {
        HashMap<Integer, Integer> ind = new HashMap<>();//每一种值第一次出现的位置
        HashMap<Integer, Integer> f = new HashMap<>();//每种值最长的序列长度
        ind.put(0,-1);//初始化，前缀和位置0 值为-1，数组的前缀和从位置1开始算
        f.put(0,0);
        int cnt = 0 ;//前缀和
        int ans = 0 ;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i]>8){
                cnt+=1;
            }
            else{
                cnt -=1;
            }
            if(!ind.containsKey(cnt)){
                //没有出现过cnt，cnt的位置就是i
                ind.put(cnt,i);
                if(!ind.containsKey(cnt-1)){
                    //没有出现过cnt 而且没有出现过cnt-1，cnt的位置就是i
                    f.put(cnt,0);
                }
                else{
                    //f.get(n) 代表以n为结尾的最长的序列长度
                    //计算f(n)=f(n-1)+pos(n)-pos(n-1)
                    int fN_1= f.get(cnt - 1);
                    int pos_n_N_1 =(i - ind.get(cnt - 1));

                    //int i1 = f.get(cnt - 1) + (i - ind.get(cnt - 1));
                    int i1 = fN_1 +pos_n_N_1;
                    f.put(cnt,i1);
                }
            }
            if(!ind.containsKey(cnt-1)){
                //没有出现过cnt-1，continue
                continue;
            }//否则就出现过cnt-1
            //计算当前f(n)和ans的max
            int b =i - ind.get(cnt-1)+f.get(cnt-1);
            //ans = Math.max(ans,i - ind.get(cnt-1)+f.get(cnt-1));
            ans = Math.max(ans,b);
        }
        return ans;
    }

}


