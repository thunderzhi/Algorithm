package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/11 17:33
 */
public class case017 {
    public List<String> letterCombinations(String digits) {
        String[][] nums = {{},{},{"a","b","c"},
                {"d","e","f"},{"g","h","i"},{"j","k","l"},
                {"m","n","o"},{"p","q","r","s"},{"u","v","t"},
                {"w","x","y","z"}};
        List<String> ans = new ArrayList();
        if(digits.length()==0) return ans;
        List<List<String>> list = new ArrayList();
        for(int i =0;i<digits.length();i++){
            int ind = digits.charAt(i)-'0';
            List<String> t = new ArrayList();
            for(String s : nums[ind]){
                t.add(s);
            }
            list.add(t);
        }
        for(List<String> lt: list){
            ans = combinate(ans,lt);
        }
        return ans;
    }

    public List<String> combinate(List<String> S1,List<String> S2){
        List<String> ans = new ArrayList();
        if(S1.size()==0&&S2.size()==0) return ans;
        if(S1.size()>0&&S2.size()==0) return S1;
        if(S1.size()==0&&S2.size()>0) return S2;
        for(String str1: S1){
            for(String str2: S2){
                //String s = str1+str2;
                ans.add(str1+str2);
            }
        }
        return ans;
    }
}
