package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/11 11:00
 */
public class off15 {
    public static void main(String[] args) {

    }

    public int haw(int n){
        int mask = 1;
        int cnt =0;
        for (int i= 0;i<32;i++){

            if ((n&mask)!=0) {
                cnt++;
            }
            mask<<=1;
        }
        return cnt;
    }
}
