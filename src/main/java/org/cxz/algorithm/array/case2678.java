package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/23 21:24
 */
public class case2678 {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String d: details){
            //0-9  10 11 12
            int age = (d.charAt(11)-'0')*10+(d.charAt(12)-'0');
            if(age>60)ans++;
        }
        return ans;
    }
}
