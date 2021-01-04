package Tree;
//https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
public class TreeToSumTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(8);
        treeNode.left.right = new TreeNode(-4);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(5);

        TreeToSumTree treeToSumTree = new TreeToSumTree();
        treeToSumTree.toSumTree(treeNode);
        treeToSumTree.printInorder(treeNode);

    }

    public int toSumTree(TreeNode node){

        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return node.val;
        }

        int leftVal = toSumTree(node.left);
        int rightVal = toSumTree(node.right);

        node.val = node.val + leftVal + rightVal;

        return node.val;
    }

    void printInorder(TreeNode node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
