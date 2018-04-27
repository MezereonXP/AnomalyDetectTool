package ExponentialMoving;

import ReadJson.Item;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * 使用二阶指数平滑以及SGD进行自动化参数调整
 *
 * @author mezereon E-mail:mezereon@gmail.com
 * @since 18-4-26
 */
public class HoltWinters {

    public static void main(String[] args) throws FileNotFoundException {
        double[] data = getData();//    时间序列数据
        double[] s1 = new double[data.length];//    指数平滑中的s1
        double[] s2 = new double[data.length];//    指数平滑中的s2

        double[] ds1 = new double[data.length];//   s1的对应偏导数
        double[] ds2 = new double[data.length];//   s2的对应偏导数

        double alpha = 0.1;//   指数平滑的初始参数
        double step = 0.05;//   步长
        double lastAlpha = 0.1;//   记录之前的alpha值

        int count = 0;//    训练次数计数

        //training model
        while (count < 1000) {
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
//                if (Math.abs(predict - data[i]) > 0.2) {
//                    System.out.println(data[i - 1] + "," + data[i] + "--------predict: " + predict);
//                }

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
            if (Math.abs(alpha-lastAlpha)<1E-8){
                break;
            }
            lastAlpha = alpha;
            System.out.println("MSE is " + sum / (data.length));
//            System.out.println("Alpha is " + alpha);
        }

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
            if (Math.abs(predict - data[i]) > 0.2) {
                System.out.println(data[i - 1] + "," + data[i] + "--------predict: " + predict);
            }
        }


    }

    /**
     * 获得初始值， 也就是数组前a个数的平均数
     *
     * @param data
     * @param a
     * @return
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

    /**
     * 通过json文件获取时间序列数据
     *
     * @return
     * @throws FileNotFoundException
     */
    private static double[] getData() throws FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader("data.json");
        Item[] items = gson.fromJson(reader, Item[].class);
        double[] series = new double[items.length];

        System.out.println(items.length);

        int i = 0;
        for (Item item : items) {
            series[i++] = item.getEvent().getTotal_count() / (60 * 60 * 1000);
//            System.out.println(item.getEvent().getTotal_count() / (60 * 60 * 1000) + ",");
        }
        return series;

    }
}
