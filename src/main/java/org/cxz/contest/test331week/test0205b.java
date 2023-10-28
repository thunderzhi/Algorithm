package org.cxz.contest.test331week;

import javax.xml.namespace.QName;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/2/5 0:58
 */
public class test0205b {
    public static void main(String[] args) {
        String[] words ={"aba","bcb","ece","aa","e"};
        int[][] q  = new int[][]{{0,2},{1,4},{1,1}};
        int[] ints = test0205b.vowelStrings(words, q);
        System.out.println("ints = " + Arrays.toString(ints));

    }
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int[] cnt = new int[n];
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            String s = words[i];
            int len = s.length();
            if(set.contains(s.charAt(0))&&
                    set.contains(s.charAt(len-1))){
                System.out.println("s = " + s);

                cnt[i]=1;
                //break;
            }
        }
        for (int i = 1; i <=n; i++) {
            sum[i] = sum[i-1] + cnt[i-1];
        }
        System.out.println("cnt = " + Arrays.toString(cnt));

        System.out.println("sum = " + Arrays.toString(sum));
        int qn = queries.length;
        int[] ans = new int[qn];
        for (int i = 0; i < qn; i++ ) {
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            System.out.println(" l = " + l+" r = " + r);
            ans[i] = sum[r+1]- sum[l];
        }
        return ans;

//        List<int[]> list = new ArrayList<>();
//        for (int i = 0; i < qn; i++) {
//            list.add(new int[]{queries[i][0],queries[i][1],i});
//        }
//        Collections.sort(list,(a,b)->{
//            if(a[0]!=b[0]) return a[0]-b[0];
//            return a[1]-b[1];
//        });




    }
}
