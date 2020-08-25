import java.util.*;

public class Solution {
    /**
     * Definition for a binary tree node.
     *   */
       class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> outList = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            int count = 0;
             queue.add(root);
            // count++;
            while (!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                Queue<TreeNode> queue1 = new LinkedList<>();
                while (!queue.isEmpty()){
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                    //   count--;
                }
                queue = queue1;
                outList.add(list);
            }
            return outList;

        }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outList = new LinkedList<>();
        if(root == null) return outList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            List list = new ArrayList();
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) list.add(node.left);
                if(node.right != null) list.add(node.right);
            }
            queue = temp;
            ((LinkedList<List<Integer>>) outList).addFirst(list);
        }
        return outList;



    }

}
