package tree;

import java.util.*;

public class Treetraversal {
	

	public static void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}
	
	public static void preorder(TreeNode root) {
		if(root != null) {
			System.out.println(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void postorder(TreeNode root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.val);
		}
	}
	
	public static TreeNode search_BST(TreeNode root, int data) {
		
		if(root == null || root.val == data) {
			return root;
		}
		else if(root.val<data) {
				return search_BST(root.right,data);
		}
		else
				return search_BST(root.left,data);
	}
	
	public void insert_BST(int data) {
		TreeNode root = insert_BST_util(root,data);
	}
	public static TreeNode insert_BST_util(TreeNode root, int data) {
		if(root == null) {
			TreeNode node = new TreeNode(data);
			root = node;
			return root;
		}
		else if(root.val<data) 
			root.right = insert_BST_util(root.right, data);
		else
			root.left = insert_BST_util(root.left, data);
				
		return root;
	}
		
	public static boolean Issame(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		
		else if(root1 != null || root2 != null) {
			return false;
		}
		else {
			return Issame(root1.left, root2.left) && Issame(root1.right, root2.right) && root1.val == root2.val;
		}
	}
	
	public static int sizeBST(TreeNode root) {
		if(root == null) {
			return 0;
		}
		else {
			return sizeBST(root.left)+sizeBST(root.right)+1;
		}			
	}
	
	public static int heightBST(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left_height = heightBST(root.left);
		int right_height = heightBST(root.right);
		 
		return Math.max(left_height, right_height)+1;
		
	}
	
	public static boolean rootSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		if(root.left == null && root.right == null) {
			if(root.val == sum) {
				return true;
			}
			else {
				return false;
			}
		}
		if(rootSum(root.left, sum-root.val)|| rootSum(root.right, sum-root.val)) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean isBst(TreeNode root) {
		return isBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static boolean isBst(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.val <= min || root.val > max) {
			return false;
		}
		return (isBst(root.left,min,root.val) && isBst(root.right,root.val,max));
	}
	
	public static void levelOrderTraversal(TreeNode root) {
		if(root == null) {
			System.out.println("Empty tree");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.println(temp);
			if(temp.left != null) {
				queue.offer(temp.left);
			if(temp.right != null) {
				queue.offer(temp.right);
			}
			}
		}
	}
	
	public static void printLevelOrderTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp != null) {
				System.out.print(temp.val);
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				if(temp.right != null) {
					queue.offer(temp.right);
				}
			}
			else {
				if(!queue.isEmpty()) {
					System.out.println();
					queue.offer(null);
				}
			}
			
		}
		
	}
	
	public static void reverseLevelOrder(TreeNode root) {
		if(root == null) {
			System.out.println("Empty tree");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			stack.push(temp);
			System.out.println(temp);
			if(temp.right != null) {
				queue.offer(temp.right);
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			}
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().val);
		}
	}
	
	public static void zigzagTraversal(TreeNode root) {
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode temp;
		queue.offer(null);
		queue.offerFirst(root);
		while(queue.size()>1) {
			temp = queue.peekFirst();
			while(temp != null) {
				temp = queue.pollFirst();
				System.out.print(temp.val);
				if(temp.right != null) {
					queue.offer(temp.right);
				}
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				temp = queue.peekFirst();
			}
			temp = queue.peekLast();
			while(temp != null) {
				System.out.print(temp.val);
				temp = queue.pollLast();
				if(temp.left != null) {
					queue.offer(temp.left);
				}
				if(temp.right != null) {
					queue.offer(temp.right);
				}
				temp = queue.peekLast();
			}
		}
	}
	
	public static TreeNode LCA_BST(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null) {
			return root;
		}
		if(root.val < Math.min(node1.val, node1.val)){
			return LCA_BST(root.right, node1, node2);
		}
		else if(root.val > Math.max(node1.val, node1.val)) {
			return LCA_BST(root.left, node1, node2);
		}
		return root;
	}
	
	public static TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null) {
			return null;
		}
		if(root.val == node1.val || root.val == node2.val) {
			return root;
		}
		TreeNode left = LCA(root.left, node1, node2);
		TreeNode right = LCA(root.right, node1, node2);
		 if(left != null || right != null) {
			 return root;
		 }
		 return left!=null?left:right;
		
	}
	
	public static int largestBST(TreeNode root) {
		MinMax m = largest(root);
		return m.size;
	}
	
	public static MinMax largest(TreeNode root) {
		if(root == null) {
			return new MinMax();
		}
		MinMax left = largest(root.left);
		MinMax right = largest(root.right);
		MinMax m = new MinMax();
		
		if(left.IsBST == false || right.IsBST ==false || left.max>root.val || right.min<=root.val) {
			m.IsBST = false;
			m.size = Math.max(left.size, right.size);
			return m;
		}
		
		m.IsBST = true;
		m.size = left.size+right.size+1;
		//if root.left is null then set root.data as min else
        //take min of left side as min
        m.min = root.left != null ? left.min : root.val;
  
        //if root.right is null then set root.data as max else
        //take max of right side as max.
        m.max = root.right != null ? right.max : root.val;
   
        return m;
		
	}
	
	
	
	
	
	
}
