package org.cxz.algorithm.contest;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/16 23:19
 */
public class case6062 {
    public static void main(String[] args) {

    }
    //not pass
    class ATM {
        long total ;
        long[] cashNum ;
        long[] display ;
        int max =0;
        public ATM() {
            total =0;
            cashNum = new long[5];
            display = new long[]{20,50,100,200,500};
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5 ; i++) {
                cashNum[i] += banknotesCount[i];
                total+=banknotesCount[i]*display[i];
                if(banknotesCount[i]>0){
                    max = i;
                }
            }
            return;
        }

        public int[] withdraw(int amount) {
            if(amount>total) return new int[]{-1};
            int[] ans = new int[5];

            if (!check(ans,amount)){
                return new int[]{-1};
            }
            int tmp = 0;
            for (int i = 0; i <5; i++) {
                if(ans[i]==0) continue;
                cashNum[i] -= ans[i];
                if(cashNum[i]>0){
                    tmp=Math.max(tmp,i);
                }
            }
            max= tmp;

            total -= amount;
            return ans;
        }
        public boolean check(int[] arr,int amount){
            return true;
//            long[] ans = new long[5];
//            long[] cnt = new long[5];
//            for (int i = 0; i < 5; i++) {
//                cnt[i] =cashNum[i];
//            }
//            long sum = amount;
//            for (int i = 4; i >=0 ; i--) {
//                if(cnt[i]==0) continue;
//
//
//            }
        }

    }
}
