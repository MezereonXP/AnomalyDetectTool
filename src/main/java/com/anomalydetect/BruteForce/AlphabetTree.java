package com.anomalydetect.BruteForce;

/**
 * @program: anomaly-detection
 * @description: The tree to map word
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-11 14:12
 **/
public class AlphabetTree {

    private AlphabetTreeNode head;

    AlphabetTree(char initChar, int depth, int ways) {
        head = new AlphabetTreeNode(false, initChar, true);
    }

    public void addNote(Notes note) {
        char[] chars = note.getData();
        AlphabetTreeNode temp = head;
        int position = 0;
        for (char c : chars) {
            if (!temp.isHaveLabel(c)) {
                temp.getNodeList().add(new AlphabetTreeNode(position == chars.length - 1, c, false));
            }
            if (position == chars.length - 1) {
                temp.getNodeByLabel(c).getNotes().add(note);
                if (temp.getNodeByLabel(c).getNotes().size() > 1) {
                    temp.increase(c);
                }
            }
            temp = temp.getNodeByLabel(c);
            position++;
        }
    }

    /**
     * 给节点加上子节点
     *
     * @param node     节点
     * @param initChar 初始字符
     * @param ways     分成几个类别的字符
     * @param isLeaf   是否是叶节点
     */
    private void addNodes(AlphabetTreeNode node, char initChar, int ways, boolean isLeaf) {
        for (int i = 0; i < ways; i++) {
            AlphabetTreeNode n = new AlphabetTreeNode(isLeaf, (char) (initChar + i), false);
            node.getNodeList().add(n);
        }
    }
}
