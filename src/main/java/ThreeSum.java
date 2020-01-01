import javafx.util.Pair;

import java.util.*;

public class ThreeSum {


    public static List<List<Integer>> threeSumExpensive(int[] nums) {


        ThreeSum.BooleanWrapper hasZeroSetCome = new ThreeSum.BooleanWrapper();
        Map<Integer, List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>>> twoSum = new HashMap<>();


        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i == j) continue;
                else if (twoSum.containsKey(nums[i] + nums[j])) {

                    List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> existingList = twoSum.get(nums[i] + nums[j]);

                    Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> pair = new Pair<>(new Pair<>(nums[i], i), new Pair<>(nums[j], j));
                    existingList.add(pair);

                    twoSum.put(nums[i] + nums[j], existingList);

                } else {
                    List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> newList = new ArrayList<>();
                    Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> pair = new Pair<>(new Pair<>(nums[i], i), new Pair<>(nums[j], j));
                    newList.add(pair);
                    twoSum.put(nums[i] + nums[j], newList);
                }
            }
        }
        Set<Integer> done = new HashSet<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (done.contains(nums[i])) {
                continue;
            } else {
                done.add(nums[i]);
                int diff = 0 - nums[i];
                if (twoSum.containsKey(diff)) {
                    int possiblePairs = twoSum.get(diff).size();

                    for (int j = 0; j < possiblePairs; j++) {
                        List<Integer> list = new ArrayList<>();
                        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> pair = twoSum.get(diff).get(j);

                        Pair<Integer, Integer> pair1 = pair.getKey();
                        Pair<Integer, Integer> pair2 = pair.getValue();

                        if (isValidSet(pair1.getValue(), pair2.getValue(), i)) {

                            list.add(nums[i]);
                            list.add(pair1.getKey());
                            list.add(pair2.getKey());
                            if (!doesSetExist(list, result, hasZeroSetCome)) {
                                result.add(list);
                            }
                        }


                    }
                }
            }

        }
        return result;
    }

    private static boolean isValidSet(int pairI, int pairJ, int currentI) {
        if (currentI == pairI) return false;
        if (currentI == pairJ) return false;

        return true;
    }

    private static boolean doesSetExist(List<Integer> target, List<List<Integer>> source, ThreeSum.BooleanWrapper hasZeroSetCome) {
        int listSize = source.size();

        if (target.get(0) == 0 && target.get(1) == 0 && target.get(2) == 0 && !hasZeroSetCome.bool) {
            hasZeroSetCome.bool = true;
            return false;
        }

        for (int i = 0; i < listSize; i++) {
            Set<Integer> set = new HashSet<>(3);

            List<Integer> sourceList = source.get(i);

            sourceList.forEach(s -> set.add(s));

            if (set.contains(target.get(0))) {
                if (set.contains(target.get(1))) {
                    if (set.contains(target.get(2))) {
                        if (target.get(0) == 0 && target.get(1) == 0 && target.get(2) == 0 && set.size() == 1 && !hasZeroSetCome.bool) {
                            hasZeroSetCome.bool = true;
                            return false;
                        } else {
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    static class BooleanWrapper {
        boolean bool = false;
    }

    static List<List<Integer>> threeSum(int[] nums){



        return null;
    }

    public static void main(String[] args) {

        //int[] input = new int[]{0,0,0,0};


        int[] input = new int[]{2,-8,8,6,-14,-12,11,-10,13,14,7,3,10,-13,3,-15,7,3,-11,-8,4,5,9,11,7,1,3,13,14,-13,3,-6,-6,-12,-15,-12,-9,3,-15,-11,-6,-1,0,11,2,-12,3,-6,6,0,-6,-12,-10,-12,6,5,-4,-5,-5,-4,-11,13,5,-2,-13,-3,-7,-15,8,-15,12,-13,0,-3,6,9,-8,-6,10,5,9,-11,0,7,-15,-8,-3,-4,-6,7,7,-2,-2,-11,3,0,-6,12,0,-13,4,-3,11,-11,1,2,13,8,4,9,-1,-2,5,14,12,5,13,-6,-13,-8,9,1,5,-8,-2,-6,-1};

        List<List<Integer>> result = threeSum(input);

        System.out.println(result);
    }
}
