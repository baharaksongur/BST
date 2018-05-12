import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Test {
//Class for testing BST.

	public static void main(String[] args) {

		createBSTs();
	}
	public static  void inorderTree(BinarySearchTreeNode node,ArrayList<String> lst){

		if (node.left !=null)
			inorderTree(node.left,lst);

		lst.add(node.data[0]+" "+node.data[1] +" "+node.data[2]+"\n");

		if (node.right !=null)
			inorderTree(node.right,lst);
	}
	public static  void preOrderTree(BinarySearchTreeNode node,ArrayList<String> lst){

		if (node!=null)
			lst.add(node.data[0]+" "+node.data[1] +" "+node.data[2]+"\n");

		if (node.left!=null)
			preOrderTree(node.left,lst);

		if (node.right !=null)
			preOrderTree(node.right,lst);


	}
	public static  void postOrderTree(BinarySearchTreeNode node,ArrayList<String> lst){

		if (node==null) return;


		if (node.left!=null)
			postOrderTree(node.left,lst);

		if (node.right !=null)
			postOrderTree(node.right,lst);

		lst.add(node.data[0]+" "+node.data[1] +" "+node.data[2]+"\n");


	}

	public static void createBSTs(){

		ArrayList<String[]> people= new ArrayList<String[]>();
		ArrayList<String> lst=new ArrayList<String>();

		BinarySearchTree namesTree=new BinarySearchTree();
		BinarySearchTree surnamesTree=new BinarySearchTree();
		BinarySearchTree phoneTree=new BinarySearchTree();

		BufferedReader reader = null;
		try {
			File file = new File("database.txt");
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {    	
				String[] person = line.split(" ");				        
				people.add(person);
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i=0; i<people.size(); i++){
			namesTree.put(people.get(i)[0],people.get(i));
		}
		for (int i=0; i<people.size(); i++){
			surnamesTree.put(people.get(i)[1],people.get(i));
		}
		for (int i=0; i<people.size(); i++){
			phoneTree.put(people.get(i)[2],people.get(i));
		}

		int a=namesTree.count(namesTree.getRoot());
		System.out.println(a);
		int b=namesTree.maxDepth(namesTree.getRoot());
		System.out.println(b);
		int c=namesTree.height(namesTree.getRoot(),"David",0);
		System.out.println(c);
		System.out.println(namesTree.getRoot().toString());

		System.out.println("------------------------------------------");

		ArrayList<String[]> query= new ArrayList<String[]>();
		ArrayList<String[]> info= new ArrayList<String[]>();

		reader=null;
		try {
			File file = new File("query.txt");
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {    	
				String[] command = line.split(" ");
				String[] information=new String[3];
				information[0]=command[1];
				information[1]=command[2];
				information[2]=command[3];

				info.add(information);
				query.add(command);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i=0; i<query.size(); i++){

			if (query.get(i)[0].equalsIgnoreCase("Delete")){//if the query starts with delete, remove that node from bst.

				System.out.println(info.get(i)[0]+" "+info.get(i)[1]+" "+info.get(i)[2]+" is deleted from BSTs.");
				namesTree.remove(query.get(i)[1]);
				surnamesTree.remove(query.get(i)[2]);
				phoneTree.remove(query.get(i)[3]);

			}else if (query.get(i)[0].equalsIgnoreCase("insert")){//if the query starts with insert, put that node into bst.

				System.out.println(info.get(i)[0]+" "+info.get(i)[1]+" "+info.get(i)[2]+" is inserted into BSTs.");
				namesTree.put(query.get(i)[1],info.get(i));
				surnamesTree.put(query.get(i)[2],info.get(i));
				phoneTree.put(query.get(i)[3],info.get(i));
			}
		}
		System.out.println();
		inorderTree(namesTree.getRoot(),lst);
		System.out.println("Inorder traversal of BST of names: ");
		for (int i=0; i<lst.size(); i++){
			System.out.println(lst.get(i));

		}
			
	}
}

