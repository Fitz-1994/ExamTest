package alibaba;

public class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }

    //递归进行转换
    public static void convert(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left == null) {
            convert(root.right);
            TreeNode deepLeft = root.right.deepLeft();
            deepLeft.left = root;
            root.right = deepLeft;
            return;
        }
        convert(root.left);
        TreeNode leftDeepRight = root.left.deepRight();
        leftDeepRight.right = root;
        root.left = leftDeepRight;

        convert(root.right);
        TreeNode rightDeepLeft = root.right.deepLeft();
        root.right = rightDeepLeft;
        rightDeepLeft.left = root;

        return;
    }

    public TreeNode deepLeft() {
        if (this.left != null) {
            return this.left.deepLeft();
        }
        return this;
    }

    public TreeNode deepRight() {
        if (this.right != null) {
            return this.right.deepRight();
        }
        return this;
    }

    //主函数，构建查找二叉树，并转换成双向链表
    // 链表中left指向小的一边 right指向大的一边
    public static void main(String[] args) {
        TreeNode t9 = new TreeNode(9);
        TreeNode t5 = new TreeNode(5);
        TreeNode t13 = new TreeNode(13);
        TreeNode t3 = new TreeNode(3);
        TreeNode t7 = new TreeNode(7);
        TreeNode t11 = new TreeNode(11);
        TreeNode t15 = new TreeNode(15);
        t9.left = t5;
        t5.left = t3;
        t5.right = t7;
        t9.right = t13;
        t13.left = t11;
        t13.right = t15;
        convert(t9);
        System.out.println(t9);
    }

}
