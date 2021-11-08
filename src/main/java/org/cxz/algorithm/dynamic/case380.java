package org.cxz.algorithm.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/8 22:25
 */
public class case380 {
    class RandomizedSet {

        public List<Integer> arr;
        public HashMap<Integer,Integer> map;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            arr = new ArrayList();
            map = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            }
            arr.add(val);
            map.put(val,arr.size()-1);
            return true;
        }
        public void swap(int i,int j){
            int t = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,t);
        }


        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            int reind = map.get(val);
            int tailind = arr.size()-1;
            swap(reind,tailind);
            map.put(arr.get(reind),reind);//miss
            map.remove(val);
            arr.remove(tailind);
            return true;

        }

        /** Get a random element from the set. */
        public int getRandom() {
            int ind = new Random().nextInt(Integer.MAX_VALUE)%arr.size();
            return arr.get(ind);
        }
    }
}
