package org.cxz.algorithm.unionfind;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 14:36
 */
public class case990 {

    public static void main(String[] args) {


    }

    public boolean equationsPossible(String[] equations) {
        UnionSet u = new UnionSet(26);
        for (int i = 0; i < equations.length; i++) {
            char a = equations[i].charAt(0);
            char b = equations[i].charAt(3);
            int aind = a-'a';
            int bind = b-'a';
            if(equations[i].charAt(1)=='!'){
                continue;
            }
            u.merge(aind,bind);
        }
        for (int i = 0; i < equations.length; i++) {
            char a = equations[i].charAt(0);
            char b = equations[i].charAt(3);
            int aind = a-'a';
            int bind = b-'a';
            if(equations[i].charAt(1)=='!'&&u.get(aind)==u.get(bind)){
                return false;
            }
        }
        return true;
    }
}
