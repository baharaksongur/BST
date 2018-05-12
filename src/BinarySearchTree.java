
public class BinarySearchTree {

	private BinarySearchTreeNode root;


	public BinarySearchTree(){
		root=null;

	}

	public boolean find(String key){

		BinarySearchTreeNode current=root;

		while (current!=null) {

			if (current.key.equals(key)) {
				return true;
			} else if (current.key.compareToIgnoreCase(key)<0) {
				current=current.left;
			} else {
				current=current.right;
			}
		}
		return false;

	}
	public BinarySearchTreeNode findMin(BinarySearchTreeNode node){//finding node with minimum key

		BinarySearchTreeNode current=node;
		while (current.getLeft()!=null) {

			current=current.getLeft();
		}
		return current;
	}
	public BinarySearchTreeNode predecessor(BinarySearchTreeNode node){//The largest value in the left subtree

		BinarySearchTreeNode predecessor=null;
		BinarySearchTreeNode parent=null; //parent of predecessor
		BinarySearchTreeNode leftPart=node.left;
		
		while (leftPart!=null) {

			parent=predecessor;
			predecessor=leftPart;
			leftPart=leftPart.right;
		}
		if (predecessor!=node.left) {

			parent.right=predecessor.left;
			predecessor.left=node.left;
		}
		return predecessor;
	}
	
	public boolean remove(String key){

		BinarySearchTreeNode parent=root;
		BinarySearchTreeNode current=root;

		boolean isLeftChild=false;
		
		while (!current.key.equalsIgnoreCase(key)){

			parent=current;
			if (current.key.compareToIgnoreCase(key)>0) {
				isLeftChild=true;
				current=current.left;
			}else{
				isLeftChild=false;
				current=current.right;
			}
			if(current==null){
				return false;
			}
		}
		
		if (current.getLeft()==null && current.getRight()==null){//Node to be deleted has no child

			if (current==root){
				root=null;
			}
			if (isLeftChild){ //Node to be deleted is left child of parent
				parent.left=null;
			}else{
				parent.right=null;
			}

		} 
		//if node to be deleted has only one child
		else if (current.getRight()==null) {//Node to be deleted has only left child

			if (current==root){
				root=current.left;
			}else if (isLeftChild){
				parent.left=current.left;
			}else{
				parent.right=current.left;
			}
		}else if (current.getLeft()==null){//Node to be deleted has only right child

			if (current==root){
				root=current.right;
			}else if (isLeftChild){
				parent.left=current.right;
			}else{
				parent.right=current.right;
			}
		}else if (current.getLeft()!=null && current.getRight()!=null){//node to be deleted has both right and left child

			BinarySearchTreeNode predecessor=predecessor(current);//predecessor is the largest value in the left subtree

			if (current==root){//current is the node to be deleted at the moment
				root=predecessor;
			}else if (isLeftChild){
				parent.left=predecessor;
			}else{
				parent.right=predecessor;
			}
			predecessor.right=current.right; //always like that.
		}
		return true;
	}
	
	public void put(String key,String[] data){

		BinarySearchTreeNode newNode= new BinarySearchTreeNode(key,data);
		if (root==null){
			root=newNode;
			return;
		}
		BinarySearchTreeNode current=root;
		BinarySearchTreeNode parent=null;
		while (true){
			parent=current;
			if (current.key.compareToIgnoreCase(key)>0){
				current=current.left;
				if (current==null){
					parent.left=newNode;
					return;
				}
			}else{
				current=current.right;
				if (current==null){
					parent.right=newNode;
					return;
				}
			}
		
		}
		
	}
	

	public BinarySearchTreeNode getRoot() {

		return root;
	}
	public void setRoot(BinarySearchTreeNode root) {

		this.root = root;
	}
	public int count(BinarySearchTreeNode node){

		if (node==null){ return 0;}
		else{ return 1+ count(node.left) +count(node.right);}
	}
	public int maxDepth(BinarySearchTreeNode node){//max depth is the height of the tree

		if(node==null){ return 0;}

		else{
			int leftMax=maxDepth(node.left);
			int rightMax=maxDepth(node.right);
			
			if(leftMax>rightMax) return (leftMax+1);
			else return (rightMax +1);
		}
	}
	public  int height(BinarySearchTreeNode root,String key,int height){

		if (root!=null){

			if (root.key.equalsIgnoreCase(key)){
				return height;
			}else if (root.key.compareToIgnoreCase(key)>0){
				height++;
				return height(root.left,key,height);
			}else{
				height++;
				return height(root.right,key,height);
			}
		}
		return height;
	}
	
	}



