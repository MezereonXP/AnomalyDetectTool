package IsolationTree;

import Tool.FileTool;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        double[] series = FileTool.getData("data.json");
        new IsolationTreeTool().timeSeriesAnalyse(series);
    }
}
