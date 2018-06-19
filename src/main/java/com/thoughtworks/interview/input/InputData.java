package com.thoughtworks.interview.input;

import java.util.List;

/**
 * 图构建数据的输入接口
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public interface InputData {



    /**
     * 获取输入数据
     * @return 返回图构建数据
     */
    List<VertexData> getData();

    /**
     * 带数据文件路径，获取输入数据
     * @param filePath 数据文件路径
     * @return
     */
    List<VertexData> getData(String filePath);

    /**
     * 获取所有唯一节点
     *
     * @return
     */
    List<Object> getNodes();


    /**
     * 带数据文件路径， 获取所有唯一节点
     * @param filePath 数据文件路径
     * @return
     */
    List<Object> getNodes(String filePath);
}
