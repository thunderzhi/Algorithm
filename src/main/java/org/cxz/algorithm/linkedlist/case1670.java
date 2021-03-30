package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/14 22:16
 */
public class case1670 {
    public static Queue q1;
    public static Queue q2;



    static boolean isEmpty(){
        return q1.size() ==0;
    }

    //调整队列平衡  一般q1比q2多一个
    static void update(){
        if (q1.size()<q2.size()){
            q1.push_back(q2.front());
            q2.pop_front();
        }
        if(q1.size()==q2.size()+2){
            q2.push_front(q1.back());
            q1.pop_back();
        }

    }
    //队列前插
    static void pushFront(int val){
        q1.push_front(val);
        update();
    }
    //队列中插，在调整后插入q1尾
    static void pushMiddle(int val){
        if (q1.size()>q2.size()){
            q2.push_front(q1.back());
            q1.pop_back();
        }
        q1.push_back(val);
    }
    //队列尾插
    static void pushBack(int val){
        q2.push_back(val);
        update();
    }
    //队首出队
    static int popFront(){
        if (isEmpty()){
            return  -1;
        }
        int ret = q1.pop_front();
        update();
        return ret;
    }
    //队中出队，q1尾出，update
    static int popMiddle(){
        if (isEmpty()){
            return  -1;
        }
        int ret = q1.pop_back();
        update();;
        return ret;
    }
    //队尾出队，一般q2尾出，也有可能q1 尾出
    static int popBack(){
        if (isEmpty()){
            return  -1;
        }
        int ret;
        if (!q2.isEmpty()){
            ret =q2.pop_back();
        }
        else {
            ret = q1.pop_back();
        }
        update();
        return ret;
    }
    public static void main(String[] args) {
        //["FrontMiddleBackQueue","pushFront","pushBack","pushMiddle"
        // ,"pushMiddle","popFront","popMiddle","popMiddle",
        // "popBack","popFront"]
        //[[],[1],[2],[3],[4],[],[],[],[],[]]
        q1 = new Queue();
        q2 = new Queue();

        pushFront(1);
        System.out.println("null,null,null,null,null");
        pushBack(2);
        pushMiddle(3);
        pushMiddle(4);
        int i = popFront();
        System.out.println(i);
        int i1 = popMiddle();
        System.out.println(i1);

        int i2 = popMiddle();
        System.out.println(i2);

        int i3 = popBack();
        System.out.println(i3);


        int i4 = popFront();
        System.out.println(i4);

    }
}
