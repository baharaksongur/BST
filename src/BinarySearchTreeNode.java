

public class BinarySearchTreeNode {
	
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	String key;
	String[] data;
	
	public BinarySearchTreeNode() {//constructor taking no argument

		data=new String[3];
		left=null;//initially right and left trees are null;has no value
		right=null;
		key="";

	}

	public BinarySearchTreeNode(String k,String[] values) {//constructor

		left=null;//initially right and left trees are null;has no value
		right=null;
		data =values;
		key=k;

	}
	public BinarySearchTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}
	public BinarySearchTreeNode getRight() {
		return right;
	}
	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
	public String toString(){
		return "Key is: "+ key + " Data contained is : "+ data[0] +" "+data[1]+" "+data[2]; 
	}
	

}
