package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/13 19:58
 */
public class case658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList();
        int n = arr.length;
        int left =0,right=0;
        int ind = findcloser(arr,x);
        int cnt =1;
        int min = n;
        left = ind;
        right =ind;
        while(cnt<k){
            while(left==0&&cnt<k){
                right++;
                cnt++;
            }
            if(cnt==k) break;
            while(right==n-1&&cnt<k){
                left--;
                cnt++;
            }
            if(cnt==k) break;
            int ldis =getdistance(x,arr[left]);
            int rdis =getdistance(x,arr[right]);
            min =Math.min( ldis,rdis);
            if(ldis<=min){
                left--;
                cnt++;
                continue;
            }
            if(rdis<=min){
                right++;
                cnt++;
                continue;
            }
        }
        while(left>0&&compare(arr[left-1],arr[right],x)){
            left--;
            right--;
        }
        while(right<n-1){
            if(getdistance(x,arr[right+1])>=getdistance(x,arr[left])){
                break;
            }
            left++;
            right++;
        }
        while(left<=right){
            ans.add(arr[left++]);
        }
        return ans;
    }
    public boolean compare(int a,int b,int x){
        int adis = getdistance(x,a);
        int bdis = getdistance(x,b);
        if(adis<=bdis) return true;
        return false;
    }

    public int getdistance( int x,int y){
        int dis = 0;
        if(y==x) return dis;
        if(x*y>0){
            dis = Math.abs(Math.abs(y)-Math.abs(x));
        }
        else{
            dis = Math.abs(y)+Math.abs(x);
        }
        return dis;
    }

    public int findcloser(int[] arr,int x){
        int l=0,r=arr.length-1;
        int mid = 0;
        if(x>=arr[r]) return r;
        if(x<=arr[l]) return l;
        while(l<r){
            mid = l+(r-l)/2;
            if(arr[mid]<x){
                l=mid+1;
            }
            else{
                r = mid;
            }
        }
        if(arr[l]!=x){
            int a = getdistance(x,arr[l]);
            int b = getdistance(x,arr[l-1]);
            return a>b?(l-1):l;
        }
        return l;
    }
}
