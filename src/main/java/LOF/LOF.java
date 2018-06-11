package LOF;

import java.util.ArrayList;

/**
 * Local Outlier Factor
 *
 * @author mezereon E-mail:mezereonxp@gmail.com
 * @since 18-4-12
 */
public class LOF {

    private int k;

    public LOF(int k) {
        this.k = k;
    }

    /**
     * 返回异常程度的分数， 越接近1则越异常
     *
     * @param knn 输入一个时序数据生成的旋转矩阵
     * @param x 输入测试的序列
     */
    public double getLOF(double[][] knn, double[] x) {
        double sum = 0;
        for (double[] o : knn) {
            sum += getLocDens(knn, o) / getLocDens(knn, x);
        }
        return sum / k;
    }

    /**
     * 获取local density
     *
     * @param knn 输入一个时序数据生成的旋转矩阵
     * @param x 输入测试的序列
     */
    public double getLocDens(double[][] knn, double[] x) {
        double[] nnk = findKthPoint(knn, x);

        double sum = 0;
        for (double[] o : knn) {
            sum += reachDist(o, x, nnk);
        }
        return sum / k;
    }

    /**
     * 找到第k个相似的序列
     *
     * @param knn 输入一个时序数据生成的旋转矩阵
     * @param x 输入测试的序列
     */
    public double[] findKthPoint(double[][] knn, double[] x) {

        ArrayList list = new ArrayList();
        for (int i = 0; i < knn.length; i++) {
            list.add(knn[i]);
        }
        int index = 0;
        double minDist = dist(knn[0], x);

        for (int i = 0; i < k; i++) {
            index = 0;
            minDist = dist((double[]) list.get(0), x);
            for (int j = 0; j < list.size(); j++) {
                if (minDist > dist((double[]) list.get(j), x)) {
                    minDist = dist((double[]) list.get(j), x);
                    index = j;
                }
            }
            if (i != k - 1) {
                list.remove(index);
            }
        }

        return (double[]) list.get(index);
    }

    /**
     * 返回与相似序列的距离比较之下的较大值
     *
     * @param o 输入序列
     * @param x 测试序列
     * @param nnk 第k相似的序列
     */
    public double reachDist(double[] o, double[] x, double[] nnk) {
        return Math.max(dist(o, x), dist(nnk, x));
    }

    /**
     * 返回序列之间的欧几里德距离
     *
     * @param nnk 第k相似的序列
     * @param x 测试序列
     */
    private double dist(double[] nnk, double[] x) {

        double sum = 0;
        for (int i = 0; i < nnk.length; i++) {
            sum += (nnk[i] - x[i]) * (nnk[i] - x[i]);
        }

        return Math.sqrt(sum);
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}