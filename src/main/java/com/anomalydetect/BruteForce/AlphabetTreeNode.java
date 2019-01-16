package com.anomalydetect.BruteForce;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: anomaly-detection
 * @description: A node of AlphabetTree
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-11 14:13
 **/
public class AlphabetTreeNode {

    private boolean isLeaf;
    private boolean isRoot;
    private char label;
    private List<Notes> notes;
    private List<AlphabetTreeNode> nodeList;

    /**
     * Constructor
     *
     * @param isLeaf 是否是叶子节点
     * @param label 所带的label值
     * @param isRoot 是否是根节点
     */
    AlphabetTreeNode(boolean isLeaf, char label, boolean isRoot) {
        this.isLeaf = isLeaf;
        this.label = label;
        this.isRoot = isRoot;
        nodeList = new ArrayList<AlphabetTreeNode>();
        if (isLeaf) {
            notes = new ArrayList<Notes>();
        }
    }

    /**
     * 判断是否含有label
     *
     * @param label
     * @return
     */
    public boolean isHaveLabel(char label) {
        return getNodeByLabel(label) != null;
    }

    /**
     * 通过label获取节点
     *
     * @param label
     * @return
     */
    public AlphabetTreeNode getNodeByLabel(char label) {
        for (AlphabetTreeNode node : nodeList) {
            if (node.label == label) {
                return node;
            }
        }
        return null;
    }

    public void increase(char label) {
        for (Notes notes : getNodeByLabel(label).notes) {
            notes.setCount(notes.getCount() + 1);
        }
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public List<AlphabetTreeNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<AlphabetTreeNode> nodeList) {
        this.nodeList = nodeList;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public List<Notes> getNotes() {
        return notes;
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }

}
