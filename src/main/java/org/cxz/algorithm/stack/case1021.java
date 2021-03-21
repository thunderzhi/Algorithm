package org.cxz.algorithm.stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/21 16:44
 */
public class case1021 {
    public static void main(String[] args) {
        String s = new case1021().removeOuterParentheses("(()())(())");
        System.out.println(s);

    }
    public String removeOuterParentheses(String S) {
        StringBuilder ret =new StringBuilder();
        for (int i = 0 ,pre =0,cnt =0; i < S.length() ; i++) {
            if(S.charAt(i)=='('){
                cnt+=1;
            }
            else{
                cnt-=1;
            }
            if(cnt!=0){
                continue;
            }
            int begin = pre+1;
            int end = i;
            ret.append(S.substring(begin,end)) ;
            pre = i+1;
        }
        return ret.toString();
    }
}
