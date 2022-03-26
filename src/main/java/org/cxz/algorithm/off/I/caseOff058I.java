package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/26 18:02
 */
public class caseOff058I {
    public boolean mark;
    //ver1  step 1 reverse entire string and skip extra space ,
    // step 2 reverse each word
    public String reverseWords(String s) {
        mark = true;
        int n = s.length();
        String s1 = reverse(s,0,n-1);
        // System.out.println("s1: "+s1);
        if(!mark) return "";
        String res = process(s1);
        return res;
    }
    public String process(String s){
        int n = s.length();
        int l = 0,r = 0;
        StringBuffer sb = new StringBuffer();
        while(l<=r&&r<n){
            while(l==r&&s.charAt(l)==' '){l++;r++;}
            while(r<n&&s.charAt(r)!=' '){
                r++;
            }
            // System.out.println("l: "+l+" r: "+r);
            // System.out.println("st: "+reverse(s,l,r));
            sb.append(reverse(s,l,r));
            if(r==n) break;
            l=r;
            sb.append(' ');
        }
        return sb.toString();
    }

    public String reverse(String s,int l,int r){
        if(r==s.length()){r-=1;}
        StringBuffer sb = new StringBuffer();
        if(l==r&&s.charAt(l)!=' '){
            sb.append(s.charAt(l));
            return sb.toString();
        }
        while(l<=r&&s.charAt(l)==' ') l++;
        if(l==s.length()){
            mark = false;
            return s;
        }
        while(r>=l){
            while(r>=l&&s.charAt(r)==' ') r--;
            while(r>=l&&s.charAt(r)!=' '){
                sb.append(s.charAt(r--));
            }
            if(r<l) break;
            sb.append(' ');
        }
        return sb.toString();
    }

    //ver2  api
}
