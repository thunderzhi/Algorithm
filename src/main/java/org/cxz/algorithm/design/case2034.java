package org.cxz.algorithm.design;

import java.util.TreeMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/8 10:21
 */
public class case2034 {


    class StockPrice {
        TreeMap<Integer,Integer> fp;
        TreeMap<Integer,Integer> timep;
        int max,min;
        int cur;
        public StockPrice() {
            fp = new TreeMap();
            timep = new TreeMap();
            return;
        }

        public void update(int timestamp, int price) {
            cur = Math.max(cur, timestamp);
            if(!timep.containsKey(timestamp)){
                timep.put(timestamp,price);
                fp.put(price, fp.getOrDefault(price,0)+1);
                return;
            }
            // exist  ts and update price;
            int ov = timep.get(timestamp);
            if(ov==price) return;
            timep.put(timestamp,price);
            int fo = fp.get(ov);
            fo--;
            if(fo==0){
                fp.remove(ov);
            }
            else{
                fp.put(ov,fo);
            }
            fp.put(price, fp.getOrDefault(price,0)+1);
            return;
        }

        public int current() {

            int p = timep.get(cur);
            return p;
        }

        public int maximum() {
            return fp.lastKey();
        }

        public int minimum() {
            return fp.firstKey();
        }
    }

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
}
