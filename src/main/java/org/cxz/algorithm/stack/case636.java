package org.cxz.algorithm.stack;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/18 15:51
 */
public class case636 {
    public static void main(String[] args) {
        String s = "0:start:0,1:start:2,1:end:5,0:end:6" ;
        String[] split = s.split(",");
        int[] ints = new case636().exclusiveTime(2,new ArrayList<>(Arrays.asList(split)) );
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> vid = new Stack<>();
        for (int i = 0,pre =0; i < logs.size(); i++) {
            String[] split = logs.get(i).split(":");
            String idstr =split[0];
            String statusstr =split[1];
            String timestr =split[2];
            int id = Integer.valueOf(idstr);
            int timestamp = Integer.valueOf(timestr);
            if (!vid.isEmpty()){
                res[vid.peek()]+=timestamp-pre+("end".equals(statusstr)?1:0);
            }

            pre = timestamp +("end".equals(statusstr)?1:0);
            if ("start".equals(statusstr)){
                vid.push(id);
            }
            else{
                vid.pop();
            }
        }
        return res;
    }
}
