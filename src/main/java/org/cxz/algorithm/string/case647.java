package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/1 11:12
 */
public class case647 {

    // manacher
    public int countSubstrings(String s) {
        String str = getStr(s);
        int l =0 ,r =-1;
        int cnt=0;
        int n = str.length();
        int[] d = new int[n];
        for(int i =0;i<n;i++){
            if(i>r) d[i]=1;
            else d[i] = Math.min(r-i,d[r-i+l]);

            while(i-d[i]>=0&&i+d[i]<n&&str.charAt(i-d[i])==str.charAt(i+d[i])){
                d[i]++;
            }
            if(i-d[i]>=0&&i+d[i]>r){
                l = i-d[i];
                r = i+d[i];
            }
            cnt += d[i]/2;
        }
        return cnt;
    }

    public String getStr(String s){
        StringBuffer sb = new StringBuffer("#");
        for(int i= 0;i<s.length();i++){
            sb.append(s.charAt(i)+"#");
        }
        return sb.toString();
    }
}
