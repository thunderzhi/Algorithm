package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/7 12:24
 */
public class case1592 {

    public String reorderSpaces(String text) {
        int cntspace = 0,cntword = 0,n = text.length();
        int p =0;
        while(p<n){
            char c = text.charAt(p);
            if(c==' '){
                cntspace++;
                p++;
            }
            else{
                while(p<n&&text.charAt(p)!=' '){
                    p++;
                }
                cntword++;
            }
        }
        if(cntword==1){
            StringBuilder ans = new StringBuilder();
            for(int i =0,j=0;i<n;i++){
                if(text.charAt(i)==' ') continue;
                j= i;
                while(j<n&&text.charAt(j)!=' ') j++;
                ans.append(text.substring(i,j));
                break;
            }
            append(ans,cntspace);
            return ans.toString();
        }
        int cnt = cntword-1;
        int avg = cntspace/cnt;
        int m = cntspace%cnt;
//System.out.println("cnt:"+cnt+" avg: "+avg+" m: "+m);
        StringBuilder sb = new StringBuilder();
        p = 0;
        while(p<n){
            char c = text.charAt(p);
            if(c==' '){
                p++;
            }
            else{
                int q = p;
                while(q<n&&text.charAt(q)!=' '){
                    sb.append(text.charAt(q++));
                }
                if(cnt>0){
                    append(sb,avg);
                    cnt--;
                }
                p = q;
            }
        }
        if(m>0){
            append(sb,m);
        }
        return sb.toString();
    }

    public void append(StringBuilder sb ,int cnt){
        int k = 0;
        while(k<cnt){
            sb.append(" ");
            k++;
        }
        return;
    }
}
