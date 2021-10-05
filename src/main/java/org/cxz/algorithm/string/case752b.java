package org.cxz.algorithm.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/5 23:45
 */
public class case752b {
    public static void main(String[] args) {

    }

    public int openLock(String[] deadends, String target) {
        // 死亡组合
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int setp = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //跳过死亡组合
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)){
                    return setp;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }

                }
            }
            setp++;
        }
        return -1;
    }
    public String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9'){
            chars[i] = '0';
        }
        else{
            chars[i] += 1;
        }
        return new String(chars);
    }

    public String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0'){
            chars[i] = '9';
        }
        else {
            chars[i] -= 1;
        }
        return new String(chars);
    }

}
