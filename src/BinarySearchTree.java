
public class BinarySearchTree {
	
	private static TreeNode root;
	
	public class TreeNode{
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		TreeNode(int data){
			this.data=data;
		}
	}
	
	public void InOrder() {
		InOrder(root);
	}
	public void InOrder(TreeNode root) {
		if(root==null) {
			return;
		}
		InOrder(root.left);
		System.out.print(root.data+" ");
		InOrder(root.right);
	}
	public void Insert(int value) {
		root=Insert(root,value);
	}
	
	public TreeNode Insert(TreeNode root, int value) {
		if(root==null) {
			root= new TreeNode(value);
			return root;
		}
		if(value < root.data) {
			root.left=Insert(root.left,value);
		}else {
			root.right=Insert(root.right,value);
		}
		return root;
	}
	
	public TreeNode search(int key) {
		return search(root,key);
	}
	public TreeNode search(TreeNode root,int key) {
		if(root==null||root.data==key) {
			return root;
		}
		if(key<root.data) {
			return search(root.left,key);
		}else {
			return search(root.right,key);
		}
		
	}

	public static void main(String args[]) {
		BinarySearchTree BST=new BinarySearchTree();
		BST.Insert(5);
		BST.Insert(10);
		BST.Insert(2);
		BST.Insert(8);
		BST.Insert(15);
		BST.Insert(1);
		BST.Insert(3);
		
		
		BST.InOrder();
		
		
		if(null!=BST.search(0)) {
			System.out.println("\nKEyFound!!!!!");
		}else {
			System.out.println("\nNOT FOUND");
		}
		
	}
}
