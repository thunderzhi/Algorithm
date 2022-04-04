package org.cxz.algorithm.contest;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 10:35
 */
public class case6055 {
    public static void main(String[] args) {
        int res = new case6055().convertTime("11:34", "11:35");
        System.out.println("res = " + res);
    }
    public int convertTime(String current, String correct) {
        if(current.equals(correct)) return 0;
        int cutime = gettime(current);
        int cortime = gettime(correct);
        if(cortime<cutime){
            cortime += 60*24;
        }
        int diff = cortime - cutime;
        int[] div = new int[]{1,5,15,60};
        int p = div.length-1;
        int ans=0;
        while(p>=0){
            int m = diff%div[p];
            ans += diff/div[p];
            diff=m;
            p--;
        }
        return ans;
    }
    public int gettime(String s){
        return (s.charAt(0)-'0')*60*10+(s.charAt(1)-'0')*60
                +(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
    }

}
