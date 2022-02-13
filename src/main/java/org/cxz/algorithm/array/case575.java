package org.cxz.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/13 19:34
 */
public class case575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet();
        int n = candyType.length;
        int eat = n/2;
        for(int type:candyType){
            set.add(type);
            if(set.size()>=eat){ return eat;}
        }
        return set.size();
    }
}
