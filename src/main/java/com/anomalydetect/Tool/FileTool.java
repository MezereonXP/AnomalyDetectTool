package com.anomalydetect.Tool;

import com.anomalydetect.ReadJson.Data;
import com.anomalydetect.ReadJson.Datas;
import com.anomalydetect.ReadJson.Item;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author mezereon E-mail:mezereonxp@gmail.com
 * @since 18-4-12
 */
public class FileTool {

    /**
     * 通过json文件获取时间序列数据
     */
    public static double[] getData(String filePath) throws FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader(filePath);
        Item[] items = gson.fromJson(reader, Item[].class);
        double[] series = new double[items.length];

        System.out.println(items.length);

        int i = 0;
        for (Item item : items) {
            series[i++] = item.getEvent().getTotal_count() / (60 * 60 * 1000);
            System.out.print(item.getEvent().getTotal_count() / (60 * 60 * 1000) + ", ");
        }
        System.out.println();
        return series;

    }


    /**
     * 通过json文件获取时间序列数据
     */
    public static double[] getData2(String filePath) throws FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader(filePath);
        Data[] items = gson.fromJson(reader, Data[].class);
        double[] series = new double[items.length];

        System.out.println(items.length);

        int i = 0;
        for (Data item : items) {
            series[i++] = item.getCaiji_zhi();
            System.out.print(item.getCaiji_zhi() + ", ");
        }
        System.out.println();
        return series;

    }
}
