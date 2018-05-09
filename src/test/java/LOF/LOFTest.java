package LOF;

import org.junit.Assert;
import org.junit.Test;

public class LOFTest {

    @Test
    public void findKthPoint() {
        LOF lof = new LOF(1);
        double[][] knn ={{1.0, 2.0}, {3.1, 4.0}};
        double[] x = {1.0, 2.0};
        Assert.assertEquals(lof.findKthPoint(knn,x)[0],1.0,0.1);
    }

}