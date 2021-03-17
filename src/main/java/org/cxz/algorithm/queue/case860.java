package org.cxz.algorithm.queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/17 9:34
 */
public class case860 {

    public static void main(String[] args) {
        int[] arr = {5,5,5,10,20};
        boolean b = new case860().lemonadeChange(arr);
    }
    public boolean lemonadeChange(int[] bills) {
        int cnt5= 0,cnt10 =0;
        for (int bill : bills) {
            switch (bill){
                case 5:
                    cnt5+=1;
                    break;
                case 10:
                    if (cnt5==0){
                        return false;
                    }
                    cnt5-=1;
                    cnt10+=1;
                    break;
                case 20:
                    if(cnt5>=1&&cnt10>=1){
                        cnt5-=1;
                        cnt10-=1;

                    }
                    else if (cnt5>=3){
                        cnt5 = cnt5-3;

                    }
                    else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
