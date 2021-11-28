package org.cxz.algorithm.bit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/28 11:46
 */
public class case461 {
    public static void main(String[] args) {

    }

    public int hammingDistance(int x, int y) {
        int t = x^y;
        int cnt=0;
        while(t>0){
            t&=(t-1);
            cnt++;
        }
        return cnt;
    }
}
