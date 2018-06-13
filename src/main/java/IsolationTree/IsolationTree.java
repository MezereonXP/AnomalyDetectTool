package IsolationTree;

import Tool.MathTool;

import java.util.Arrays;

public class IsolationTree {
    private IsolationTreeNode root;//树的根节点

    /**
     * 创建树
     *
     * @param data
     * @param maxHeight
     */
    public void create(double[] data, int maxHeight) {
        Arrays.sort(data);
        root = createByR(data, 0, maxHeight, 0, data.length - 1);
    }

    /**
     * 通过递归创建树，树的递归体
     *
     * @param data
     * @param currentHeight
     * @param maxHeight
     * @param start
     * @param end
     * @return
     */
    private IsolationTreeNode createByR(double[] data, int currentHeight, int maxHeight, int start, int end) {
        if (start > end) return null;
        if (currentHeight == maxHeight || end == start) {
            IsolationTreeNode node = new IsolationTreeNode(0.0);
            node.size = end - start + 1;
            return node;
        }
        double min = data[start];
        double max = data[end];
        double divd;
        do {
            divd = min + Math.random() * max;
        } while (divd <= min || divd >= max);
        int i;
        for (i = start; i <= end; i++) {
            if (data[i] >= divd) {
                break;
            }
        }
        IsolationTreeNode node = new IsolationTreeNode(divd);
        node.left = createByR(data, currentHeight + 1, maxHeight, start, i - 1);
        node.right = createByR(data, currentHeight + 1, maxHeight, i, end);
        return node;
    }

    /**
     * 从当前树查找 x 的高度
     *
     * @param x
     * @return
     */
    public double pathLength(double x) {
        return pathLengthM(x, root, 1);
    }

    /**
     * 通过递归查找值
     *
     * @param x
     * @param node
     * @param currHeight
     * @return
     */
    private double pathLengthM(double x, IsolationTreeNode node, int currHeight) {
        if (node.isExtenal()) {
            return currHeight + e(node.size);
        }
        if (x >= node.divdNum) {
            return pathLengthM(x, node.right, currHeight + 1);
        } else {
            return pathLengthM(x, node.left, currHeight + 1);
        }
    }

    /**
     * 对节点的一个标准化，主要作用是放大 n 大于 1 的数，缩小 n 等于 1的数
     *
     * @param n
     * @return
     */
    private double e(int n) {
        double s = (double) n;
        return 2 * (Math.log(s) + MathTool.EulerConstant) + 2 * (s - 1) / s;
    }
}
