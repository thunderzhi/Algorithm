package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/10 22:35
 */
public class caseO1616 {
    public int[] subSort(int[] array) {
        int m = -1, n = -1;
        int[] res = new int[2];
        int len = array.length;
        if (len > 1) {
            int left = array[0];
            int right = array[len - 1];
            for (int i = 0; i < len; i++) {
                int j = len - i - 1;
                System.out.println("j:"+j);
                if (array[i] < left) {
                    n = i;
                    System.out.println(array[i]+"<"+left+" n:"+n);
                } else {
                    left = array[i];
                }
                if (array[j] > right) {
                    m = j;
                    System.out.println(array[j]+">"+right+" m:"+m);

                } else {
                    right = array[j];
                }
            }
        }
        res[0] = m;
        res[1] = n;
        return res;
    }
}
