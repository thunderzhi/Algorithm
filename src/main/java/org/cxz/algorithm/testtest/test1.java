package org.cxz.algorithm.testtest;

import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/5/4 15:39
 */
public class test1 {
    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];
    public static void main(String[] args) throws InterruptedException {
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < DB_DATA.length; i++) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            arr[i] = new String(String.valueOf(DB_DATA[i %
                    DB_DATA.length])) ;
            //arr[i] = new String(String.valueOf(DB_DATA[i %
            //        DB_DATA.length])).intern();
        }
        System.out.println((System.currentTimeMillis() - t) + "ms");
        Thread.sleep(30000);
        System.gc();
    }


}
