package org.cxz.algorithm.dynamic;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/11 15:59
 */
public class case690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        int sum =0;
        //Employee[] arr = new Employee[2002];
        Map<Integer,Employee> map = new HashMap<Integer,Employee>();
        for(Employee e: employees){
            map.put(e.id,e);
        }

        Queue<Integer> qu = new LinkedList();
        qu.offer(id);
        while(!qu.isEmpty()){
            int length = qu.size();
            for(int i =0;i<length;i++){
                Employee emp = map.get(qu.poll());
                sum +=emp.importance;
                for(int eid: emp.subordinates){
                    qu.offer(eid);
                }
            }
        }
        return sum;

    }
}
