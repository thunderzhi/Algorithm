package org.cxz.algorithm.stack;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/18 10:28
 */
public class case20 {

    public static void main(String[] args) {
        String s1 = "()[]{}";
        boolean valid = new case20().isValid(s1);
        System.out.println(valid);
    }

    public boolean isvalid(String s){
        int cnt =0;
        if(s.length()%2!=0){
            return false;
        }
        if (")}]".contains(String.valueOf(s.charAt(0)))) {
            return false;
        }
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case '(':
                    cnt+=1;
                    break;
                case '[':
                    cnt+=2;
                    break;
                case '{':
                    cnt+=3;
                    break;
                case ')':
                    cnt-=1;
                    break;
                case ']':
                    cnt-=2;
                    break;
                case '}':
                    cnt-=3;
                    break;
                default:
                    break;
            }
            if(cnt<0){
                return false;
            }
        }
        return cnt ==0 ?true:false;
    }



    public boolean isValid(String s) {

        if(s.length()%2!=0){
            return false;
        }

        if (")}]".contains(String.valueOf(s.charAt(0)))) {
            return false;
        }
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if(i==0){
                stack.push(str);
                continue;
            }
            if(stack.isEmpty()&&!isLeft(str)){
                return false;
            }
            if(isLeft(str)){
                stack.push(str);
                continue;
            }

            if(!stack.isEmpty()){
                String left = stack.peek();
                if(isMatch(left,str)){
                    stack.pop();
                }
                else{
                    return false;
                }
            }

        }
        return stack.isEmpty()? true:false;
    }
    public boolean isLeft(String c){
        String left ="({[";
        if (left.contains( c)) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isMatch(String left,String right){
        switch (right){
            case ")":
                return left.equals("(")?true:false;
            case "]":
                return left.equals("[")?true:false;
            case "}":
                return left.equals("{")?true:false;
            default:
                return false;
        }
    }
}
