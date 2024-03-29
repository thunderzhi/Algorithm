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

    //ver 2 bignum
    List<String> list;
    public int[] printNumbers2(int n) {
        if(n<1) return new int[0];
        char[] numchar = new char[10];
        for(int i=0;i<10;i++){
            numchar[i] = (char)(i+'0');
        }
        list = new ArrayList();
        char[] number = new char[n];
        dfs(number,0);
        //System.out.println(list.toString());
        int[] ans = list.stream().mapToInt(Integer::parseInt).toArray();
        //new int[list.size()];
        return ans;
    }
    void dfs(char[] arr,int ind){
        if(ind==arr.length){
            String str = getstr(arr);
            if(str.equals("")) return;
            list.add(str);
            return;
        }

        for(int i=0;i<=9;i++){
            arr[ind] = (char)(i+'0');
            dfs(arr,ind+1);
            arr[ind] ='0';
        }
        return;
    }

    String getstr(char[] arr){
        StringBuffer sb = new StringBuffer();
        int p = 0,n = arr.length;
        while(p<n&&arr[p]=='0'){
            p++;
        }
        if(p==n) return "";
        while(p<n){
            sb.append(arr[p++]);
        }
        return sb.toString();
    }

}
