package org.cxz.contest.test1106;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/11/6 10:30
 */
public class test1106b {

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long max = 0;
        int l = 0, r = 0;
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        System.out.println("Arrays = " + Arrays.toString(presum));

        // ind -- val
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        // val---ind
        Map<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            int curind = r;
            int cur = nums[r];
            r++;
            System.out.println("r = " + r);
            if (!map.containsKey(cur)) {
                map.put(cur, curind);
                tm.put(curind, cur);
                //not contain calc
                int len = curind - l + 1;
                if (len > k) {
                    //adjust left
                    // move left 1

                    int left = nums[l];
                    System.out.println("1 len>k ");
                    System.out.println("remove ele  = " + left+" ind = "+l);
                    tm.remove(l);
                    map.remove(left);
                    l++;
                    continue;
                }
                // sum l--r  === presum  r+1- presum l
                // only len ==k
                if ((len == k) && max < presum[curind + 1] - presum[l]) {
                    System.out.println("len = " + len+" curind "+curind);
                    max = presum[curind + 1] - presum[l];
                }
            } else {
                //contain adjust left maybe >1
                int preind = map.get(cur);
                System.out.println("preind = " + preind);
                l = preind + 1;
                while (tm.containsKey(preind)) {
                    Integer leftk = tm.firstKey();
                    if (leftk <= preind) {
                        tm.remove(leftk);
                    }
                }
                map.put(cur, curind);
                tm.put(curind, cur);
            }
        }
        
        return max;

    }
}
