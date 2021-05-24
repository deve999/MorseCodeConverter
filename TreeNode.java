package Project5;

public class TreeNode<T> {
	private TreeNode<T> rightChild;
	private TreeNode<T> leftChild;
	private T data;
	
	public TreeNode(T dataNode) {
		data = dataNode;
		rightChild = null;
		leftChild = null;
	}
	
	public TreeNode(TreeNode<T> node){
		this.rightChild = node.rightChild;
		this.rightChild = node.leftChild;
		this.data = node.data;
	}
	
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public boolean isLeaf() {
		return (leftChild == null) && (rightChild == null);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
