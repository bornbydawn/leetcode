package Arrays;

import java.util.Map;
import java.util.Objects;

public class WiggleSubsequence {

    class Tripple {
        int x;
        int y;
        int z;

        public Tripple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tripple tripple = (Tripple) o;
            return x == tripple.x && y == tripple.y && z == tripple.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        //int[] nums = new int[]{0,0,0};
        int[] nums = new int[]{33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15};
        //int[] nums = new int[]{1,7,4,9,2,5};
        //int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
    }

//    public int wiggleMaxLength(int[] nums) {
//        Map<Tripple, Integer> map = new HashMap();
//        if (nums.length <= 1) return nums.length;
//        if (nums.length == 2) {
//            if (nums[0] == nums[1]) return 1;
//            else return 2;
//        }
//        return wiggleMaxLengthRecur(map, nums, 0, -1, -1);
//    }

    private int wiggleMaxLengthRecur(Map<Tripple, Integer> map, int[] nums, int i, int last, int secondLast) {
        //System.out.println("i:" + i + ", last:" + last + ", secondLast:" + secondLast);
        if (i == nums.length) return 0;
        if (map.containsKey(new Tripple(i, last, secondLast))) return map.get(new Tripple(i, last, secondLast));
        else if (i == 0) {
            map.put(new Tripple(i, last, secondLast), Math.max(1 + wiggleMaxLengthRecur(map, nums, i + 1, i, -1), wiggleMaxLengthRecur(map, nums, i + 1, -1, -1)));
            return map.get(new Tripple(i, last, secondLast));
        } else {
            if (last != -1 && secondLast != -1) {
                if (nums[last] > nums[secondLast]) {
                    //can take current
                    if (nums[i] < nums[last]) {
                        map.put(new Tripple(i, last, secondLast), Math.max(1 + wiggleMaxLengthRecur(map, nums, i + 1, i, last), wiggleMaxLengthRecur(map, nums, i + 1, last, secondLast)));
                        return map.get(new Tripple(i, last, secondLast));
                    }
                    //cant take current
                    else {
                        map.put(new Tripple(i, last, secondLast), wiggleMaxLengthRecur(map, nums, i + 1, last, secondLast));
                        return map.get(new Tripple(i, last, secondLast));

                    }
                } else if (nums[last] < nums[secondLast]) {
                    if (nums[i] > nums[last]) {
                        map.put(new Tripple(i, last, secondLast), Math.max(1 + wiggleMaxLengthRecur(map, nums, i + 1, i, last), wiggleMaxLengthRecur(map, nums, i + 1, last, secondLast)));
                        return map.get(new Tripple(i, last, secondLast));

                    } else {
                        map.put(new Tripple(i, last, secondLast), wiggleMaxLengthRecur(map, nums, i + 1, last, secondLast));
                        return map.get(new Tripple(i, last, secondLast));

                    }
                } else {
                    map.put(new Tripple(i, last, secondLast), wiggleMaxLengthRecur(map, nums, i + 1, last, secondLast));
                    return map.get(new Tripple(i, last, secondLast));

                }
            } else if (last != -1) {
                if (nums[i] != nums[last]) {
                    map.put(new Tripple(i, last, secondLast), Math.max(1 + wiggleMaxLengthRecur(map, nums, i + 1, i, last), wiggleMaxLengthRecur(map, nums, i + 1, last, -1)));
                    return map.get(new Tripple(i, last, secondLast));
                } else {
                    map.put(new Tripple(i, last, secondLast), wiggleMaxLengthRecur(map, nums, i + 1, last, secondLast));
                    return map.get(new Tripple(i, last, secondLast));
                }

            } else {
                map.put(new Tripple(i, last, secondLast), Math.max(1 + wiggleMaxLengthRecur(map, nums, i + 1, i, -1), wiggleMaxLengthRecur(map, nums, i + 1, -1, -1)));
                return map.get(new Tripple(i, last, secondLast));
            }
        }
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }
}
