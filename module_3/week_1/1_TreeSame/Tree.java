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
		try {
		Tree cmp = (Tree)o;
		} catch (Exception e) {
			return false;
		}
		if (this.root == null && cmp.root == null)
			return true;
		else if (this.root == null || cmp_root)
			return false;
		else
			return this.root.equals(cmp.root);
	}

}