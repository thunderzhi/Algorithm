package org.cxz.algorithm.dynamic;

import java.util.HashSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/7 14:47
 */
public class case217 {

    public static void main(String[] args) {


    }
    // duplicate ele in array
    // 1 sort the nums then travel array

    //2 use hashset
    public boolean containsDuplicate(int[] nums){
        HashSet set = new HashSet<Integer>();
        for(int t : nums){
            if(set.contains(t)){
                return true;
            }
            else{
                set.add(t);
            }

        }
        return false;
 
    }

}
