package org.cxz.contest.test20230910362week;

import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/10 10:20
 */
public class test0910b {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int[] lu,ld,ru,rd;
        lu = new int[]{sx-t ,sy-t};
        ld = new int[]{sx+t ,sy-t};
        ru = new int[]{sx-t ,sy+t};
        rd = new int[]{sx+t ,sy+t};
        if(fx>sx+t||fy>sy+t) return false;
        if(fx<sx-t||fy<sy-t) return false;
        if(fx==sx&&fy==sy&& t==1 ) return false;
        return true;

    }
}
