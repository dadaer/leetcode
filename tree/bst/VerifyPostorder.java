package tree.bst;

/**
 * @source: 剑指offer33
 * @difficulty: medium
 * @topic: 二叉搜索树的后序遍历序列
 * @link: https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/description/
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @input: [1,3,2,6,5]
 * @output: true
 * @explanation:
 * @requirements:
 */
public class VerifyPostorder {
    public static void main(String[] args) {

    }

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private static boolean recur(int[] postorder, int left, int right) {
        // （结束条件最后看！）左右指针重合的时候，即 left ~ right 区间只有一个数
        if (left >= right) {
            return true;
        }
        // 在后序遍历中根节点一定是最后一个点
        int root = postorder[right];
        int index = left;
        while (postorder[index] < root) {
            index++;
        }
        int m = index; // left ~ right之间第一个比 root 大的点，即 root 右子树中最小的点（右子树后序遍历的起点）
        // 如果 m ~ right 区间（root 的右子树）出现了比 root 小的节点，则不可能是后序遍历
        while (index < right) {
            if (postorder[index] < root) {
                return false;
            }
            index++;
        }
        // 此时能保证 left ~ m - 1 都比 root 小，m ~ right - 1 都比 root 大，但这两个子区间内部的情况需要继续递归判断
        return recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }
}
