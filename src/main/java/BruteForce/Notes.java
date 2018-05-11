package BruteForce;

/**
 * @program: anomaly-detection
 * @description: To store the string and counts
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-11 11:43
 **/
public class Notes {

    private int length;
    private char[] data;
    private int count = 1;
    private int index;
    private boolean isVisited = false;

    Notes(int length, char[] d, int position, int index) {
        this.length = length;
        this.index = index;
        data = new char[length];
        for (int i = position; i < position + length; i++) {
            data[i - position] = d[i];
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
