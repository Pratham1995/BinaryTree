import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private  TreeNode root;
	
	public static class TreeNode{
		private TreeNode right;
		private TreeNode left;
		private int Data;
		
		TreeNode(int Data){
			this.Data=Data;
		}
	}
	
	public boolean isEmpty() {
		if(root==null)
			return true;
		else
			return false;
	}
	
	public void CreateBinaryTree() {
		TreeNode first =new TreeNode(9);
		TreeNode second =new TreeNode(2);
		TreeNode third =new TreeNode(5);
		TreeNode fourth =new TreeNode(6);
		TreeNode fifth =new TreeNode(7);
		
		root=first;
		first.left=second;
		first.right=third;
		second.left=fourth;
		second.right=fifth;
		
		
	}
	
	/*public void Display() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		TreeNode current =root;
		TreeNode temp=root;
		System.out.println(root.Data);
		while(current!=null) {
			current=current.left;
			
			System.out.println(current.Data);
		}
		while(temp!=null) {
			temp=temp.right;
			System.out.println(temp.Data);
		}
		System.out.print("null");
		
	}*/
	
	public void preorder(TreeNode root) {
		if(root==null) {
			return;
			}
		System.out.print(root.Data+" ");
		preorder(root.left);
		preorder(root.right);
		
	}
	
	public void preOrderIterative(TreeNode root) {
		if(root==null) {
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp=stack.pop();
			System.out.print(temp.Data+" ");
			if(temp.right!=null) {
				stack.push(temp.right);
			}
			if(temp.left!=null) {
				stack.push(temp.left);
			}
			
			
		}
	}
	
	public void InOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		InOrder(root.left);
		System.out.print(root.Data+" ");
		InOrder(root.right);
	}
	
	public void InOrderIterative(TreeNode root) {
		if(root==null) {
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
		TreeNode temp=root;
		while(!stack.isEmpty()||temp!=null) {
			if(temp!=null) {
				stack.push(temp);
				temp=temp.left;
			}else {
				temp=stack.pop();
				System.out.print(temp.Data+" ");
				temp=temp.right;
			}
				
		}
	}
	
	public void PostOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.Data+" ");
	}
	
	public void levelOrder() {
		if(root==null) {
			return;
		}
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp=queue.poll();
			System.out.print(temp.Data+" ");
			if(temp.left!=null) {
				queue.offer(temp.left);
			}
			if(temp.right!=null) {
				queue.offer(temp.right);
			}
		}
	}
	
	public static void main(String args[]) {
		BinaryTree bt= new BinaryTree();
		bt.CreateBinaryTree();
		bt.preorder(bt.root);
		System.out.println("     ");
		bt.preOrderIterative(bt.root);
		
		//System.out.println("\nThe InOrder List is \n");
		//bt.InOrder(bt.root);
		System.out.println("\nThe InOrder Iterative List is \n");
		bt.InOrderIterative(bt.root);
		System.out.println("\nThe PostOrder List is:\n");
		bt.PostOrder(bt.root);
		System.out.println(" ");
		bt.levelOrder();
		
		
	}

}
