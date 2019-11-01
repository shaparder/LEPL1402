public class Tree {

	public Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public Tree combineWith(Tree o) {
		if (o == null || o.root == null)
			return this;
		if (this.root == null)
			return o;

		return new Tree(combine(this.root, o.root));
	}

	private Node combine(Node n1, Node n2) {
		Node left = null;
		Node right = null;

		if (n1.left != null && n2.left != null)
			left = combine(n1.left, n2.left);
		else if (n1.left != null && n2.left == null)
			left = combine(n1.left, n1.left);
		else if (n1.left == null && n2.left != null)
			left = combine(n2.left, n2.left);

		if (n1.right != null && n2.right != null)
			right = combine(n1.right, n2.right);
		else if (n1.right != null && n2.right == null)
			right = combine(n1.right, n1.right);
		else if (n1.right == null && n2.right != null)
			right = combine(n2.right, n2.right);

		if (n1 != n2) {
			return new Node(n1.val + n2.val, left, right);
		} else {
			return new Node(n1.val, left, right);
		}
	}
}