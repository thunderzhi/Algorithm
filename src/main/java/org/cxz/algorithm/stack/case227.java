package org.cxz.algorithm.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/18 14:07
 */
public class case227 {

    public static void main(String[] args) {
         String s = "3+277*2";
         new case227().calculate(s);
    }
    public int calculate(String s) {
        Stack<String> op = new Stack<>();
        Stack<Integer> num = new Stack<Integer>();
        char[] operator = {'+','-','*','/'};
        String[] arr = s.split("[+ - * /]");
        char[] chars = s.toCharArray();
        LinkedList<String> linkedList = new LinkedList<String>();
        for (int i = 0; i <chars.length ; i++) {
            String tmp = String.valueOf(chars[i]);
            linkedList.offer(tmp);
        }

        for (int i = 0; i < arr.length; i++) {

        }
        



        return  0;
    }


}
