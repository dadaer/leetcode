package array.medium;

/**
 * @source: leetcode443
 * @difficulty: medium
 * @topic: 压缩字符串
 * @link: https://leetcode.cn/problems/string-compression/
 * @description:
 * @input: chars = ["a","a","b","b","c","c","c"]
 * @output: 6
 * @requirements: 数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 */
public class Compress {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
    }

    // 一种不需要特殊处理最后一个元素的方法
    public static int compress0(char[] chars) {
        // 双指针问题 一个控制读取的位置 一个控制写入
        int p = 0, q = 0, n = chars.length;
        while (q < n) {
            char cur = chars[q];
            int cnt = 0;
            while (q < n && chars[q] == cur) {
                cnt++;
                q++;
            }
            chars[p++] = cur;
            if (cnt != 1) {
                // 将得到的数字挨个写入
                char[] counter = (cnt + "").toCharArray();
                for (char c : counter)
                    chars[p++] = c;
            }
        }
        return p;
    }

    // 官解 也不需要单独考虑最后一个元素
    public static int compress1(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public static int compress(char[] chars) {
        int count = 1;
        char c = chars[0];
        int length = chars.length;
        int index = 0;
        int cur;
        for (int i = 1; i < length; i++) {
            if (chars[i] == c) {
                count++;
            } else {
                chars[index++] = c;
                if (count > 1) {
                    cur = index;
                    while (count > 0) {
                        chars[index++] = (char) (count % 10 + '0');
                        count /= 10;
                    }
                    reverse(chars, cur, index - 1);
                }
                c = chars[i];
                count = 1;
            }
        }
        // 遍历到最后 i == length
        chars[index++] = c;
        if (count > 1) {
            int last = index;
            while (count > 0) {
                chars[index++] = (char) (count % 10 + '0');
                count /= 10;
            }
            reverse(chars, last, index - 1);
        }
        return index;
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
