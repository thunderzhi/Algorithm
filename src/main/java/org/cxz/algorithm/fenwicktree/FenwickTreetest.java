package org.cxz.algorithm.fenwicktree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/28 14:38
 */
public class FenwickTreetest {

    public static void main(String[] args) {

        File file = new File("src/main/java/org/cxz/algorithm/fenwicktree/input");
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        int[] arr= new int[1];
        int n=0;
        String[] strarr = {};
        List<int[]> ops = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            n = Integer.valueOf(reader.readLine());
            System.out.println("n = " + n);
            arr = new int[n];
            strarr =reader.readLine().split(" ");


            String tmp =null;
            while((tmp =reader.readLine())!=null){
                String[] s = tmp.split(" ");
                int[] a = new int[2];
                a[0]= Integer.valueOf(s[0]);
                a[1]= Integer.valueOf(s[1]);
                ops.add(a);
            }

            //Scanner scan = new Scanner(System.in);
            //Scanner scan = new Scanner(reader);
            
//            String tempString = null;
//            int line = 1;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                System.out.println("line = " + line+" : "+tempString);
//                line++;
//                sb.append(tempString);
//            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        FenwickTree ft = new FenwickTree(n);
        for (int i = 1; i <= n; i++) {
            arr[i-1] = Integer.valueOf(strarr[i-1]);
            //System.out.println("i = " + arr[i-1]);
            ft.add(i,arr[i-1]);
        }
        ft.output();

        for (int i = 0; i < ops.size(); i++) {
            int ind = ops.get(i)[0];
            int val = ops.get(i)[1];

            System.out.println("change ind = " + ind +" to val = "+val);
            ft.add(ind,val-ft.getIndVal(ind));
            ft.output();
        }

    }



}
