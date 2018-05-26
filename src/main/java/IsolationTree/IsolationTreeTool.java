package IsolationTree;

import Result.Result;
import Tool.DetectTool;

import java.util.ArrayList;
import java.util.List;

public class IsolationTreeTool implements DetectTool {
    private ArrayList<Result> results;
    private int subSamplingNumber;
    private int treeNumber;
    private IsolationForest forest;
    @Override
    public void timeSeriesAnalyse(double[] data) {
        IsolationForest forest = new IsolationForest(100,256);
        forest.createForest(data.clone());
        this.forest = forest;
    }
    public void cutAnomaly(double[] data,float factor){
        for (int i = 0;i < data.length;i++){
            if (this.forest.searchForest(data[i]) > factor){
                this.results.add(new Result(i,data[i]));
            }
        }
    }
    @Override
    public List<Result> getResults() {
        return results;
    }
}
