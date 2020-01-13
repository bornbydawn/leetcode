import javafx.util.Pair;

import java.util.*;

public class OnesAndZeroes {

    public class Triplet{
        int k;
        int l;
        int m;

        public Triplet(int k, int l, int m) {
            this.k = k;
            this.l = l;
            this.m = m;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return k == triplet.k &&
                    l == triplet.l &&
                    m == triplet.m;
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, l, m);
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {

        List<Pair<Integer, Integer>> zeroOnes = calculateZeroesAndOnes(strs);

        Map<Triplet, Integer> map = new HashMap<>();

        return canForm(0, strs, m, n, zeroOnes, map);
    }

    private int canForm(int i, String[] strings, int m, int n, List<Pair<Integer, Integer>> zeroOnes, Map<Triplet, Integer> map) {

        if(i == strings.length) return 0;

        if(m == 0 && n == 0) return 0;


        if(map.containsKey(new Triplet(i,m,n))) return map.get(new Triplet(i,m,n));

        Pair<Integer, Integer> pair = zeroOnes.get(i);

        if(pair.getKey() <= m && pair.getValue() <=n){

            int max = Math.max(1 + canForm(i + 1, strings, m - pair.getKey(), n - pair.getValue(), zeroOnes, map),
                    canForm(i + 1, strings, m, n, zeroOnes, map));

            map.put(new Triplet(i,m,n), max);

            return max;

        }
        else{

            int max = canForm(i + 1, strings, m, n, zeroOnes, map);
            map.put(new Triplet(i,m,n), max);
            return max;
        }
    }


    private List<Pair<Integer, Integer>> calculateZeroesAndOnes(String[] strings){
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        int zeroes = 0;
        int ones = 0;
        for(String string : strings){
            char[] array = string.toCharArray();
            for(char c : array){
                switch (c) {
                    case '0':
                        zeroes++;
                        break;
                    case '1':
                        ones++;
                        break;
                }
            }
            list.add(new Pair<>(zeroes, ones));
            zeroes = 0;
            ones = 0;
        }
        return list;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"111","1000","1000","1000"};

        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();

        System.out.println(onesAndZeroes.findMaxForm(strings, 9, 3));

        //29
    }
}


//    private int canForm(int i, String[] strings, int m, int n, List<Pair<Integer, Integer>> zeroOnes) {
//
//        if(i == strings.length) return 0;
//
//        if(m == 0 && n == 0) return 0;
//
//        //if(store[i] != -1) return store[i];
//
//        Pair<Integer, Integer> pair = zeroOnes.get(i);
////        if(pair.getKey() <= m && pair.getValue() <=n){
////            return store[i] = Math.max(1 + canForm(i + 1, strings, m - pair.getKey(), n - pair.getValue(), zeroOnes, store),
////                    canForm(i + 1, strings, m, n, zeroOnes, store));
////        }
////        else{
////            return store[i] = canForm(i + 1, strings, m, n, zeroOnes, store);
////        }
//        if(pair.getKey() <= m && pair.getValue() <=n){
//            return Math.max(1 + canForm(i + 1, strings, m - pair.getKey(), n - pair.getValue(), zeroOnes),
//                    canForm(i + 1, strings, m, n, zeroOnes));
//        }
//        else{
//            return canForm(i + 1, strings, m, n, zeroOnes);
//        }
//    }