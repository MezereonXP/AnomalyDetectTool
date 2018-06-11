package Result;

/**
 * @program: AnomalyDetectTool
 * @description: A class to store result
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-08 09:56
 **/
public class Result {
    private int index;
    private double value;

    public Result(int index, double value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Index is " + index + ",  value is " + value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
