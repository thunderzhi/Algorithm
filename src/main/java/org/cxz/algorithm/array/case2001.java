package org.cxz.algorithm.array;

import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/26 12:52
 */
public class case2001 {

    public class Pair{
        public int width;
        public int height;
        public int c;
        public int hash;

        public Pair(int w,int h){
            c = gcd(w,h);
            width  = w/c;
            height = h/c;
            hash =(width*100001)^(height);
        }

        @Override
        public boolean equals(Object o){
            if(this==o){return true;}
            if(!(o instanceof Pair) ){return false;}
            return this.hashCode()==o.hashCode();
        }

        @Override
        public int hashCode(){
            return this.hash;
        }

    }

    public int gcd(int a,int b){
        if(b>0) return gcd(b,a%b);
        return a;
    }

    //ver 1 hash pair
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Pair,Integer> map = new HashMap<Pair,Integer>();
        long ans = 0;
        for(int i = 0;i<rectangles.length;i++){
            int w = rectangles[i][0];
            int h = rectangles[i][1];
            Pair p = new Pair(w,h);
            ans += map.getOrDefault(p,0);
            map.put(p,map.getOrDefault(p,0)+1);
        }
        return  ans;
    }


    // ver 2
    public long interchangeableRectangles2(int[][] rectangles) {
        HashMap<Double,Long> map = new HashMap<Double,Long>();
        long ans = 0;
        for(int i = 0;i<rectangles.length;i++){
            double w =(double) rectangles[i][0];
            double h = (double)rectangles[i][1];
            double p =(w/h);
            ans += map.getOrDefault(p,0L);
            map.put(p,map.getOrDefault(p,0L)+1L);
        }
        return  ans;
    }
}
