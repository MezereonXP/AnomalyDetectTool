package com.anomalydetect.IsolationTree;

import com.anomalydetect.Tool.MathTool;

import java.util.ArrayList;
import java.util.Random;

public class IsolationForest {
    private ArrayList<IsolationTree> forest;//存放的每一棵树的集合
    private int maxTreeNum;//森林中最多容纳树的数量
    private int maxTreeHeight;//每一棵树最大的高度
    private int subSamplingNum;//随机抽样数目
    private int dataLengeth;//数据长度

    public IsolationForest(int maxTreeNum, int maxSampling) {
        this.subSamplingNum = maxSampling;
        this.maxTreeNum = maxTreeNum;
        this.maxTreeHeight = (int) Math.ceil(MathTool.log2(maxSampling));
        this.forest = new ArrayList<>(maxTreeNum);
    }

    /**
     * 创建用所给的数据创建孤立森林
     *
     * @param data
     */
    public void createForest(double[] data) {
        this.dataLengeth = data.length;
        boolean isSample = false;
        if (data.length > this.subSamplingNum) {
            isSample = true;
        }
        for (int i = 0; i < maxTreeNum; i++) {
            IsolationTree iTree = new IsolationTree();
            if (isSample) {
                data = subSampling(data);
            }
            iTree.create(data, this.maxTreeHeight);
            forest.add(iTree);
        }
    }

    /**
     * 从森林中查找数值d 的深度, 返回一个异常分数
     *
     * @param d
     * @return
     */
    public double searchForest(double d) {
        double hx = 0;
        for (IsolationTree tree : this.forest) {
            hx += tree.pathLength(d);
        }
        double cn = 2 * (Math.log(this.dataLengeth - 1.0) + MathTool.EulerConstant) - 2 * (this.dataLengeth - 1) / this.dataLengeth;
        return Math.pow(2, -hx / this.maxTreeNum / cn);
    }

    /**
     * 对数据进行随机抽样
     *
     * @param data
     * @return
     */
    private double[] subSampling(double[] data) {
        int n = data.length;
        double[] sample = new double[this.subSamplingNum];
        for (int i = 0; i < this.subSamplingNum; i++) {
            int r = new Random().nextInt(n);
            sample[i] = data[r];
            data[r] = data[--n];
        }
        return sample;
    }
}
