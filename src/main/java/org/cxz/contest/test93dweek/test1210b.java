package org.cxz.contest.test93dweek;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/10 22:31
 */
public class test1210b {

    public int maximumValue(String[] strs) {
        int max =0;
        for(String s :strs){
            boolean isletter = false;
            for (int i = 0; i < s.length(); i++) {
                int t = 0;
                if(Character.isLetter(s.charAt(i))){
                    isletter = true;
                    break;
                }
            }
            max = Math.max(max,isletter? s.length():Integer.valueOf(s));
        }
        return max;
    }

}
