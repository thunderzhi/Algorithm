package org.cxz.algorithm.tire;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/14 13:44
 */
public class case241 {

    public List<Integer> diffWaysToCompute(String expression){
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            String left = "";
            String right = "";
            char c = expression.charAt(i);
            if(c!='+'&&c!='*'&&c!='-'){
                continue;
            }
            left = expression.substring(0,i);
            right = expression.substring(i+1);
            List<Integer> larr = diffWaysToCompute(left);
            List<Integer> rarr = diffWaysToCompute(right);
            for (Integer a :larr){
                for (Integer b : rarr) {
                    switch (c){
                        case '+': ans.add(a+b);break;
                        case '-': ans.add(a-b);break;
                        case '*': ans.add(a*b);break;
                    }
                }
            }
        }
        if (ans.size()==0) {
            int num =0;
            for (int i = 0; i < expression.length(); i++) {
                int t = expression.charAt(i)-'0';
                num = 10*num+t;
            }
            ans.add(num);
        }
        return ans;
    }

}
