package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/9 21:22
 */
public class case763 {

    public List<Integer> partitionLabels(String s) {
        // a-z start arr， end arr
        Map<Character,Integer> chend = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            chend.put(ch,i);
        }
        int ind =0,n =s.length();
        List<Integer> ans = new ArrayList<>();
        while(ind<n){
            char ch = s.charAt(ind);
            int left = ind,right =chend.get(ch);
            int cnt =right - left+1;
            // System.out.println("ind:"+ind+" c:"+ch);
            // System.out.println("left:"+left);
            // System.out.println("right:"+right);
            while(left<right&&right<n){
                if(chend.get(s.charAt(left))<=right){
                    left++;
                    continue;
                }
                int length = chend.get(s.charAt(left))-ind+1;
                cnt = length;
                right = chend.get(s.charAt(left));
                left++;
                //System.out.println("cnt:"+cnt);
            }
            //System.out.println(" add cnt:"+cnt);
            ans.add(cnt);
            ind = right+1;
        }
        return ans;

        //扫描s，从0-n

        //寻找以i开头最短的 片段窗口
    }
}
