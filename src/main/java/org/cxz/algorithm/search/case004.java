package org.cxz.algorithm.search;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/25 18:45
 */
public class case004 {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m+n+1)/2;
        double a = findk(nums1,nums2,0,0,mid);
        if ((m+n)%2==1) {
            return a;
        }
        double b = findk(nums1,nums2,0,0,mid+1);
        return (a+b)/2.0;
    }

    //i : search from nums1 start at nums1[i]
    //j : search from nums2 start at nums2[j]
    // k: the kth element in (nums1 and nums2)
    public double findk(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i==nums1.length){
            return nums2[j+k-1];//nums1 is empty,search nums2 start at nums2[j] to Kth element
        }
        if (j==nums2.length) {
            return nums1[i+k-1];
        }
        //nums1,nums2 are not empty
        if (k==1) {
            return nums1[i]<nums2[j]?nums1[i]:nums2[j];
        }// its all boundary

        int a = Math.min(k/2,nums1.length-i);//if left element of nums1 smaller than k/2,choose small one
        //cause get (a) element from nums1,now get the rest of (k-a) in nums2,
        // but if b dont have enough element ,we should choose the small one .
        int b = Math.min(k-a,nums2.length-j);
        a = k-b;//when we get b,go refresh a;
        if (nums1[i+a-1]<nums2[j+b-1]) {
            return findk(nums1,nums2,i+a,j,k-a);
        }
        else{
            return findk(nums1,nums2,i,j+b,k-b);
        }
    }


}
