package Tree;

public class FindNodeInIdenticalTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);



        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        root2.right.left = new TreeNode(4);

        root2.right.right = new TreeNode(3);

        FindNodeInIdenticalTree findNodeInIdenticalTree = new FindNodeInIdenticalTree();
        System.out.println(findNodeInIdenticalTree.getTargetCopy(root, root2, root.right.left).val);

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getTarget(original, cloned, target);
    }

    private TreeNode getTarget(TreeNode root1, TreeNode root2, final TreeNode target){
        if(root1 == null) return null;
        if(root1 == target){
                return root2;
        }
        TreeNode left = getTarget(root1.left, root2.left, target);
        if(left != null) return left;

        TreeNode right = getTarget(root1.right, root2.right, target);
        if(right != null) return right;

        return null;
    }

}
