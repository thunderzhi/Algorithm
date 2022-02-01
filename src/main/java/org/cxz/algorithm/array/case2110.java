package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/1 11:35
 */
public class case2110 {

    public void premark(int[] prices,int[] mark){
        int n = prices.length;
        int p =0;
        int sum =1;
        int q =0;
        while(p<n){
            if(p==n-1){
                if(prices[p-1]-prices[p]==1){
                    mark[p+1]=mark[p]==p?p:mark[p];
                }
                break;
            }
            sum = 1;
            q =p+1;
            //System.out.println("p: "+p+" q: "+ q);
            while(q<n&&prices[p]-prices[q]==sum){
                mark[q+1]= mark[q]==q?q:mark[q];
                q++;
                sum++;
            }
            p = q;
        }
    }
    public long getsum(long n){
        return (1+n)*n/2;
    }
    //ver 1 O(n) O(n)
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        if(n==1){
            return 1;
        }
        int[] mark = new int[n+1];
        for(int i =0;i<=n;i++){
            mark[i]=i;
        }
        premark(prices,mark);
        //System.out.println("mark: "+Arrays.toString(mark));
        long[] dp = new long[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(mark[i]==i){
                dp[i]= dp[i-1]+1;
            }
            else{
                long sum = getsum(i-mark[i]+1);
                //System.out.println("mark: "+i+": "+mark[i]+" sum: "+ sum);
                dp[i] =dp[mark[i]-1]+sum;
            }
            //System.out.println("dp: "+i+" : "+ dp[i]);
        }
        return dp[n];
    }
}
