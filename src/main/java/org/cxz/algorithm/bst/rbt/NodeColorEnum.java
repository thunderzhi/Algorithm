package org.cxz.algorithm.bst.rbt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: Red black tree node color
 * @date 2021/11/18 15:25
 */
public enum NodeColorEnum {
    RED,
    BLACK,
    DOUBLE_BLACK;

    public static NodeColorEnum getEnum(int val){
        for (NodeColorEnum c: NodeColorEnum.values()){
            if(c.ordinal()==val){
                return c;
            }
        }
        return null;
    }
}
