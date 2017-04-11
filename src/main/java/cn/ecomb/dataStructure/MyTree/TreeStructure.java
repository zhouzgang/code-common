package cn.ecomb.dataStructure.MyTree;

import cn.ecomb.dataStructure.Tree;

import java.util.Stack;

/**
 * 练习树结构 && 二叉树
 * 1. 实现树结构的搜索和修改
 *
 * Created by zhouzg on 2017/3/17.
 */
public class TreeStructure {

    /**
     * 创造一个二叉树
     * @return
     */
    public static BinaryNode createBinaryTree(){

        BinaryNode j = new BinaryNode("d");
        BinaryNode i = new BinaryNode("c");
        BinaryNode h = new BinaryNode("-", i, j);
        BinaryNode g = new BinaryNode("b");
        BinaryNode f = new BinaryNode("f");
        BinaryNode e = new BinaryNode("e");
        BinaryNode d = new BinaryNode("*", g, h);
        BinaryNode c = new BinaryNode("a");
        BinaryNode a = new BinaryNode("+", c, d);
        BinaryNode b = new BinaryNode("/", e, f);
        BinaryNode root = new BinaryNode("-", a, b);

        return root;
    }

    /**
     * 递归前序
     * root -> left -> right
     * @param root
     */
    public static void preOrder(BinaryNode root) {
        if (root != null) {
            System.out.print(root.getContent());
            preOrder(root.getLeftNode());
            preOrder(root.getRightNode());
        }
    }

    /**
     * 不是用递归 前序
     * @param root
     */
    public static void nonRecursivePreOrder(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                BinaryNode node = stack.pop();
                System.out.print(node.getContent());
                if (node.getRightNode() != null)
                    stack.push(node.getRightNode());
                if (node.getLeftNode() != null)
                    stack.push(node.getLeftNode());
            }
        }
    }

    /**
     *递归中序
     * left -> root -> right
     * @param root
     */
    public static void inOrder(BinaryNode root) {
        if (root != null) {
            inOrder(root.getLeftNode());
            System.out.print(root.getContent());
            inOrder(root.getRightNode());
        }
    }


    /**
     * 不是用递归 中序
     * @param root
     */
    public static void nonRecursiveInOrder(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                BinaryNode node = stack.pop();
                if (node.getRightNode() != null)
                    stack.push(node.getRightNode());
                System.out.print(node.getContent());
                if (node.getLeftNode() != null)
                    stack.push(node.getLeftNode());
            }
        }
    }

    /**
     * 递归后序
     * @param root
     */
    public static void postOrder(BinaryNode root) {
        if (root != null) {
            postOrder(root.getLeftNode());
            postOrder(root.getRightNode());
            System.out.print(root.getContent());
        }
    }

    public static void main(String[] args) {
        BinaryNode root = TreeStructure.createBinaryTree();
        TreeStructure.preOrder(root);
        System.out.println();
        TreeStructure.inOrder(root);
        System.out.println();
        TreeStructure.postOrder(root);
    }

}
