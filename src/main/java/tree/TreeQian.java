package tree;

import common.TreeNode;

public class TreeQian {
    public static void main(String[] args) {

    }

    // 中 --》 左 ---》右
    public static void printTreeQ(TreeNode root){
        if (root == null) return;
        System.out.println(root);
        printTreeQ(root.getLeft());
        printTreeQ(root.getRight());
    }

}
