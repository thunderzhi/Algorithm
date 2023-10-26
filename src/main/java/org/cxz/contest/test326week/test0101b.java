package org.cxz.contest.test326week;

import com.sun.javafx.robot.FXRobotImage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/1/1 10:30
 */
public class test0101b {
    public int[] prime ;
    public int Eulerprime(int n){
        prime = new int[n+1];
        for(int i=2;i<=n;i++){
            if(prime[i]==0){
                prime[++prime[0]] = i;
            }
            for(int j = 1;j<=prime[0];j++){
                if(prime[j]*i>n) break;
                prime[prime[j]*i]=1;
                if(i%prime[j]==0) break;
            }
        }
        return prime[0];
    }
    public int distinctPrimeFactors(int[] nums) {
        Eulerprime(2000);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int t = 2;
            while(t<=nums[i]){
                System.out.println("t = " + t+" nums["+i+"]="+nums[i]);
                if(t==nums[i]){
                    set.add(t);
                    break;
                }
                else if(nums[i]%t==0){
                    set.add(t);
                    nums[i]/=t;
                }
                else{
                    t++;
                }
                System.out.println("set.size() = " + set.size());
            }
            System.out.println(" = " );
        }
        return set.size();
    }
}
