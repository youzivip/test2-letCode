package dui;

import common.TreeNode;

import java.util.Arrays;

public class BigHeap {
    static int i = 10;
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1,1,4,5,62,2,34,23424,4,5,6,7,32,4,3,4,5,6,5,4,32,2,2};
        TreeNode r = new TreeNode(nums[0]);
        for (int i = 1;i<5;i++){
            bulidTree(nums[i],r);
        }
//        TreeNode.printTree(r);
        System.out.println("*******************88");
        for (int i = 5;i<nums.length;i++){
            compare(nums[i],r);
        }
        TreeNode.printTree(r);
        Arrays.sort(nums);
        System.out.println();
        System.out.println("*******************88");
        for (int i = 0;i<5;i++){
            System.out.print(nums[nums.length-1-i]+"  ");
        }
    }


    public static void bulidTree(int num,TreeNode root){
        if(root == null) new TreeNode<>(num);
        TreeNode l = root.getLeft();
        TreeNode r = root.getRight();
        if(l == null) {
            l = new TreeNode(num);
            root.setLeft(l);
        }else if(r == null){
            r = new TreeNode(num);
            root.setRight(r);
        }
        else if(isFull(l) && ! isFull(r)){
            bulidTree( num,r);
        }else {
            bulidTree( num,l);

        }


    }

    public static boolean isFull(TreeNode t){
        return t.getLeft() != null && t.getRight()!= null;
    }


    public static TreeNode<Integer> compare(int num,TreeNode<Integer> root){
        if(num>root.getValue()) root.setValue(num);
        modify(root);
        return root;
    }

    public static void modify(TreeNode<Integer> root){
        if(root.getRight() == null && root.getLeft() == null ) return;
        if(root.getLeft() != null && root.getValue()>root.getLeft().getValue()){
            int temp = root.getLeft().getValue();
            root.getLeft().setValue(root.getValue());
            root.setValue(temp);
            modify(root.getLeft());
        }
        if(root.getRight() != null && root.getValue()>root.getRight().getValue()){
            int temp = root.getRight().getValue();
            root.getRight().setValue(root.getValue());
            root.setValue(temp);
            modify(root.getRight());
        }
    }


//    public static TreeNode<Integer> findMin(int[] nums){
//        if(nums.length<= i) return null;
//
//    }

}
