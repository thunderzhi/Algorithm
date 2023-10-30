package org.cxz.contest.test20231028369week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/28 21:44
 */
public class test1029b {

    public long minSum(int[] nums1, int[] nums2) {
        // s1   s2    === tot
        //cnta0 cntb0
        //1 if cnta0 ==0  && cntb0==0   only s1==s2  return s1 or -1
        //2 if cnta0==0 && cntb0>0
        // 2.1  s1<=s2 return -1
        // 2.2 s1>s2, and S = s1-s2 >=cntb0  return s1 else -1
        // 3 if cnta0>0 && cntb>0
        // tot>= s1+cnta, tot>=s2+cntb
        long s1 = 0 ,s2 =0,cnta =0,cntb=0;
        int n1 = nums1.length,n2 = nums2.length;
        for (int i = 0; i < n1 ; i++) {
            if(nums1[i]==0) cnta++;
            s1+=nums1[i];
        }
        for (int i = 0; i < n2 ; i++) {
            if(nums2[i]==0) cntb++;
            s2+=nums2[i];
        }
        if(cnta==0&&cntb==0) return s1==s2?s1:-1;
        if(cnta==0&&cntb>0){
            if(s1<=s2) return -1;
            return (s1-s2>=cntb)?s1:-1;
        }
        if(cnta>0&&cntb==0){
            if(s1>=s2) return -1;
            return (s2-s1>=cnta)?s2:-1;
        }
        return Math.max(s1+cnta,s2+cntb);

    }
}
