package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/27 10:05
 */
public class casefeibi {

    public static void main(String[] args) {
        int fib = new casefeibi().fib(48);
        System.out.println(fib);
    }
//45 134903163
    public int[] arr = new int[101];

    public int fib(int n) {
        int i = 2;
        arr[0]=0;
        arr[1]=1;
        int m = 1000000007;
        while(i<=n){
            arr[i] =arr[i-1]+arr[i-2];
            if (arr[i] > m) {
                arr[i] = arr[i] % m;
            }
            i++;
        }
        return arr[n];
    }

    public int fib2(int n) {
        if(n == 0){return 0;}
        if(n == 1){return 1;}
        int i = 2;
        int a = 0;
        int b = 1;
        int sum = 0;
        int m = 1000000007;
        while(i<=n){
            sum = a+b;
            if (sum > m) {
                sum = sum % m;
            }
            a=b;
            b = sum;
            i++;
        }
        return sum;
    }

    public int fib3(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int m = 1000000007;
        if(arr[n]==0){
            arr[n] = fib3(n-1)+fib3(n-2);
            if(arr[n]>m){
                arr[n]=arr[n]%m;
            }
        }
        return arr[n];
    }
}
