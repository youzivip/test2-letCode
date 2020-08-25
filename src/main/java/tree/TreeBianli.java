package tree;

import common.TreeNode;

public class TreeBianli {
    public static void main(String[] args) {

        TreeNode treeNode = buildTree();
        System.out.println(treeNode);
        recusion(treeNode,1);
        System.out.println(String.format("第%s层有%s个节点：",level,sum));
    }

    public static TreeNode<Integer> buildTree(){
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.setLeft(left1);
        root.setRight(right1);
        TreeNode left21 = new TreeNode(4);
        TreeNode right21 = new TreeNode(5);
        left1.setLeft(left21);
        left1.setRight(right21);
        TreeNode left22 = new TreeNode(56);
        TreeNode right22= new TreeNode(78);
        right1.setLeft(left22);
        right1.setRight(right22);
        return root;
    }

    static int sum = 0;
   // static
    static int level = 2;

    public static void recusion(TreeNode root,int k){
        if (root == null) return;
        System.out.println();
        if(root.getLeft()!=null){
            System.out.print(root.getLeft()+" ");
            if(level == k) sum++;
        }
        if(root.getRight()!=null){
            System.out.print(root.getRight()+" ");
            if(level == k) sum++;
        }
        k++;
        recusion(root.getLeft(),k);
        recusion(root.getRight(),k);

    }
}
