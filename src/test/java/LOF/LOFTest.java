package LOF;

import org.junit.Assert;

class LOFTest {

    @org.junit.jupiter.api.Test
    void findKthPoint() {
        LOF lof = new LOF(2);
        double[][] knn ={{1.0, 2.0}, {3.1, 4.0}};
        double[] x = {1.0, 2.0};
        Assert.assertEquals(lof.findKthPoint(knn,x)[0],1.0,0.1);
    }

}