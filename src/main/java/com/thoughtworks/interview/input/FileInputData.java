package com.thoughtworks.interview.input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 以文件形式读取图构建数据
 *
 * @author zhouzhigang
 * @date 2018/6/14.
 */
public class FileInputData implements InputData{

    /** 图构建数据默认分隔符 */
    private static final String DEFAULT_SEPARATOR = ",";

    /** 数据文件的默认路径 */
    private static final String DEFAULT_FILE_PATH = "/data.txt";

    /** 图构建数据 */
    private List<VertexData> datas = new ArrayList<>();

    /** 图节点 */
    private List<Object> nodes = new ArrayList<>();


    private void readData() {
        readData(DEFAULT_FILE_PATH);
    }

    /**
     * 从文件中读取数据
     */
    private void readData(String filePath) {
        if (filePath == null || "".equals(filePath)) {
            filePath = DEFAULT_FILE_PATH;
        }
        File file = new File(FileInputData.class.getResource(filePath).toString());
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt;
            while((lineTxt = bufferedReader.readLine()) != null) {
                String[] nodes = lineTxt.split(DEFAULT_SEPARATOR);
                for (int i = 0, length = nodes.length; i < length; i++) {
                    VertexData vd = new VertexData();
                    String node = nodes[i];
                    vd.setFrom(node.charAt(0))
                            .setTo(node.charAt(1))
                            .setWeight(Integer.parseInt(node.substring(2, node.length())));
                    datas.add(vd);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<VertexData> getData() {
        if (datas.size() == 0) {
            readData();
        }
        return datas;
    }

    @Override
    public List<Object> getNodes() {
        if (datas.size() == 0) {
            readData();
        }
        return nodes;
    }

    @Override
    public List<VertexData> getData(String filePath) {
        if (datas.size() == 0) {
            readData(filePath);
        }
        return datas;
    }

    @Override
    public List<Object> getNodes(String filePath) {
        if (datas.size() == 0) {
            readData(filePath);
        }
        return nodes;
    }

}











