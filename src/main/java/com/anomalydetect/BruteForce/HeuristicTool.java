package com.anomalydetect.BruteForce;

import com.anomalydetect.Result.Result;
import com.anomalydetect.Tool.DetectTool;
import com.anomalydetect.Tool.MathTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: anomaly-detection
 * @description: An Algorithm to speed up BF
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-11 11:13
 **/
public class HeuristicTool implements DetectTool {

    private int w;// SAX表达的word的长度
    private int a = 3;// 字母表的个数
    private List<Result> results;
    private char initChar = 'a';

    HeuristicTool(int w) {
        this.w = w;
        results = new ArrayList<>();
    }

    @Override
    public void timeSeriesAnalyse(double[] data) {
        double[] nums = MathTool.gassian(data);
        char[] chars = saxConvert(nums);
        results = new ArrayList<Result>();

        ArrayList<Notes> notes = new ArrayList<>();

        AlphabetTree tree = new AlphabetTree(initChar, w, a);
        for (int i = 0; i < data.length - w + 1; i++) {
            Notes n = new Notes(w, chars, i, i);
            notes.add(n);
            tree.addNote(n);
        }
        int index = findMinCount(notes);
        doTheHeuristicAnalysis(nums, index, w, notes);

    }

    private void doTheHeuristicAnalysis(double[] data, int index, int length, ArrayList<Notes> notes) {
        double bestDist = 0;
        int bestLoc = -1;
        notes.get(index).setVisited(true);
        double tempDist = Double.MAX_VALUE;
        for (int q = 0; q < data.length - length + 1; q++) {
            if (Math.abs(index - q) >= length && MathTool.dist(data, index, q, length) < tempDist) {
                tempDist = MathTool.dist(data, index, q, length);
            }
        }
        if (tempDist > bestDist) {
            bestDist = tempDist;
            bestLoc = index;
        }

        for (int p = 0; p < data.length - length + 1; p++) {
            if (!notes.get(p).isVisited()) {
                tempDist = Double.MAX_VALUE;
                for (int q = 0; q < data.length - length + 1; q++) {
                    if (Math.abs(p - q) >= length && MathTool.dist(data, p, q, length) < bestDist) {
                        if (tempDist == Double.MAX_VALUE) {
                            tempDist = Double.MIN_VALUE;
                        }
                        break;
                    }
                    if (Math.abs(p - q) >= length && MathTool.dist(data, p, q, length) < tempDist) {
                        tempDist = MathTool.dist(data, p, q, length);
                    }
                }
                if (tempDist > bestDist) {
                    bestDist = tempDist;
                    bestLoc = p;
                }
            }
        }
        results.add(new Result(bestLoc, data[bestLoc]));
    }

    private int findMinCount(ArrayList<Notes> notes) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        int count = 0;
        for (Notes n : notes) {
            if (min > n.getCount()) {
                min = n.getCount();
                index = count;
            }
            count++;
        }
        return index;
    }

    /**
     * SAX编码
     *
     * @param data
     * @return
     */
    private char[] saxConvert(double[] data) {
        char[] result = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = alphabetConvert(data[i]);
        }
        return result;
    }

    /**
     * 将正态化后的数字转换成字母
     *
     * @param datum
     * @return
     */
    private char alphabetConvert(double datum) {
        if (datum >= -0.43 && datum <= 0.43) {
            return 'b';
        } else if (datum < -0.43) {
            return 'a';
        } else {
            return 'c';
        }
    }

    @Override
    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public char getInitChar() {
        return initChar;
    }

    public void setInitChar(char initChar) {
        this.initChar = initChar;
    }
}
