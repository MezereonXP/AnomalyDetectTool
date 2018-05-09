package Tool;

import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class FileToolTest {

    private static final int LENGTH = 360;

    @Test
    void getData() throws FileNotFoundException {
        double[] data = FileTool.getData("data.json");
        Assert.assertEquals(data.length, LENGTH);
    }
}