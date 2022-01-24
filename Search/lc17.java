package Search;

import java.util.ArrayList;
import java.util.List;

public class lc17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        String[] numToStr = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(digits, 0, new StringBuilder(), numToStr, res);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder combinationBuilder, String[] numToStr, List<String> res) {
        if (index == digits.length()) {
            res.add(combinationBuilder.toString());
            return;
        }
        String alpha = numToStr[digits.charAt(index) - '0'];
        for (int i = 0; i < alpha.length(); i++) {
            char cur = alpha.charAt(i);
            combinationBuilder.append(cur);
            dfs(digits, index + 1, combinationBuilder, numToStr, res);
            combinationBuilder.deleteCharAt(combinationBuilder.length() - 1);
        }
    }
}
