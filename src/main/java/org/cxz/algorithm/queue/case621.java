package org.cxz.algorithm.queue;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/17 0:22
 */
public class case621 {
    public static void main(String[] args) {
        char[] t = {'A','A','A','B','B','B'};
        int i = new case621().leastInterval(t, 2);
        System.out.println(i);

    }
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            cnt[tasks[i]-'A']++;
        }
        Arrays.sort(cnt);
        int m= 0;
        for (int i = 25; i>=0&&cnt[i]==cnt[25] ; i--,m++) {

        }
        return Math.max(tasks.length,(cnt[25]-1)*(n+1)+m);
    }


}
