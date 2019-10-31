public class Node {

	public int val;
	public Node left;
	public Node right;

	public Node(int val) {
		this.val = val;
	}

	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;
		try {
			Node cmp = (Node) o;
			
		} catch (Exception e) {
			return false;
		}
		if (this.isLeaf() && cmp.isLeaf())
			return this.val == cmp.val;
		else if (this.isLeaf() || cmp.isLeaf())
			return false;
		else
			return this.val == cmp.val &&
					this.left.equals(cmp.left) &&
					this.right.equals(cmp.right);
	}
}