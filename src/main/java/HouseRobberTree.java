import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/house-robber-iii/
public class HouseRobberTree {

    public int rob(TreeNode root) {

        if(root == null) return 0;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s2.add(root);

        List<Integer> sumAtLevel = new ArrayList<>();
        int sum = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s2.isEmpty()){

                TreeNode node = s2.pop();
                sum += node.val;

                if(node.left != null){
                    s1.push(node.left);
                }
                if(node.right != null){
                    s1.push(node.right);
                }

            }

            sumAtLevel.add(sum);
            sum = 0;

            while(!s1.isEmpty()){

                TreeNode node = s1.pop();
                sum += node.val;

                if(node.left != null){
                    s2.push(node.left);
                }
                if(node.right != null){
                    s2.push(node.right);
                }

            }

            sumAtLevel.add(sum);

            sum = 0;


        }

        sumAtLevel.forEach(s -> System.out.println(s));

        int[] nums = new int[sumAtLevel.size()];

        for(int i = 0; i < nums.length; i++){
            nums[i] = sumAtLevel.get(i);
        }

        int[] store = new int[nums.length];
        for(int i = 0; i< store.length ; i++){
            store[i] = Integer.MIN_VALUE;
        }
        return getMax(nums, 0,store);

    }

    private int getMax(int[] nums, int i, int[] store){
        if(i >= nums.length) return 0;
        if(i == nums.length - 1)
            return nums[i];

        if(store[i] != Integer.MIN_VALUE) return store[i];
        else return store[i] =  Math.max((nums[i] + getMax(nums, i + 2, store)), getMax(nums, i + 1, store));
    }

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
