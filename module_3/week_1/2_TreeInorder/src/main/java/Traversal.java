import java.util.List;
import java.util.Stack; // this should give you a hint for the iterative version

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if (root == null)
            return;
        if (root.left != null)
            recursiveInorder(root.left, res);
        res.add(root.val);
        if (root.right != null)
            recursiveInorder(root.right, res);
    }


    public static void iterativeInorder(Node root, List<Integer> res){
        if (root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        Node node = root;

        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
    }

}
