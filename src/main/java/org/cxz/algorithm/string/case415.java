package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/17 21:53
 */
public class case415 {
    public String addStrings(String num1, String num2) {
        int len1= num1.length(),len2= num2.length();
        int p1= len1-1,p2 = len2-1,carry =0 ;
        char[] ans = new char[Math.max(len1,len2)];
        int idx = ans.length-1;
        while(p1>=0||p2>=0||carry>0){
            int a = carry;
            if(p1>=0){
                a+=num1.charAt(p1)-'0';
                p1--;
            }
            if(p2>=0){
                a+=num2.charAt(p2)-'0';
                p2--;
            }
            carry = a/10; 
            if(idx<0){
                return 1+new String(ans);
            }
            ans[idx] = (char)(a%10+'0');
            idx--;
        }
        String s = new String(ans);
        return s;
    }
}
