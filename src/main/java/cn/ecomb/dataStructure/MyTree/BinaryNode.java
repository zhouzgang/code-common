package cn.ecomb.dataStructure.MyTree;

/**
 * 二叉树结构的节点
 *
 * Created by zhouzg on 2017/3/17.
 */
public class BinaryNode {
    /** 节点上的数据 */
    private String content;

    /** 左节点 */
    private BinaryNode leftNode;

    /** 左节点 */
    private BinaryNode rightNode;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
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
