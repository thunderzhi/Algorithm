package org.cxz.contest.test2023353week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/8 22:29
 */
public class test0709d {

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] arr = new int[n];
        int ans = 1;
        int L = 0,R=-1;
        arr[L]= Math.min(nums1[L],nums2[L]);
        while(R<n){
            R++;
            if(R==n) break;

            int tmpmin = Math.min(nums1[R],nums2[R]);
            int tmpmax = Math.max(nums1[R],nums2[R]);
            System.out.println("R = " + R+" tmpmin "+tmpmin +" tmpmax "+tmpmin+ " ans "+ans);
            if(R>0){
                // arr[R-1] <= tmpmin
                if(arr[R-1]<=tmpmin){
                    System.out.println("arr[R-1] "+arr[R-1]+"<= tmpmin  " + tmpmin);
                    arr[R] = tmpmin;
                    ans = Math.max(ans,R-L+1);
                    continue;
                }
                // arr[R-1] > tmpmin
                else if(arr[R-1]>tmpmin&&arr[R-1]<=tmpmax){
                    System.out.println("arr[R-1] "+arr[R-1]+"between tmpmin tmpmax  ");
                    arr[R] = tmpmax;
                    ans = Math.max(ans,R-L+1);
                    continue;
                }
                else{
                    // can't  find
                    //L~~R-1 is meet requirements CALC length
                    System.out.println("CALC  R = "+R+" L= "+ L );
                    ans = Math.max(ans,R-L);
                }
            }
            // now shrink left
            // L<R and arr[l] can chose smaller
            // then try L+1~R may
            // if arr[l] can't smaller move left++
            while(L<R&&arr[L]== Math.min(nums1[L],nums2[L])){
                L++;
            }
            // maybe L==R ,or L<R arr[L] can chose smaller
            arr[L] = Math.min(nums1[L],nums2[L]);
            R = L;
        }
        return ans;

    }
}
