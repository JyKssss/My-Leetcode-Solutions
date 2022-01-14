package Math;

import java.util.ArrayList;
import java.util.List;

public class lc254 {
    List<List<Integer>> res;
    List<Integer> factors;
    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        factors = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        if (factors.size() == 0) {
            return res;
        }
        dfs(n, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int n, List<Integer> path, int index) {
        if (n == 1) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < factors.size() && factors.get(i) <= n; i++) {
            if (n % factors.get(i) == 0) {
                path.add(factors.get(i));
                dfs(n / factors.get(i), path, i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        lc254 obj = new lc254();
        System.out.println(obj.getFactors(12));
    }
}
