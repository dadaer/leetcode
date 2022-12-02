package dynamicprogramming.completeKnapsack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

/**
 * leetcode139
 * medium
 * 单词拆分
 */
public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak1("leetcode", wordDict));
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        // 初始化
        dp[0] = true;
        // 递推
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int wordLength = wordDict.get(j).length();
                if (i >= wordLength) {
                    if (s.substring(i - wordLength, i).equals(wordDict.get(j))) {
                        dp[i] = dp[i] || dp[i - wordLength];
                    }
                }
            }
        }
        return dp[length];
    }

    /**
     * 回头考虑一下 DFS、BFS 解法
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 使用哈希表检索更快
        Set<String> hashSet = new HashSet(wordDict);
        int length = s.length();
        // 状态定义：dp[i] 表示前i个字符可以由单词拼接
        boolean[] dp = new boolean[length + 1];
        // dp[0] 表示空串合法
        dp[0] = true;
        for (int i = 1; i <= length; i++) { // 优化：考虑剪枝
            for (int j = 0; j < i; j++) {
                // 状态转移
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
