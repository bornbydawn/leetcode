package Tree;

public class LowestCommonAncestor {

    class BooleanWrapper{

        boolean b = false;

        public BooleanWrapper() {
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        root.right = new TreeNode(2);

        root.right.right = new TreeNode(3);

        int value1 = 2;
        int value2 = 3;



        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        BooleanWrapper v1 = lowestCommonAncestor.new BooleanWrapper();
        BooleanWrapper v2 = lowestCommonAncestor.new BooleanWrapper();
        TreeNode answer = lowestCommonAncestor.returnLCA(root, v1, v2, value1, value2);
        if(v1.b && v2.b){
            System.out.println(answer.val);
        }
        else{
            System.out.println("Not present");
        }
    }

    private TreeNode returnLCA(TreeNode node, BooleanWrapper v1, BooleanWrapper v2, int value1, int value2){
        if(node == null) return null;

        TreeNode temp = null;

        if(node.val == value1){
            v1.b = true;
            temp = node;
        }
        else if(node.val == value2){
            v2.b = true;
            temp = node;
        }


        TreeNode leftLCA = returnLCA(node.left, v1, v2, value1, value2);
        TreeNode rightLCA = returnLCA(node.right, v1, v2, value1, value2);

        if(temp != null)
        {
            return temp;
        }


        if(leftLCA != null && rightLCA != null){
            return node;
        }
        return leftLCA != null ? leftLCA : rightLCA;

    }



}
