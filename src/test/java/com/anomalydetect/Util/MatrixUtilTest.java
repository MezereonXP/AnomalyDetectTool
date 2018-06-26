package com.anomalydetect.Util;

import org.junit.Test;

public class MatrixUtilTest {

    @Test
    public void getMat() {
        double[] num = {1, 2, 3, 4, 5, 6};
        double[][] mat = MatrixUtil.getMat(num, 2, 2, 3);
        System.out.println(mat.length);

    }
}