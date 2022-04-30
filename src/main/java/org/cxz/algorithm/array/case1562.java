package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/30 12:19
 */
public class case1562 {

    class UnionSet{
        int[] fa;
        int[] size;
        int[] cnt;
        public UnionSet(int n){
            fa = new int[n+1];
            size = new int[n+1];
            cnt = new int[n+2];
            for(int i=0;i<=n;i++){
                fa[i] = i;
                size[i] =1;
            }
            cnt[1] = n+1;
            return;
        }

        int get(int x){
            if(fa[x]==x) return x;
            return fa[x]=get(fa[x]);
        }
        void merge(int a ,int b){
            int aa = get(a),bb= get(b);
            if(aa ==bb )return;
            fa[aa] =bb;
            cnt[size[bb]] -=1;
            cnt[size[aa]] -=1;
            size[bb] +=size[aa];
            cnt[size[bb]] +=1;
            return;
        }

    }
    //ver1 CAP Unionset
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length,ans =-1;
        UnionSet u = new UnionSet(n);
        for(int i =0;i<n;i++){
            u.merge(arr[i],arr[i]-1);
            if(u.cnt[m+1]!=0) ans = i+1;
        }
        return ans;
    }

}
