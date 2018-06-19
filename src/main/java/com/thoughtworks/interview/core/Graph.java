package com.thoughtworks.interview.core;

import com.thoughtworks.interview.core.graph.VertexNode;
import com.thoughtworks.interview.input.InputData;

/**
 * 图接口
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public interface Graph {

    /**
     * 创建图
     * @param inputData 图构建数据
     * @return
     */
    Graph createGraph(InputData inputData);

    /**
     * 获取两个顶点之间的距离
     *
     * @param nodes 路径经过的节点
     * @return
     */
    float distanceOfRoute(VertexNode... nodes);

    // DFSTraverse 深度优先遍历图

    // Dijkstra 迪杰斯特拉(Dijkstra)算法 最短路径问题


}
