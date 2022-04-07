package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/7 16:45
 */
public class caseOff067 {
    //ver1 bymy
    public int strToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        str = str.trim();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int m = max/10;
        int d = max%10;
        if(str.equals("")) return 0;
        boolean negative = false;
        int num = 0;
        char c = str.charAt(0);
        if((c<'0'||c>'9')&&c!='-'&&c!='+') return 0;
        int begin=0, p = 0,length = str.length();
        if(c=='+'||c=='-'){
            negative = c=='-'?true:false;
            begin++;
        }
        p = begin;
        while(p<length){
            c = str.charAt(p);
            if(c<'0'||c>'9') break;
            p++;
        }
        str = str.substring(begin,p);
        for(int i =0;i<str.length();i++){
            c = str.charAt(i);
            if(num>m||(num==m&&c-'0'>d)){
                return negative?min:max;
            }
            num = num*10+c-'0';
        }
        return negative?-num:num;
    }
}
