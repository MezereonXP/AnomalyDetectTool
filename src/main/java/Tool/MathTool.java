package Tool;

/**
 * @program: AnomalyDetectTool
 * @description: The Tool to do some useful calculations
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-04-28 16:38
 **/
public class MathTool {

    private MathTool() {
    }

    public static double EulerConstant = 0.57721566490153286060651209;

    /**
     * 计算两个长度为n的序列的欧几里德距离并返回
     *
     * @param data 时间序列数据
     * @param p 序列1的开始位置
     * @param q 序列2的开始位置
     * @param length 序列的长度
     * @return
     */
    public static double dist(double[] data, int p, int q, int length) {
        double dist = 0;
        for (int i = 0; i < length; i++) {
            dist += Math.pow(data[p + i] - data[q + i], 2);
        }
        return Math.sqrt(dist);
    }

    /**
     * 正态化
     *
     * @param data
     * @return
     */
    public static double[] gassian(double[] data) {
        double[] temp = data.clone();
        double avg = getAverageFromArray(data);
        double s = getStdDeviation(data);
        for (int i = 0; i < data.length; i++) {
            temp[i] = (temp[i] - avg) / s;
        }
        return temp;
    }

    /**
     * 对传入的数组进行归一化
     */
    public static double[] normalize(double[] data) {
        double[] temp = data.clone();
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (double n : data) {
            if (max < n) {
                max = n;
            }
            if (min > n) {
                min = n;
            }
        }
        for (int i = 0; i < data.length; i++) {
            temp[i] = (temp[i] - min) / max;
        }
        return temp;
    }

    /**
     * 计算double数组的平均值
     */
    public static double getAverageFromArray(double[] array) {
        double sum = 0;
        for (double d : array) {
            sum += d;
        }
        return sum / array.length;
    }

    /**
     * 计算double数组的标准差
     */
    public static double getStdDeviation(double[] array) {
        double average = getAverageFromArray(array);
        double sum = 0;
        for (double d : array) {
            sum += Math.pow(d - average, 2);
        }
        return Math.sqrt(sum / (array.length - 1));
    }

    /**
     * 计算以二为底的对数
     */
    public static double log2(double value) {
        return Math.log(value) / Math.log(2);
    }
}
