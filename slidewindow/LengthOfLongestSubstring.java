package slidewindow;
import java.util.HashMap;
import java.util.Map;

/**
 * @source: leetcode3
 * @difficulty: medium
 * @topic: 无重复字符的最长子串
 * @link: https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @input: s = "abcabcbb"
 * @output: 3
 * @requirements:
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcacbcc";
        int max = lengthOfLongestSubstring(s);
        System.out.println(max);
    }


    // 滑动窗口方法
    public static int lengthOfLongestSubstring(String s) {
        // if(s==null) return 0;这句话可以不加，s.length() 长度为 0 时，不进入下面的循环，会直接返回 max = 0;
        // 划定当前窗口的坐标为 (start, i] ,左开右闭,所以 start 的初始值为-1，而非 0。
        int max = 0, start = -1;
        //使用哈希表 map 统计各字符最后一次出现的索引位置
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            // 当字符在 map 中已经存储时，需要判断其索引值 index 和当前窗口 start 的大小以确定是否需要对 start 进行更新:
            // 当 index > start 时，start 更新为当前的 index,否则保持不变。
            // 注意若 index 作为新的 start，计算当前滑动空间的长度时也是不计入的，左开右闭，右侧 s[i] 会计入，这样也是防止字符的重复计入。
            if (map.containsKey(tmp)) {
                start = Math.max(start, map.get(tmp));
            }
            // 如果 map 中不含 tmp，此处是在 map 中新增一个键值对，否则是对原有的键值对进行更新
            map.put(tmp, i);
            // 每一轮都需要更新 max 值
            // i - start,为当前滑动空间 (start, i] 的长度，若其大于 max，则需要进行更新。
            max = Math.max(max, i - start);
        }
        return max;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int startIndex = -1;
        int index;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                index = map.get(s.charAt(i));
                if (index > startIndex) {
                    ans = Math.max(ans, i - index);
                    startIndex = index;
                } else {
                    ans = Math.max(ans, i - startIndex);
                }
            } else {
                ans = Math.max(ans, i - startIndex);
            }
            map.put(s.charAt(i), i);
        }
        return ans;
    }
}
