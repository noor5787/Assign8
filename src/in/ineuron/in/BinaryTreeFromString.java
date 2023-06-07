package in.ineuron.in;
import java.util.Stack;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeFromString {
    public static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c) || c == '-') {
                num.append(c);
            } else if (c == '(') {
                if (num.length() > 0) {
                    TreeNode node = new TreeNode(Integer.parseInt(num.toString()));
                    stack.push(node);
                    num.setLength(0);
                }
            } else if (c == ')') {
                if (num.length() > 0) {
                    TreeNode node = new TreeNode(Integer.parseInt(num.toString()));
                    num.setLength(0);

                    if (!stack.isEmpty()) {
                        TreeNode parent = stack.peek();

                        if (parent.left == null) {
                            parent.left = node;
                        } else {
                            parent.right = node;
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        if (num.length() > 0) {
            return new TreeNode(Integer.parseInt(num.toString()));
        }

        return stack.isEmpty() ? null : stack.peek();
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = str2tree(s);
        inOrderTraversal(root);
    }
}
