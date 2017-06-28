package cn.ecomb.dataStructure.tree.node;

/**
 * 二叉树结构的节点
 *
 * Created by zhouzg on 2017/3/17.
 */
public class BinaryNode {
    /** 节点上的数据 */
    private Object content;

    /** 左节点 */
    private BinaryNode leftNode;

    /** 左节点 */
    private BinaryNode rightNode;

    public BinaryNode() {
    }

    public BinaryNode(Object content) {
        this.content = content;
    }

    public BinaryNode(Object content, BinaryNode leftNode, BinaryNode rightNode) {
        this.content = content;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }
}
