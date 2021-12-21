package org.cxz.algorithm.tire;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/21 15:14
 */
public class MagicDictionarytest {

    public static void main(String[] args) {
        String[] input = new String[]{"hello", "leetcode"};
        MagicDictionary m = new MagicDictionary();
        m.buildDict(input);
        boolean res = m.search("hello");
        System.out.println("hello res = " + res);
          res = m.search("hhllo");
        System.out.println("hhllo res = " + res);




    }


}
