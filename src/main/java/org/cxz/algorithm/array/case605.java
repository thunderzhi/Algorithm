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
    //20230929
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int pre = -2,len = flowerbed.length;
        int cnt = 0;
        for(int i=0;i<len;i++){
            if(flowerbed[i]==1){
                pre = i;
            }
            else{
                if(pre<i-1&&(i==len-1|| flowerbed[i+1]!=1)){
                    cnt++;
                    pre = i;
                }
            }
            if(cnt>=n) return true;
        }
        return false;
    }
}
