package arbre;

class Node<T extends Comparable<?>> implements Cloneable {
    private Node<T> left, right;
    private T value;

    public Node(T value) {
        this.value = value;
    }
    
    public Node<T> clone() {
    	Node<T> clonedNode = new Node<T>(this.getValue());
    	clonedNode.setLeft(this.getLeft());
    	clonedNode.setRight(this.getRight());
    	return clonedNode;
    }
    
    public Integer size() {
		if (isEmpty())
			return 0;
		Integer leftSize = (this.getLeft() != null) ? this.getLeft().size() : 0;
		Integer rightSize = (this.getRight() != null) ? this.getRight().size() : 0;
		return 1 + leftSize + rightSize;
	}

    public Integer height() {
		if (isEmpty())
			return -1;
		if (this.getLeft() == null && this.getRight() == null)
			return 0;
		Integer leftHeight = (this.getLeft() != null) ? this.getLeft().height() : 0;
		Integer rightHeight = (this.getRight() != null) ? this.getRight().height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public void prefix() {
		if (isEmpty())
			return;
		System.out.println(this.getValue());
		
		if (this.getRight() != null)
			this.getRight().prefix();
		
		if (this.getLeft() != null)
			this.getLeft().prefix();
	}

	public boolean isBalanced() {
		if (isEmpty())
			return true;
		Integer leftHeight = (this.getLeft() != null) ? this.getLeft().height() : -1;
		Integer rightHeight = (this.getRight() != null) ? this.getRight().height() : -1; 
		Integer leftHeightMinusRightHeight = leftHeight - rightHeight;
		boolean isLeftBalanced = (this.getLeft() != null) ? this.getLeft().isBalanced() : true;
		boolean isRightBalanced = (this.getRight() != null) ? this.getRight().isBalanced() : true;
		return Math.abs(leftHeightMinusRightHeight) <= 1 && isLeftBalanced && isRightBalanced;
	}

	public boolean isEmpty() {
		return this.getValue() == null;
	}

	public Node<T> leftRotation() {
		if (isEmpty() || this.getRight() == null) 
			return null;
		Node<T> newNodes = this.clone().getRight();
		this.setRight(newNodes.getLeft());
		newNodes.setLeft(this);
		return newNodes;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}