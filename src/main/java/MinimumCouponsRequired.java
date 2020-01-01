import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumCouponsRequired {

    public static void main(String[] args) {
        int amount = 13050;
        int[] denominations = new int[]{2000, 1000, 500, 250, 200};
        //System.out.println(getMinimumCount(amount, denominations, 0, 4, false));
        System.out.println(minCoins(denominations, denominations.length, amount));
    }

//    private static int getMinimumCount(int amount, int[] denominations, int i, int end, boolean printThis) {
//        if(printThis){
//            System.out.println("answer with denom: " + denominations[i]);
//        }
//
//        //System.out.println("amount: " + amount + " i: " + i);
//
//        if (amount == 0)
//        {
//            printThis = true;
//            return 0;
//        }
////        if (i > end) return Integer.MAX_VALUE;
//        if (i > end) {
//            return 1000;
//        }
//
//
//        if((amount / denominations[i])  > 0){
//
//            return Math.min(getMinimumCount(amount, denominations, i + 1, end, printThis), 1 + getMinimumCount((amount - denominations[i]), denominations, i, end, printThis));
//
//        }
//        else{
//            return getMinimumCount(amount, denominations, i + 1, end, printThis);
//        }
//
//
//
//    }

    static int minCoins(int coins[], int m, int V) {

        Map<Integer, Pair<Integer, List<Integer>>> map = new HashMap<>(V + 1);
        map.put(0, new Pair<>(0, new LinkedList<>()));

        for (int i = 1; i <= V; i++)
            map.put(i, new Pair<>(Integer.MAX_VALUE, null));

        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++)
                if (coins[j] <= i) {
                    int sub_res = map.get(i - coins[j]).getKey();

                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < map.get(i).getKey()) {

                        List<Integer> list = new LinkedList<>();
                        list.addAll(map.get(i - coins[j]).getValue());
                        list.add(coins[j]);

                        map.put(i, new Pair<>(sub_res + 1, list));

                    }
                }
        }

        System.out.println(map.get(V).getValue());
        return map.get(V).getKey();

    }
}
