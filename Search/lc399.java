package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * dfs 预处理：先将所有等式乘除调换加入map
 */
public class lc399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size=equations.size();
        double[] values2=new double[2*size];
        for (int i = 0; i < size; i++) {
            List<String>equation=equations.get(i);
            List<String>addEquation=new ArrayList<>();
            addEquation.add(equation.get(1));
            addEquation.add(equation.get(0));
            equations.add(addEquation);
            values2[i]=values[i];
            values2[i+size]=(1/values[i]);
        }

        HashMap<String,List<Integer>>equationMap=new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            if (equationMap.containsKey(equations.get(i).get(0)))equationMap.get(equations.get(i).get(0)).add(i);
            else {
                List<Integer>addList=new ArrayList<>();
                addList.add(i);
                equationMap.put(equations.get(i).get(0),addList);
            }
        }
        double[] list=new double[queries.size()];
        HashSet<String>existSet=new HashSet<>();
        for (int i = 0; i < queries.size(); i++) {
            double[] res=dfs(1, queries.get(i).get(0), queries.get(i).get(1), equations, values2, equationMap, existSet);
            if (res.length==1)list[i]=-1.0;
            else list[i]=res[1];
        }
        return list;
    }

    public double[] dfs(double multiple,String s, String target, List<List<String>> equations, double[] values,HashMap<String,List<Integer>>equationMap,HashSet<String>existSet ){
        List<Integer>endIndexes=equationMap.get(s);
        if (!equationMap.containsKey(s))return new double[]{0};
        for(Integer index:endIndexes){
            String end=equations.get(index).get(1);
            if (existSet.contains(end))continue;
            else if (end.equals(target))return new double[]{1,multiple*values[index]};
            else {
                existSet.add(end);
                double[] res=dfs(multiple*values[index],end,target, equations, values, equationMap, existSet);
                existSet.remove(end);
                if (res.length==1)continue;
                else return res;
            }
        }
        return new double[]{0};
    }
}
