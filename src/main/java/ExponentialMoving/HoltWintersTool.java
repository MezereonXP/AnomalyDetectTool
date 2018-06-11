package ExponentialMoving;

import Result.Result;
import Tool.DetectTool;
import Tool.FileTool;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 使用二阶指数平滑以及SGD进行自动化参数调整
 *
 * @author mezereon E-mail:mezereonxp@gmail.com
 * @since 18-4-26
 */
public class HoltWintersTool implements DetectTool {

    private double alpha;//   指数平滑的初始参数
    private double step;//   步长
    private double lastAlpha;//   记录之前的alpha值
    private int trainingTimes;

    private double[] s1;//    指数平滑中的s1
    private double[] s2;//    指数平滑中的s2

    private double[] ds1;//   s1的对应偏导数
    private double[] ds2;//   s2的对应偏导数
    private ArrayList<Result> results;
    private double THREADHOLD = 0.2;

    /**
     * @param alpha
     * @param step
     * @param trainingTimes
     */
    HoltWintersTool(double alpha, double step, int trainingTimes) {
        this.alpha = alpha;
        this.step = step;
        this.trainingTimes = trainingTimes;
    }

    /**
     * 利用二阶指数平滑对时序数据进行异常检测
     */
    public void timeSeriesAnalyse(double[] data) {
        results = new ArrayList<Result>();
        initial(data.length);
        trainModel(data);
        testModel(data);
    }

    /**
     * 根据步长等参数来训练模型
     */
    private void trainModel(double[] data) {
        int count = 0;//    训练次数计数
        //training model
        while (count < trainingTimes) {
            count++;
            s1[0] = getInitialValue(data, 5);
            s2[0] = s1[0];
            double sum = 0;
            for (int i = 1; i < data.length; i++) {
                s1[i] = alpha * data[i - 1] + (1 - alpha) * s1[i - 1];
                s2[i] = alpha * s1[i] + (1 - alpha) * s2[i - 1];
                double A = 2 * s1[i] - s2[i];
                double B = (alpha / (1 - alpha)) * (s1[i] - s2[i]);
//                double predict = A + B * 1;
                double predict = s2[i];
                if (i == 1) {
                    ds1[i] = data[i - 1] - s1[i - 1];
                    ds2[i] = s1[i] + alpha * ds1[i] - s2[0];
                } else {
                    ds1[i] = data[i - 1] - ds1[i - 1];
                    ds2[i] = s1[i] + alpha * ds1[i] - s2[i - 1] + (1 - alpha) * ds2[i - 1];
                }
                sum += Math.pow(predict - data[i], 2);
                alpha -= step * ((predict - data[i]) * ds2[i]);
            }
            if (Math.abs(alpha - lastAlpha) < 1E-8) {
                break;
            }
            lastAlpha = alpha;
            System.out.println("MSE is " + sum / (data.length));
        }
    }

    /**
     * 初始化指数平滑的计算空间
     */
    private void initial(int length) {
        this.s1 = new double[length];
        this.s2 = new double[length];
        this.ds1 = new double[length];
        this.ds2 = new double[length];
    }

    /**
     * 利用已有模型进行测试
     */
    private void testModel(double[] data) {
        //testing model
        s1[0] = getInitialValue(data, 5);
        s2[0] = s1[0];
        double sum = 0;
        for (int i = 1; i < data.length; i++) {
            s1[i] = alpha * data[i - 1] + (1 - alpha) * s1[i - 1];
            s2[i] = alpha * s1[i] + (1 - alpha) * s2[i - 1];
            double A = 2 * s1[i] - s2[i];
            double B = (alpha / (1 - alpha)) * (s1[i] - s2[i]);
//                double predict = A + B * 1;
            double predict = s2[i];
            if (Math.abs(predict - data[i]) > THREADHOLD) {
                results.add(new Result(i, data[i]));
                System.out.println(data[i - 1] + "," + data[i] + "--------predict: " + predict);
            }
        }
    }

    public void main(String[] args) throws FileNotFoundException {
        double[] data = FileTool.getData("data.json");//    时间序列数据
    }

    /**
     * 获得初始值， 也就是数组前a个数的平均数
     */
    private static double getInitialValue(double[] data, int a) {

        if (data.length <= a) {
            System.out.println("Error: data length is not enough");
            return -1;
        }

        double sum = 0;
        for (int i = 0; i < a; i++) {
            sum += data[i];
        }
        return sum / a;
    }

    public double[] getS1() {
        return s1;
    }

    public void setS1(double[] s1) {
        this.s1 = s1;
    }

    public double[] getS2() {
        return s2;
    }

    public void setS2(double[] s2) {
        this.s2 = s2;
    }

    public double[] getDs1() {
        return ds1;
    }

    public void setDs1(double[] ds1) {
        this.ds1 = ds1;
    }

    public double[] getDs2() {
        return ds2;
    }

    public void setDs2(double[] ds2) {
        this.ds2 = ds2;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public double getTHREADHOLD() {
        return THREADHOLD;
    }

    public void setTHREADHOLD(double THREADHOLD) {
        this.THREADHOLD = THREADHOLD;
    }
}
