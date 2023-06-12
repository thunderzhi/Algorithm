package org.cxz.contest.test2023342week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/23 10:29
 */
public class test0423c {

    public boolean check(int x){
        if(x%3==0) return true;
        if(x%5==0) return true;
        if(x%7==0) return true;
        return false;
    }
    public int sumOfMultiples(int n) {
        int sum = 0;
        for(int i =1;i<=n;i++){
            if(check(i)){
                sum+=i;
            }
        }
        return sum;
    }
}
