public class Tree {

	public Node root;

	public Tree(Node root){
		this.root = root;
	}

	@Override
	public boolean equals(Object o){
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;
		Tree cmp = (Tree)o;
		if (this.root == null && cmp.root == null)
			return true;
		else if (this.root == null || cmp.root == null)
			return false;
		else
			return this.root.equals(cmp.root);
	}
}