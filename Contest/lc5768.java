package Contest;

public class lc5768 {
    public int chalkReplacer(int[] chalk, int k) {
        int index=0,len=chalk.length;
        long sum=0;
        for (int i : chalk) {
            sum+=i;
        }
        if (k>sum){
            k-=sum*(k/sum);
        }

        while (k>=0){
            int cost=chalk[index%len];
            if (k>=cost){
                k-=cost;
            }
            else {
                return index%len;
            }
            index++;
        }
        return 0;
    }
}
