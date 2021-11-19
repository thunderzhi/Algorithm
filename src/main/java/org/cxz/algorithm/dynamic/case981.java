package org.cxz.algorithm.dynamic;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/18 23:12
 */
public class case981 {

    public static void main(String[] args) {

    }

    class TimeMap {
        public HashMap<String,TreeMap<Integer,String>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(!map.containsKey(key)){
                TreeMap<Integer,String> treeMap = new TreeMap<>();
                treeMap.put(timestamp,value);
                map.put(key,treeMap);
                return;
            }
            TreeMap<Integer,String> treeMap = map.get(key);
            treeMap.put(timestamp,value);
            return;
        }

        public String get(String key, int timestamp) {
            String res ="";
            if(!map.containsKey(key)){
                return res;
            }
            TreeMap<Integer,String> treeMap = map.get(key);
            if(treeMap.containsKey(timestamp)){
                return treeMap.get(timestamp);
            }
            treeMap.put(timestamp,"");
            Integer lowkey = treeMap.lowerKey(timestamp);
            if(lowkey==null){
                return res;
            }
            res = treeMap.get(lowkey);
            treeMap.remove(timestamp);
            return res;
        }
    }

}
