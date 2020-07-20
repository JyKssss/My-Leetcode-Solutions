package SystemDesign;

import javafx.util.Pair;

import java.util.Stack;

public class lc901 {
}

class StockSpanner {
    Stack<Pair<Integer,Integer>>stockStack;
    public StockSpanner() {
        stockStack=new Stack<>();
        stockStack.push(new Pair<>(Integer.MAX_VALUE, 1));
    }

    public int next(int price) {
        int length=1;
        while (stockStack.peek().getKey()<=price){
            length+=stockStack.pop().getValue();
        }
        stockStack.push(new Pair<>(price, length));
        return length;
    }
}
