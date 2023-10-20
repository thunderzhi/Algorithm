package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/20 10:48
 */
public class case2525 {

    public String categorizeBox(int length, int width, int height, int mass) {
        if(checkbulkyAndHeavy(length,width,height,mass))return "Both";
        if(checkHeavy(mass)) return "Heavy";
        if(checkbulky(length,width,height,mass)&&!checkHeavy(mass)) return "Bulky";
        if(checkHeavy(mass)&&!checkbulky(length,width,height,mass)) return "Heavy";
        return "Neither";
    }

    public boolean checkV(int l,int w,int h){
        long v = l*w;
        v = v*h;
        return v>=1e9;
    }
    public boolean checkbulky(int l,int w,int h,int m){
        return (l>=10000||w>=10000||h>=10000||m>=10000)|| checkV(l,w,h);
    }
    public boolean checkHeavy(int m){
        return m>=100;
    }
    public boolean checkbulkyAndHeavy(int l,int w,int h,int m){
        return checkbulky(l,w,h,m)&&checkHeavy(m);
    }
}
