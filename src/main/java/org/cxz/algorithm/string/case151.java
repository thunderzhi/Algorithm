package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/21 1:03
 */
public class case151 {

    public String reverseWords(String s) {
        List<String> arr = new ArrayList();
        s= s+"#";
        int left=0,right =0;
        while(left<s.length()){
            char c = s.charAt(left);
            if(c==' '){
                left++;
                continue;
            }
            if(c=='#') break;
            right=left;
            while(right<s.length()&&s.charAt(right)!=' '&&s.charAt(right)!='#'){
                right++;
            }
            if(right==s.length()){
                String str = s.substring(left,right-1);
                // System.out.println("left: "+left+" str: "+str);
                arr.add(0,str);
                break;
            }
            String str = s.substring(left,right);
            // System.out.println("left: "+left+" str: "+str);
            arr.add(0,str);
            left = right+1;
        }
        StringBuffer sb =new StringBuffer();
        for(String str : arr){
            sb.append(str+" ");
        }
        String res = sb.toString().trim();
        return res;
    }
}
