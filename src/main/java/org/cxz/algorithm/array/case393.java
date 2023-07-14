package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/14 16:58
 */
public class case393 {

    //m1 10000000
    //mask = (1<<8)-1  11111111  255
    int m1 = (1<<7),mask =(1<<8)-1;
    int m2 = mask^((1<<6)-1); //-->11000000
    int m3 = mask^((1<<5)-1); //-->11100000
    int m4 = mask^((1<<4)-1); //-->11110000
    int m5 = mask^((1<<3)-1);// -->11111000
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for(int i =0;i<n;){
            int type = gettype(data[i]);
            if(type==-1) return false;
            if(type==1){
                i++;
            }
            else{
                int j = i+type-1;
                if(j>=n) return false;
                i++;
                while(i<=j){
                    if((m2&data[i])!=m1){
                        return false;
                    }
                    i++;
                }
            }
        }
        return true; 
    }
    public int gettype(int x){
        if((m1&x)==0) return 1;// is 1Byte
        if((m3&x)==m2) return 2;// is 2Byte
        if((m4&x)==m3) return 3;// is 3Byte
        if((m5&x)==m4) return 4;// is 4Byte
        return -1;
    }
}
