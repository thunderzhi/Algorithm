package org.cxz.algorithm.search;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/31 21:16
 */
public class case365 {
    public static void main(String[] args) {

    }
    class Tuple{
        int a;
        int b;
        Tuple(int x,int y){
            this.a = x;
            this.b = y;
        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Tuple tuple = (Tuple) o;
//            return a == tuple.a &&
//                    b == tuple.b;
//        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
    public Tuple getNext(int status,int x,int X,int y ,int Y){
        switch (status){
            case 0:
                return new Tuple(X,y);
            case 1:
                return new Tuple(x,Y);
            case 2:{
                int w = Math.min(x,Y-y);
                return new Tuple(x-w,y+w);
            }
            case 3:{
                int w = Math.min(X-x,y);
                return new Tuple(x+w,y-w);
            }
            case 4:
                return new Tuple(0,y);
            case 5:
                return new Tuple(x,0);
        }
        return new Tuple(0,0);
    }
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        HashSet<Tuple> set = new HashSet<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0,0));
        while(!queue.isEmpty()){
            Tuple t = queue.peek();
            queue.poll();
            if(t.a+t.b==targetCapacity){
                return true;
            }
            for (int i = 0; i < 6; i++) {
                Tuple tmp = getNext(i,t.a,jug1Capacity,t.b,jug2Capacity);
                if(set.contains(tmp)){
                    continue;
                }
                set.add(tmp);
                queue.offer(tmp);
            }
        }
        return false;
    }

    public boolean canMeasureWater2(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int x = jug1Capacity, y = jug2Capacity, z = targetCapacity;
        if (x == z || y == z || z == 0) return true;
        if (x + y < z || x == y && x + y != z) return false;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp + x <= x + y && set.add(temp + x)) {
                queue.offer(temp + x);
            }
            if (temp + y <= x + y && set.add(temp + y)) {
                queue.offer(temp + y);
            }
            if (temp - x >= 0 && set.add(temp - x)) {
                queue.offer(temp - x);
            }
            if (temp - y >= 0 && set.add(temp - y)) {
                queue.offer(temp - y);
            }
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }
}
