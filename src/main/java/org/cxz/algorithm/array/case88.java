package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/13 17:56
 */
public class case88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1,p2 = n-1,p3 = m+n-1;
        while(p1>=0||p2>=0){
            if(p2<0||(p2>=0&&p1>=0&&nums1[p1]>=nums2[p2])){
                nums1[p3--] = nums1[p1--];
            }
            else{
                nums1[p3--] = nums2[p2--];
            }
        }
        return;
    }
}
