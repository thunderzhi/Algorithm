package org.cxz.algorithm.off.II;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/25 16:11
 */
public class caseOffII020 {

    //ver 1 manacher
    public int countSubstrings(String s) {
        String s2 =   getstr(s);
        int[] d = new int[s2.length()];
        int l =0,r=-1,n = s2.length(),cnt =0;
        for(int i = 0;i<n;i++){
            if(i>r) d[i] = 1;
            else d[i] = Math.min(r-i,d[r-i+l]);

            while(i+d[i]<n&&i-d[i]>=0&&s2.charAt(i+d[i])==s2.charAt(i-d[i])){
                d[i]++;
            }
            if(i-d[i]>=0&&i+d[i]>r){
                l = i-d[i];
                r = i+d[i];
            }
            cnt+= d[i]/2;
        }
        return cnt;
    }

    public String getstr(String s){
        StringBuffer sb = new StringBuffer("#");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)+"#");
        }
        return sb.toString();
    }
}
