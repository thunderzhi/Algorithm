package org.cxz.algorithm.stack;

import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/18 15:26
 */
public class case331 {
    public static void main(String[] args) {
        String s ="9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean validSerialization = new case331().isValidSerialization(s);
        System.out.println(validSerialization);
    }
    public boolean isValidSerialization(String preorder) {
        Stack<String> s = new Stack<>();
        String[] split =preorder.split(",");
        for (int i = 0 ,j = 0  ; i <split.length ; i++) {
            s.push(split[i]);
            int last = s.size()-1;
            while(s.size()>=3&&s.get(last).equals("#")
                    &&s.get(last-1).equals("#")
                    &&!s.get(last-2).equals("#")){
                s.set(last-2,"#");
                s.pop();
                s.pop();
                last = s.size()-1;
            }
        }
        return s.size()==1&&s.get(0).equals("#");

    }
}
