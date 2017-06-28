package cn.ecomb.dataStructure.tree;

import cn.ecomb.dataStructure.tree.node.BinaryNode;

import java.util.Random;

/**
 * 二叉查找树
 *
 * Created by zhouzhigang on 2017/6/28.
 */
public class BinarySearchTree {
    // todo 构建二叉查找树，删除节点

    /**
     *  二叉查找树，插入节点
     * @param root
     * @param nodeValue
     * @return
     */
    public static BinaryNode inster(BinaryNode root, int nodeValue) {
        BinaryNode insterNode = new BinaryNode(nodeValue);
        if (root == null) {
            return insterNode;
        }
        if (nodeValue < (int) root.getContent()) {
            root.setLeftNode(inster(root.getLeftNode(), (int) insterNode.getContent()));
        } else {
            root.setRightNode(inster(root.getRightNode(), (int) insterNode.getContent()));
        }
        return root;
    }

    /**
     * 删除节点
     * @param root
     * @param delNodeValue
     * @return
     */
    public BinaryNode delete(BinaryNode root, int delNodeValue) {

        return root;
    }

    public static void main(String[] args) {
        BinaryNode root = null;
        for (int i=0; i<10; i++) {
            Random random = new Random();
            int nodeValue = random.nextInt(100);
            root = inster(root, nodeValue);
        }

        TreeStructure.inOrder(root);

    }



}
