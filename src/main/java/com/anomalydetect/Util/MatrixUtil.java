package com.anomalydetect.Util;

/**
 * Local Outlier Factor
 *
 * @author mezereon E-mail:mezereonxp@gmail.com
 * @since 18-4-12
 */

public class MatrixUtil {

    public static final String PARA_ERROR_MSG = "Parameters Error";

    /**
     * 利用时间序列获取相应大小的矩阵
     *
     * @param series 时间序列
     * @param T 训练集合长度
     * @param C 候选集合长度
     * @param L 窗口长度
     * @return 返回一个Lx（T*C）的矩阵
     */
    public static double[][] getMat(double[] series, int T, int C, int L) {
        if (series.length != (T + C + L - 1)) {
            System.out.println(PARA_ERROR_MSG);
            return null;
        }

        double[][] mat = new double[L][T + C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < T + C; j++) {
                mat[i][j] = series[i + j];
            }
        }
        return mat;
    }

    /**
     * 利用时间序列数据， 获取所需大小的测试序列
     *
     * @param series 时间序列数据
     * @param begin 计算开始的位置
     * @param L 计算的窗口大小
     * @return 返回所需大小的测试序列
     */
    public static double[] getTestSeries(double[] series, int begin, int L) {

        double[] mat = new double[L];
        for (int i = 0; i < L; i++) {
            mat[i] = series[i + begin];
        }
        return mat;
    }

    /**
     * 计算并返回C矩阵
     *
     * @param m 输入矩阵
     * @param T 训练集合长度
     * @param C 候选集合长度
     * @param L 窗口长度
     * @return 返回LOF算法中的C矩阵
     */
    public static double[][] getMatC(double[][] m, int T, int C, int L) {

        double[][] mat = new double[C][L];
        for (int i = 0; i < L; i++) {
            for (int j = T; j < T + C; j++) {
                mat[j - T][i] = m[i][j];
            }
        }
        return mat;
    }

    /**
     * 计算并返回测试矩阵
     *
     * @param m 输入矩阵
     * @param T 训练集合长度
     * @param C 候选集合长度
     * @param L 窗口长度
     * @return 测试矩阵
     */
    public static double[][] getMatT(double[][] m, int T, int C, int L) {

        double[][] mat = new double[T][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < T; j++) {
                mat[j][i] = m[i][j];
            }
        }
        return mat;
    }

    /**
     * 将矩阵内容打印出来
     *
     * @param m 矩阵数组
     */
    public static void printMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
