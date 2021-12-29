package Contest;

public class lc5954 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0 , right = plants.length - 1;
        int refillTime  = 0;
        int volA = capacityA, volB = capacityB;
        while (left < right) {
            if (volA >= plants[left]) {
                volA -= plants[left];
            } else {
                volA = capacityA - plants[left];
                refillTime += 1;
            }

            if (volB >= plants[right]) {
                volB -= plants[right];
            } else {
                volB = capacityA - plants[right];
                refillTime += 1;
            }
            left += 1;
            right -= 1;
        }

        if (left == right) {
            if (volA >= volB) {
                if (volA < plants[left]) {
                    refillTime += 1;
                }
            } else {
                if (volB < plants[left]) {
                    refillTime += 1;
                }
            }
        }
        return refillTime;
    }
}
