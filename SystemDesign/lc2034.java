package SystemDesign;

import java.util.TreeMap;

public class lc2034 {
}
class StockPrice {

    public StockPrice() {
        this.timeStampMap = new TreeMap<>();
        this.orderPriceMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timeStampMap.containsKey(timestamp)) {
            int oldPrice = timeStampMap.get(timestamp);
            orderPriceMap.put(oldPrice, orderPriceMap.get(oldPrice) - 1);
            if (orderPriceMap.get(oldPrice) == 0) {
                orderPriceMap.remove(oldPrice);
            }
            timeStampMap.put(timestamp, price);
            orderPriceMap.putIfAbsent(price, 0);
            orderPriceMap.put(price, orderPriceMap.get(price) + 1);
        } else {
            timeStampMap.put(timestamp, price);
            orderPriceMap.putIfAbsent(price, 0);
            orderPriceMap.put(price, orderPriceMap.get(price) + 1);
        }
    }

    public int current() {
        return timeStampMap.lastEntry().getValue();
    }

    public int maximum() {
        return orderPriceMap.lastKey();
    }

    public int minimum() {
        return orderPriceMap.firstKey();
    }

    TreeMap<Integer, Integer> timeStampMap;
    TreeMap<Integer, Integer> orderPriceMap;
}