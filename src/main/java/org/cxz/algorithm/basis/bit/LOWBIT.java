package org.cxz.algorithm.basis.bit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/22 16:34
 */
public class LOWBIT {

    public static int lowbit(int x){
        return x&(-x);
    }
    public static void main(String[] args) {
        int n = 10;
        int[] A = new int[n];
        int[] C = new int[n+1];
        for (int i = 0; i < n; i++) {
            A[i] =i+1;
        }
        for (int i = 1; i < n + 1; i++) {
            int ind = i;
            StringBuilder sb = new StringBuilder();
            int lb = lowbit(ind);
            sb.append(" lowbit("+ind+")== "+lb+" lb binaryStr: "+getBs(lb)+" father: C["+ (lb+i)+"]");
            System.out.println("ind bstr= "+getBs(ind)+ " "+ sb.toString()+" Cur S["+ind+"]: "+getch(ind));
        }




    }
    public static String getBs(int i){
        return Integer.toBinaryString(i);
    }
    public static String getch(int i){
        StringBuilder sb = new StringBuilder(" include child: ");
        while(i>0){
            sb.append(" C["+i+"], { "+getBs(i)+" }");
            i = i-lowbit(i);

        }
        return sb.toString();
    }



}
