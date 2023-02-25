package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/2/25 11:07
 */
public class case609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap();
        int n= paths.length;
        for(int i=0;i<n;i++){
            String[] arr = paths[i].split(" ");
            String path = arr[0]+"/";
// System.out.println(" path: "+path);

            for(int j =1;j<arr.length;j++){
                String s = arr[j];
                int p =0;
                while(s.charAt(p)!='(') p++;
                String file = s.substring(0,p);
                String txt = s.substring(p+1,s.length()-1);
// System.out.println(" file: "+file+" txt: "+txt);
                if(!map.containsKey(txt)){
                    map.put(txt,new ArrayList());
                }
                List<String> list = map.get(txt );
                list.add(path+file);
// System.out.println(" txt: "+txt+" list: "+list.size());

            }
        }
        List<List<String>> ans = new ArrayList();
        for(Map.Entry<String,List<String>> en: map.entrySet()){
            if(en.getValue().size()>1){
                // List<String> t =
                ans.add(en.getValue());
            }
        }
        return ans;
    }
}
