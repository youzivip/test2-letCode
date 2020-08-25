package common;

import lombok.Data;

@Data
public class TreeNode<T > {
    TreeNode<T> left;
    TreeNode<T> right;
    T value;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return value+" ";
    }

    public static void printTree(TreeNode root){
        if (root==null) return;
        System.out.print(root+"   ");
        printTree(root.getLeft());
        printTree(root.getRight());
    }
}
