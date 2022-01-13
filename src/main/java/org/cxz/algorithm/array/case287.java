package org.cxz.algorithm.array;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/13 16:37
 */
public class case287 {

    public int findDuplicate(int[] nums) {
        int p = 0,q=0;
        do{
            p = nums[p];
            q = nums[nums[q]];
        }while(p!=q);
        p= 0;
        while(p!=q){
            p = nums[p];
            q = nums[q];
        }
        return p ;
    }

}
