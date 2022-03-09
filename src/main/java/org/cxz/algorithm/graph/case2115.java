package org.cxz.algorithm.graph;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/9 21:05
 */
public class case2115 {
    // ver 1
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,Integer> map = new HashMap();
        Set<String> setrecipes = new HashSet();
        Set<String> setsupplies = new HashSet();
        List<String> ans = new ArrayList();
        for(String s: supplies) setsupplies.add(s);
        for(int i = 0;i<recipes.length;i++){
            map.put(recipes[i],i);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(canMake(entry.getKey(),ingredients,setrecipes,setsupplies,map)){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    public boolean canMake(String recipe,
                           List<List<String>> ingredients,
                           Set<String> setrecipes,
                           Set<String> setsupplies,
                           Map<String,Integer> map){
        if(setrecipes.contains(recipe)||setsupplies.contains(recipe)) return true;
        if(!map.containsKey(recipe)) return false;

        List<String> ingredient = ingredients.get(map.get(recipe));
        boolean flag = true;
        for(int i=0;i<ingredient.size();i++){
            if(!canMake(ingredient.get(i),
                    ingredients,setrecipes,setsupplies,map)){
                return false;
            }
        }
        setrecipes.add(recipe);
        return flag;
    }

    //ver 2
    public List<String> findAllRecipes2(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Set<String>> g = new HashMap<>();
        int n = recipes.length;
        for (int i = 0; i < n; i++) {
            String recipe = recipes[i];
            List<String> ingredient = ingredients.get(i);
            map.put(recipe, ingredient.size());
            for (String s : ingredient) {
                if (!g.containsKey(s)) g.put(s, new HashSet<String>());
                g.get(s).add(recipe);
            }
        }
        for (String supply : supplies) {
            map.put(supply, 0);
            updata(supply, map, g);
        }
        List<String> ret = new ArrayList<>();
        for (String recipe : recipes) {
            if (map.get(recipe) == 0) ret.add(recipe);
        }
        return ret;
    }

    void updata(String s, Map<String, Integer> map,
                Map<String,Set<String>> g) {
        if (g.get(s) == null) return;
        for (String x : g.get(s)) {
            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) updata(x, map, g);
        }
    }
}
