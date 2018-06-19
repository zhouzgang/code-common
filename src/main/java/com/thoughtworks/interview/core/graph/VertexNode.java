package com.thoughtworks.interview.core.graph;

/**
 * 顶点表节点
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class VertexNode {

    /** 顶点域，存储顶点信息 */
    private Object data;

    /** 边表头指针 */
    private EdgeNode firstEdge;

    public Object getData() {
        return data;
    }

    public VertexNode setData(Object data) {
        this.data = data;
        return this;
    }

    public EdgeNode getFirstEdge() {
        return firstEdge;
    }

    public VertexNode setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
        return this;
    }
}
