package LOF;

import Tool.DetectTool;
import Util.MatrixUtil;

/**
 * @author mezereon E-mail:mezereonxp@gmail.com
 * @since 18-4-26
 */
public class LOFDetectTool implements DetectTool {

  private int T;// 时间序列用来训练的长度
  private int L;// 时间序列的所利用的窗口长度
  private int K = 1;//  LOF算法中的k值, 默认设置为1, 也就是取历史最相似的序列进行预测

  /**
   * LOF检测工具的构造方法
   *
   * @param T 时间序列用来训练的长度
   * @param L 时间序列的所利用的窗口长度
   */
  public LOFDetectTool(int T, int L) {
    this.T = T;
    this.L = L;
  }


  /**
   * 利用LOF进行时间序列分析
   * 打印最后一段窗口的异常分数, 越接近1则越异常
   */
  public void timeSeriesAnalyse(double[] series) {

    // 利用T和L, 以及时间序列生成测试矩阵
    double[][] mat = MatrixUtil.getMat(series, T, series.length - T - L + 1, L);

    //一个窗口大小的测试序列, 默认是原序列中最后窗口大小的序列
    double[] test = MatrixUtil.getTestSeries(series, series.length - L, L);;

    double[][] matC = MatrixUtil.getMatC(mat, T, series.length - T - L + 1, L);
    double[][] matT = MatrixUtil.getMatT(mat, T, series.length - T - L + 1, L);

    LOF lof = new LOF(K);

    double[] ncmForC = new double[matC.length];

    for (int i = 0; i < matC.length; i++) {
      ncmForC[i] = lof.getLOF(matT, matC[i]);
    }

    double ncmForTest = lof.getLOF(matT, test);
    double count = 0;
    for (double x : ncmForC) {
      if (ncmForTest <= x) {
        count++;
      }
    }
    count /= matC.length;
    System.out.println("Anomaly Score is "+count);
  }

  public int getT() {
    return T;
  }

  public void setT(int t) {
    T = t;
  }

  public int getL() {
    return L;
  }

  public void setL(int l) {
    L = l;
  }

  public int getK() {
    return K;
  }

  public void setK(int k) {
    K = k;
  }
}
