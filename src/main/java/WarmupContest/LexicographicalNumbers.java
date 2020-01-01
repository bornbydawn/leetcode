package WarmupContest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {

    public static List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>(n);

        for(int i = 1; i <= n; i++){
            list.add(String.valueOf(i));
        }



        Comparator<String> stringComparator = String::compareTo;
        list.sort(stringComparator);

        List<Integer> integerList = new ArrayList<>();
        list.forEach(l -> integerList.add(Integer.parseInt(l)));


        return integerList;

    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }
}
