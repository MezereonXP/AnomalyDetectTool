package IsolationTree;

import Tool.MathTool;

import java.util.ArrayList;
import java.util.Iterator;

public class IsolationForest {
    private ArrayList<IsolationTree> forest;
    private int maxTreeNum;
    private int maxTreeeHeight;
    private int subSamplingNum;
    private int dataLengeth;
    public IsolationForest(int maxTreeNum,int maxSampling){
        this.subSamplingNum = maxSampling;
        this.maxTreeNum = maxTreeNum;
        this.maxTreeeHeight = (int) Math.ceil(MathTool.log2(maxSampling));
        this.forest = new ArrayList<IsolationTree>(maxTreeNum);
    }
    public void createForest(double[] data){
        this.dataLengeth = data.length;
        boolean isSample = true;
        if (data.length > this.subSamplingNum){
            isSample = false;
        }
        for (int i = 0;i < maxTreeNum;i++){
            IsolationTree iTree = new IsolationTree();
            if (isSample) data = subSampling(data);
            iTree.create(data,this.maxTreeeHeight);
            forest.add(iTree);
        }
    }
    public double searchForest(double d){
        double hx = 0;
        for (IsolationTree tree : this.forest) {
            hx += tree.pathLength(d);
        }
        double s = (double)this.maxTreeNum;
        double cn = 2 * (Math.log(this.dataLengeth - 1)+ MathTool.EulerConstant) - 2 * (this.dataLengeth - 1) / this.dataLengeth;
        double score = Math.pow(2,-hx/this.maxTreeNum/cn);
        return score;
    }
    private double[] subSampling(double[] data) {
        int n = data.length;
        double[] sample = new double[this.subSamplingNum];
        for (int i = 0;i < this.subSamplingNum;i++){
            int r = (int) (Math.random() * n);
            sample[i] = data[r];
            data[r] = data[--n];
        }
        return sample;
    }
}
