package Project5;
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	ArrayList<String> inOrder = new ArrayList<String>();
	private LinkedConverterTreeInterface<String> newTree;
	
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	public TreeNode<String> getRoot(){
		return root; 
	}
	
	public void setRoot(TreeNode<String> newNode){
		root = newNode;
	}
	
	public LinkedConverterTreeInterface<String> insert(String code, String result){
		addNode(root, code, result);
		return newTree;
	}
	
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.equals(".")) {
				root.setLeftChild(new TreeNode<String>(letter));
			}
			else if(code.equals("-")) {
				root.setRightChild(new TreeNode<String>(letter));
			}
		}
		else if(code.length() > 1) {
			if(code.charAt(0) == '.') {
				root = root.getLeftChild();
			}
			else if(code.charAt(0) == '-') {
				root = root.getRightChild();
			}
			
			code = code.substring(1, code.length());
			addNode(root, code, letter);
		}
	}
	
	public void buildTree() {
		// level 1
		insert(".", "e");
		insert("-", "t");
		
		// level 2
		insert("..", "i"); 
		insert(".-", "a"); 
		insert("-.", "n"); 
		insert("--", "m");
		
		// level 3
		insert("...", "s"); 
		insert("..-", "u"); 
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		// level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	public String fetch(String code) {
		String letter = fetchNode(root, code);
		return letter;
	}

	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1) {
			if(code.equals(".")) {
				return root.getLeftChild().getData();
			}
			else if(code.equals("-")) {
				return root.getRightChild().getData();
			}
		}
		else if(code.length() > 1) {
			if(code.charAt(0) == '.') {
				root = root.getLeftChild();
			}
			else if(code.charAt(0) ==  '-') {
				root = root.getRightChild();
			}
			code = code.substring(1, code.length());
			return fetchNode(root, code);
		}
		return "";
	}


	public ArrayList<String> toArrayList() {
		LNRoutputTraversal(root, inOrder);
		return inOrder;
	}
	
	@Override
	public String toString() {
		String display = "";
		
		toArrayList();
		
		for(String a : inOrder) {
			display += a + " ";
		}
		
		return display;
	}
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			LNRoutputTraversal(root.getLeftChild(), list);
			list.add(root.getData());
			LNRoutputTraversal(root.getRightChild(), list);
		}
	}

}
 
