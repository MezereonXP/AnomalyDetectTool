package com.anomalydetect.Tool;

/**
 * 多维度异常检测的接口类
 *
 * @author mezereon E-mail:mezereonxp@gmail.com
 * @since 18-6-26
 */
public interface MultiDetectTool {

    /**
     * 对时间序列进行异常检测
     */
    void multiTimeSeriesAnalyse(double[][] data, int dimension);
}
