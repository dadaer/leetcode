package twopointers;

/*
    给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(8));
    }

    public static boolean judgeSquareSum(int c) {
        int index1 = 0;
        int index2 = (int)Math.sqrt(c);
        while (index1 <= index2) {
            if (Math.pow(index1,2) + Math.pow(index2,2) == c) {
                return true;
            } else if (Math.pow(index1,2) + Math.pow(index2,2) < c) {
                index1++;
            } else {
                index2--;
            }
        }
        return false;
    }
}
