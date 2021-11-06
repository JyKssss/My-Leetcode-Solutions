package Array;

import java.util.HashMap;

public class lc904 {
    // only two types fruits
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, maxLength = 0;
        HashMap<Integer, Integer> typeMap = new HashMap<>();
        while (right < fruits.length){
            typeMap.put(fruits[right], typeMap.getOrDefault(fruits[right], 0) + 1);
            right ++;
            while (typeMap.size() > 2){
                if (typeMap.get(fruits[left]) > 1){
                    typeMap.put(fruits[left], typeMap.get(fruits[left]) - 1);
                }
                else {
                    typeMap.remove(fruits[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
