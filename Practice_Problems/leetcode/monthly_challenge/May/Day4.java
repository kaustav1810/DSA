// Link: https://leetcode.com/problems/deepest-leaves-sum/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int sum = 0,maxLevel = Integer.MIN_VALUE;
    
    public int deepestLeavesSum(TreeNode root) {
        
        
        maxDepth(root,0);
        
        getSum(root,0);
        
        return sum;
    }
    
    public void maxDepth(TreeNode root,int level){
        if(root==null) return;
        
        if(root.left==null && root.right==null)
            maxLevel = Math.max(maxLevel,level);
        
        maxDepth(root.left,level+1);
        maxDepth(root.right,level+1);
        
    }
    
    public void getSum(TreeNode root,int level){
        
        if(root==null) return;
        
        if(level==maxLevel) sum += root.val;
        
        getSum(root.right,level+1);
        getSum(root.left,level+1);
    }
}
