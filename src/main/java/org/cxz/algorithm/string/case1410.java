package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/23 10:18
 */
public class case1410 {
    String[] strarr = new String[]{"","&quot;","&apos;","&amp;","&gt;","&lt;","&frasl;"};
    char[] rearr = new char[]{' ','\"','\'','&','>','<','/'};
    public int gettype(String s,int idx){
        int n = s.length();
        for(int i = 1;i<7;i++){
            String p = strarr[i];
            int len = p.length();
            int j = 0;
            while(j<len&&idx+j<n){

                if(p.charAt(j)!=s.charAt(idx+j)) break;
                j++;
            }
            if(j==len) return i;
        }
        return -1;
    }


    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int n = text.length();
        for(int i =0;i<n;i++){
            char c = text.charAt(i);
            if(c!='&'){
                sb.append(c);
            }
            else{
                int t = gettype(text,i);
                if(t<0){
                    sb.append(c);
                }
                else{
                    int len = strarr[t].length();
                    c = rearr[t];
                    sb.append(c);
                    i= i+ len-1;
                }
            }
        }
        return sb.toString();
    }
}
