package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/7 23:39
 */
public class case008 {
    public static void main(String[] args) {
        String test= null;

        System.out.println("test.length() = " + test.length());
    }

    public int myAtoi(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int flag= 1;
        int premax = Integer.MAX_VALUE/10;
        int d = Integer.MAX_VALUE%10;
        int ind =0;
        while(ind<s.length()&&s.charAt(ind)==' '){//miss ind out of bound
            ind++;
        }
        if(ind==s.length()){
            return 0;//miss check
        }
        if(s.charAt(ind)=='-'){
            flag =-1;
            ind++;//miss
        }
        else if(s.charAt(ind)=='+'){//miss
            ind++;
        }
        int num =0;
        for(int i = ind;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9'){ //miss
                break;//miss
            }
            if(num>premax||(num==premax&&(s.charAt(i)-'0')>d)){//wrong
                if(flag>0){
                    return Integer.MAX_VALUE;
                }
                return Integer.MIN_VALUE;
            }
            num = num*10+(s.charAt(i)-'0');
        }
        return num*flag;
    }
}
