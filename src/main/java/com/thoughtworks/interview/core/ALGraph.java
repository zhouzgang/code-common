package com.thoughtworks.interview.core;

import com.thoughtworks.interview.core.graph.EdgeNode;
import com.thoughtworks.interview.core.graph.VertexNode;
import com.thoughtworks.interview.input.InputData;
import com.thoughtworks.interview.input.VertexData;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接表结构构建图
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class ALGraph implements Graph {

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 100;

    /**
     * 邻接表顶点数组
     * 非线程安全
     */
    private List<VertexNode> list = new ArrayList<>();

    /**
     * 图中当前顶点数
     */
    private int numVertexes;

    /**
     * 图中当前边数
     */
    private int numEdges;



    @Override
    public Graph createGraph(InputData inputData) {
        List<VertexData> vertexDatas = inputData.getData();
        List<Object> nodes = inputData.getNodes();
        numEdges = vertexDatas.size();
        numVertexes = nodes.size();

        initVertexNode(nodes);

        for (VertexData item : vertexDatas) {
            VertexData vd = getPosition(item);
            EdgeNode edgeNode = new EdgeNode();
            edgeNode.setAdjvex(vd.getToIndex())
                    .setWeight(item.getWeight());

            EdgeNode fEdge = list.get(vd.getFromIndex()).getFirstEdge();
            if (fEdge != null) {
                edgeNode.setNext(fEdge);
            }
            list.get(vd.getFromIndex()).setFirstEdge(edgeNode);
        }

        return this;
    }

    private VertexData getPosition(VertexData vd) {
        int count = 0, full = 2;
        for (int j = 0, length = list.size(); j < length; j++) {
            if (list.get(j) == vd.getFrom()) {
                vd.setFromIndex(j);
                count++;
            }

            if (list.get(j) == vd.getTo()) {
                vd.setToIndex(j);
                count++;
            }
            if (count == full) {
                return vd;
            }
        }
        return null;
    }

    private void initVertexNode(List<Object> nodes) {
        for (Object obj : nodes) {
            VertexNode vertexNode = new VertexNode();
            vertexNode.setData(obj);
            list.add(vertexNode);
        }
    }

    @Override
    public float distanceOfRoute(VertexNode... nodes) {
        return 0;
    }


    public static void main(String[] args) {
        Object o1 = "a";
        Object o2 = "a";
        String o3 = "a";
        System.out.println(o1 == (Object) 'a');
        System.out.println(o1 == o2);
        System.out.println(o1.equals(o2));
        System.out.println(o1.equals(o3));
        System.out.println(o1 == o3);
    }


}













