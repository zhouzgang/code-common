package com.thoughtworks.interview.core.graph;

/**
 * 边节点
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class EdgeNode {

    /** 邻接点域，存储该顶点对应的下标 */
    private int adjvex;

    /** 用于存储权值 */
    private float weight;

    /** 指向下一个邻接点 */
    private EdgeNode next;


    public int getAdjvex() {
        return adjvex;
    }

    public EdgeNode setAdjvex(int adjvex) {
        this.adjvex = adjvex;
        return this;
    }

    public float getWeight() {
        return weight;
    }

    public EdgeNode setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public EdgeNode getNext() {
        return next;
    }

    public EdgeNode setNext(EdgeNode next) {
        this.next = next;
        return this;
    }
}
