package IsolationTree;

import Tool.MathTool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsolationTree {
    private IsolationTreeNode root;
    public void create(double[] data,int max_height){
        Arrays.sort(data);
        root = createByR(data,0,max_height,0,data.length-1);
    }
    private IsolationTreeNode createByR(double[] data,int currentHeight,int maxHeight,int start,int end){
        if (start > end)return null;
        if (currentHeight == maxHeight || end == start){
            IsolationTreeNode node = new IsolationTreeNode(0.0);
            node.size = end-start+1;
            return node;
        }
        double min = data[start];
        double max = data[end];
        double divd = 0.0;
        do {
            divd =  min + Math.random() * max;
        }while (divd <= min || divd >= max);
        int i;
        for (i= start;i <= end;i++){
            if (data[i] > divd)break;
        }
        IsolationTreeNode node = new IsolationTreeNode(divd);
        node.left = createByR(data,currentHeight+1,maxHeight,start,i-1);
        node.right = createByR(data,currentHeight+1,maxHeight,i,end);
        return node;
    }
    public double pathLength(double x){
        return pathLengthM(x,root,1);
    }
    private double pathLengthM(double x,IsolationTreeNode node,int currHeight){
        if (node.left == null || node.right == null){
            return currHeight + e(node.size);
        }
        if (x > node.divdNum) return pathLengthM(x,node.right,currHeight+1);
        else return pathLengthM(x,node.left,currHeight+1);
    }
    private double e(int n){
        double s = (double)n;
        return 2 * (Math.log(s)+ MathTool.EulerConstant) + 2 * (s - 1) / s;
    }
}
