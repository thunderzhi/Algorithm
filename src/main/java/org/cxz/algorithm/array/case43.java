package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/1 22:44
 */
public class case43 {
    public static void main(String[] args) {
        String s1 ="999";
        String s2 ="999";
        String s =new case43().multiply(s1,s2);

        System.out.println("s = " + s);
    }

    public String multiply(String num1, String num2) {
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];
        //int[] c = new int[a.length+b.length-1];
        List<Integer> c = new ArrayList<>(a.length+b.length-1);
        for (int i = 0; i < a.length+b.length-1; i++) {
            c.add(0);
        }
        for (int i = 0; i < num1.length(); i++) {
            a[a.length-i-1] =num1.charAt(i) -'0';
        }
        for (int i = 0; i < num2.length(); i++) {
            b[b.length-i-1] =num2.charAt(i) -'0';
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                //System.out.println("before c["+(i+j)+"] = " + c[i+j]);
                //System.out.println("before c["+(i+j)+"] = " + c.get(i+j));
                int t = a[i]*b[j];
                //System.out.println("before a["+i+"] = " + a[i]+" b["+j+"] = " + b[j]+"==> t = "+t);
                //System.out.println("before a["+i+"] = " + a[i]+" b["+j+"] = " + b[j]+"==> t = "+t);
                //c[i+j]+=t;
                int ele = c.get(i+j)+t;
                c.set(i+j,ele);
                //System.out.println("after c["+(i+j)+"] = " + c[i+j]);
                //System.out.println("after c["+(i+j)+"] = " + c.get(i+j));
                //System.out.println("---------------- " );
            }
        }
        int n = c.size();
        for (int i = 0; i <n; i++) {
            if(c.get(i)<10){
                //System.out.println("C["+i+"] = " +c.get(i)+" 不进位");
            }
            if(i+1==c.size()){
                //System.out.println("push 0");
                c.add(0);
            }
            c.set(i+1,c.get(i+1)+c.get(i)/10);
            c.set(i,c.get(i)%10);
            //c[i+1] += c[i]/10;
            //c[i]%=10;
        }
        while(c.size()>1&&c.get(c.size()-1)==0){
            c.remove(c.size()-1);
        }
        StringBuilder sb =new StringBuilder();
        for (int i = c.size()-1; i >=0 ; i--) {
            char ch = (char)(c.get(i)+'0');
            sb.append(ch);
        }
        return sb.toString();


    }
}
