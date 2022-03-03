package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/3 12:05
 */
public class case696 {

    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, res = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) res++;
        }
        return res;
    }
}
