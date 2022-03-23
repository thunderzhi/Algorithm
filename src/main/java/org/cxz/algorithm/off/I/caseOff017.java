package org.cxz.algorithm.off.I;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/15 16:06
 */
public class caseOff017 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("009");
        String[] strings = new caseOff017().printNumbers(3);
        for(String s :strings) System.out.println("s = " + s);

    }
    public String[] printNumbers(int n) {
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(ans,sb,n,0);
        String[] num = new String[ans.size()];
        for(int i=0;i<ans.size();i++) num[i] = ans.get(i);
        return num;
    }
    public void dfs(List<String> ans,StringBuffer sb, int length,int ind){
        if(ind==length){
            String s = print(sb);
            if(s.equals("0")) return;
            ans.add(print(sb));
            return;
        }

        for(int i =0;i<=9;i++){
            char c = (char)(i+'0');
            sb.append(c);
            dfs(ans,sb,length,ind+1);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
    public String print(StringBuffer sb){
        int l = sb.length();
        StringBuffer sb2 = new StringBuffer();
        int p=0;
        while(sb.charAt(p)=='0'&&p<l-1) p++;
        while(p<l){
            sb2.append(sb.charAt(p++));
        }
        return sb2.toString();
    }
}
