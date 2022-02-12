package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.LinkedList;
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



    //ver 2 backtrack
    public List<String> ans;
    public List<String> letterCombinations2(String digits) {
        String[][] nums = {{},{},{"a","b","c"},
                {"d","e","f"},{"g","h","i"},{"j","k","l"},
                {"m","n","o"},{"p","q","r","s"},{"u","v","t"},
                {"w","x","y","z"}};
        ans = new ArrayList();
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
        LinkedList<String> track = new LinkedList();
        backtrack(track,0,list);
        return ans;
    }

    public void backtrack(LinkedList<String> track,int ind,List<List<String>> nums){
        if(track.size()==nums.size()){
            StringBuffer sb = new StringBuffer();
            for(String s: track){
                sb.append(s);
            }
            ans.add(sb.toString());
            return;
        }
        List<String> list = nums.get(ind);
        for(int i = 0;i<list.size();i++){
            track.add(list.get(i));
            backtrack(track,ind+1,nums);
            track.removeLast();
        }
        return;
    }
}
