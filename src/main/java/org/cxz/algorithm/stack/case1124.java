package org.cxz.algorithm.stack;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/23 15:39
 */
public class case1124 {
    public static void main(String[] args) {
        int[] ints = {9, 9, 6, 0, 6, 6, 9};
        //1,1,-1,-1,-1,-1,1
        //1,2,1,0,-1,-2,-1
        int i = new case1124().longestWPI(ints);

    }

    public int longestWPI(int[] hours) {
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
                    int i1 = f.get(cnt - 1) + (i - ind.get(cnt - 1));
                    f.put(cnt,i1);
                }
            }
            if(!ind.containsKey(cnt-1)){
                //没有出现过cnt-1，continue
                continue;
            }//否则就出现过cnt-1
            ans = Math.max(ans,i - ind.get(cnt-1)+f.get(cnt-1));
        }
        return ans;
    }

}


