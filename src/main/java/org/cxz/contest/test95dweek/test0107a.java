package org.cxz.contest.test95dweek;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/1/7 22:25
 */
public class test0107a {

    public String categorizeBox(int length, int width, int height, int mass) {
        int Bulky = 1, Heavy =2,Both = 3,nei = 0;

        long v = 0;
        long l = length,w = width,h = height;
        v = l*w*h;
        int status = 0;
        if((l>=10000||w>=10000||h>=10000)||v>=1e9){
            status |= Bulky;
        }
        if(mass>=100){
            status |= Heavy;
        }
        if(status==3) return "Both";
        if(status==1) return "Bulky";
        if(status==2) return "Heavy";
        return "Neither";
    }
}
