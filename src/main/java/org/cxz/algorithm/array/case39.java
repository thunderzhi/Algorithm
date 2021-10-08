package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/8 18:03
 */
public class case39 {
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<List<Integer>> arr = new case39().combinationSum(nums,7);
        for (List<Integer> integers : arr) {
            System.out.println("Arrays.toString(integers) = " + integers.toString());
        }
    }


    public List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new LinkedList();
        LinkedList<Integer> list = new LinkedList();
        Arrays.sort(candidates);
        String id = UUID.randomUUID().toString().replaceAll("-","").substring(1,8);
        backtrack(0,candidates,list,target,id);

        return ans;
    }


    public void backtrack(int ind,int[] nums,LinkedList<Integer> track,int target,String id){
        System.out.println("---------enter uuid = " + id+"【target = "+target+" 】");
        if(target==0){
            ans.add(new LinkedList(track));
            System.out.println(id+" 》》》》return》》》》找到一个结果 = "  +track.toString() );
            return;
        }

        if(target<0){
            System.out.println(id+"  ★★★★return★★★★ 1 这里应该不会走到  "  +target );
            return;
        }

        if(ind==nums.length){
            System.out.println(id+"  ★★★★return★★★★ 2 扫到尾部了 return  "  +ind );
            return;
        }



        if(target- nums[ind]<0){
            System.out.println(id+"  ★★★★return★★★★ 3 target减去ind["+ind+"]="+nums[ind]+"的结果小于0无法继续 ind ="  + ind+" target = "+target  );
            return;
        }

        System.out.println(id+" 准备enter找下一个ind = " + (ind+1));
        String tid =id+"-->"+ UUID.randomUUID().toString().replaceAll("-","").substring(1,8);
        backtrack(ind+1,nums,track,target,tid);
        System.out.println(id+" 准备return找下一个ind = " + (ind+1));

        System.out.println(id+" 准备enter找当前ind = " + ind);
        track.add(nums[ind]);
        backtrack(ind,nums,track,target-nums[ind],tid);
        System.out.println(id+" 准备return找当前ind = " + ind);
        track.removeLast();


        System.out.println("return uuid = " + id);
        System.out.println("-------------------" + id);
        return;
    }
}
