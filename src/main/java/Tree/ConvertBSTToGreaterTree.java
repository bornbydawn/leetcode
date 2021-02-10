package Tree;

import java.util.*;

public class ConvertBSTToGreaterTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);

        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        //TreeNode.print2D(root);
        ConvertBSTToGreaterTree object = new ConvertBSTToGreaterTree();
        object.convertBST(root);
        TreeNode.print2D(root);

    }

    /**
     * this method will work for all types of binary trees ot just BST
     * @param root
     * @return
     */
//    public TreeNode convertBST(TreeNode root) {
//        if (root == null || root.left == null && root.right == null) return root;
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//
//        List<Integer> values = new ArrayList<>();
//        while (!q.isEmpty()) {
//            int size = q.size();
//            while (size != 0) {
//                TreeNode currentNode = q.poll();
//                values.add(currentNode.val);
//                if (currentNode.left != null) {
//                    q.add(currentNode.left);
//                }
//                if (currentNode.right != null) {
//                    q.add(currentNode.right);
//                }
//                size--;
//            }
//        }
//
//        List<Integer> sortedList = new ArrayList<>(values);
//
//        Collections.sort(sortedList, Collections.reverseOrder());
//        Map<Integer, Integer> indexMap = new HashMap<>();
//
//        for(int i = 0; i < values.size(); i++){
//            for(int j = 0; j < values.size(); j++){
//                if(values.get(i) == sortedList.get(j)) {
//                    indexMap.put(i, j);
//                    break;
//                }
//            }
//        }
//        for(int j = 1; j < sortedList.size(); j++){
//            sortedList.set(j, sortedList.get(j) + sortedList.get(j - 1));
//        }
//
//        q.clear();
//        q.add(root);
//        int index = 0;
//        while (!q.isEmpty()) {
//            int size = q.size();
//            while (size != 0) {
//                TreeNode currentNode = q.poll();
//                currentNode.val = sortedList.get(indexMap.get(index));
//                index++;
//                if (currentNode.left != null) {
//                    q.add(currentNode.left);
//                }
//                if (currentNode.right != null) {
//                    q.add(currentNode.right);
//                }
//                size--;
//            }
//        }
//        return root;
//    }

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
