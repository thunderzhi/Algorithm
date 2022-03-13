package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/13 16:57
 */
public class case605 {
    //ver 1 greedy
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int p =0;
        int length = flowerbed.length;
        int cnt=0;
        while(p<length){
            if(cnt>=n) return true;
            int num = flowerbed[p];
            //System.out.println("p:"+p);
            // System.out.println("cnt:"+cnt);
            if(num==1){
                p=p+2;
                continue;
            }
            if(p+1>=length){
                cnt++;
                break;
            }
            if(flowerbed[p+1]==0){
                cnt++;
                p+=2;
                continue;
            }
            p = p+3;
        }
        return cnt>=n;
    }
}
