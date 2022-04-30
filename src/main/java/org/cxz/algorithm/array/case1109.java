package org.cxz.algorithm.array;



/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/29 15:27
 */
public class case1109 {
    public static void main(String[] args) {

    }

    public class Fenwicktree{
        public int[] C;
        public int n;
        public Fenwicktree(int size){
            C = new int[size+1];
            n = size;
        }
        public int lowbit(int x){
            return x&(-x);
        }
        public void add(int i,int x){
            //s[i]= s[i-lowbit[i]]+c[i];
            while(i<=n){
                C[i] +=x;
                i = i+lowbit(i);
            }
            return;
        }
        public int query(int i){
            int sum =0;
            while (i>0){
                sum += C[i];
                i = i-lowbit(i);
            }
            return sum;
        }
        public int getI(int i){
            return query(i)-query(i-1);
        }
    }
    //ver1 cap fenwick
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        Fenwicktree ft = new Fenwicktree(n);
        for (int i = 0; i < bookings.length; i++) {
            int l = bookings[i][0];
            int r = bookings[i][1];
            int val = bookings[i][2];
            ft.add(l,val);
            ft.add(r+1,-val);
        }
        for (int i = 1; i <=n; i++) {
            ans[i-1] = ft.query(i);
        }
        return ans;
    }
    //ver2 Recommendation
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] ans = new int[n];
        int m = bookings.length;
        for(int i = 0;i<m;i++){
            int[] tmp = bookings[i];
            int x = tmp[0];
            int y = tmp[1];
            int cnt = tmp[2];
            ans[x-1] += cnt;
            if(y<n) ans[y] -=cnt;
        }

        for(int i =1;i<n;i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }
}
