package LOF;

import ReadJson.Item;
import Tool.FileTool;
import Util.MatrixUtil;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author mezereon E-mail:mezereon@gmail.com
 * @since 18-4-26
 */
public class Experiment {

  public static final int T = 200;
  public static final int L = 50;

  /**
   * Test the LOF
   *
   * @param args
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {

    double[] series = FileTool.getData("data.json");
    double[][] mat = MatrixUtil.getMat(series, T, series.length - T - L + 1, L);
    double[] test = null;

    double[][] matC = new double[L][series.length - T - L - 1];
    double[][] matT = new double[L][T];

    matC = MatrixUtil.getMatC(mat, T, series.length - T - L + 1, L);
    matT = MatrixUtil.getMatT(mat, T, series.length - T - L + 1, L);

//        MatrixUtil.printMatrix(matC);
//        MatrixUtil.printMatrix(matT);

    LOF lof = new LOF(1);

    double[] ncmForC = new double[matC.length];
    double ncmForTest = -1;

    for (int i = 0; i < matC.length; i++) {
      ncmForC[i] = lof.getLOF(matT, matC[i]);
    }

    double[] scores = new double[series.length / L + 1];

    System.out.println("-------------------------------");
//        for (int i=series.length/(2*L);i<series.length/L;i++) {
//
//            test = MatrixUtil.getTestSeries(series, i==0?0:L*i-1, L);
//            ncmForTest = lof.getLOF(matT, test);
//            double count = 0;
//            for (double x : ncmForC) {
//                if (ncmForTest <= x) {
//                    count++;
//                }
//            }
//            count /= matC.length;
//            scores[i] = count;
//            System.out.println(count+",");
//        }
    test = MatrixUtil.getTestSeries(series, series.length - L - 1, L);
    ncmForTest = lof.getLOF(matT, test);
    double count = 0;
    for (double x : ncmForC) {
      if (ncmForTest <= x) {
        count++;
      }
    }
    count /= matC.length;
    System.out.println(count);

  }


}
