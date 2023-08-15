import design.LRUCache;
import linkedList.ListNode;
import tree.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        double a = 1;
//        System.out.println(a / 2);
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
//        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
//        System.out.println(longestPalindrome("baab"));
//        System.out.println(reverseWords("120"));
//        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
//        System.out.println(addStrings("123", "11"));
//        Arrays.sort(new int[][]{{1, 3}, {0, 4}}, (o1, o2) -> o1[0] - o2[0]);
//        System.out.println(Arrays.toString(searchRange(new int[]{}, 6)));
//        List<String> list = new ArrayList<>();
//        list.add("leet");
//        list.add("code");
//        System.out.println(wordBreak("leetcode", list));
//        System.out.println(rob(new int[]{1, 2, 3, 1}));
//        sortColors(new int[]{2,0,2,1,1,0});
//        System.out.println(reverseWords1("  hello world  "));
//        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
//        System.out.println(largestNumber(new int[]{10,2}));
//        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
//        System.out.println(removeKdigits("112", 1));
//        System.out.println(removeDuplicates1(new int[]{1,1,2,2,2,2,3,3,3}));
//        System.out.println(jump(new int[]{2,3,1,1,4}));
//        merge1(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
//        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
//        minWindow("aa", "aa");
//        String s = "abbbabbbab";
//        Integer a = 14444;
//        System.out.println(a.hashCode());
//        System.out.println(s.hashCode());
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);
    }

    public static String minWindow(String s, String t) {
        int left = 0, right = 0, length = Integer.MAX_VALUE, valid = 0;
        int start = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid += need.get(c);
                }
            }
            while (valid == t.length()) {
                if (right - left < length) {
                    length = right - left;
                    start = left;
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (need.get(c1).equals(window.get(c1))) {
                        valid -= window.get(c1);;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int p3 = nums1.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                nums1[p3--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[p3--] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[p3--] = nums2[p2--];
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            }
        }
    }


    public static int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        // 初始化
        Arrays.fill(nums,length);
        dp[0] = 0;

        // 递推
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[length - 1];
    }

    public static int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int index = 0;
        int i = 0, j = 1;
        while (j < length) {
            while (j < length && nums[j] == nums[i]) {
                j++;
            }
            nums[index++] = nums[i];
            i = j;
            j = i + 1;
        }
        nums[index] = nums[i];
        return index;
    }

    public static String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int length = num.length();
        if (length == k) {
            return "0";
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            while (sb.length() > 0 && num.charAt(i) < sb.charAt(sb.length() - 1) && count < k) {
                sb.deleteCharAt(sb.length() - 1);
                count++;
            }
            if (num.charAt(i) == '0' && sb.length() == 0) {
                continue;
            }
            sb.append(num.charAt(i));
        }
        String res = sb.substring(0, Math.max(sb.length() - k, 0));
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int prefixSum = 0;
        while (end < length) {
            while (end < length && prefixSum < target) {
                prefixSum += nums[end++];
            }
            while (prefixSum >= target) {
                ans = Math.min(ans, end - start);
                prefixSum -= nums[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //  x + y > y + x 则 x > y
        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        if (sb.length() > 1 && sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    public static int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if ((mid == 0 && nums[mid] > nums[mid + 1]) ||
                    (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) ||
                    nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                i = mid + 1;
            } else if (nums[mid] < nums[mid - 1]) {
                j = mid + 1;
            }
        }
        return i;
    }
    public static String reverseWords1(String s) {
        // 去除首尾以及中间多余空格
        String s1 = removeSpace(s);
        // 反转字符串
        String s2 = reverse(s1);
        // 反转每个单词
        return reverseEachWord(s2);
    }

    private static String reverseEachWord(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int j = i;
            while(j < length && s.charAt(j) != ' ') {
                j++;
            }
            sb.append(reverse(s.substring(i , j)));
            sb.append(' ');
            i = j + 1;
        }
        return sb.toString();
    }

    private static String removeSpace(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            while (i < length && (sb.length() == 0 || sb.charAt(sb.length() - 1) == ' ') && s.charAt(i) == ' ') {
                i++;
            }
            sb.append(s.charAt(i));
        }
        while (sb.charAt((sb.length() - 1)) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static String reverse(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        int length1 = a1.length;
        int length2 = a2.length;
        int i = 0, j = 0;
        while (i < length1 || j < length2) {
            int v1 = i < length1 ? Integer.parseInt(a1[i]) : 0;
            int v2 = j < length2 ? Integer.parseInt(a2[j]) : 0;
            if (v1 < v2) {
                return -1;
            }
            if (v1 > v2) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void sortColors(int[] nums) {
        int length = nums.length;
        int p0 = 0;
        int p2 = length - 1;
        int pointer = 0;
        while (pointer < p2) {
            if (nums[pointer] == 0) {
                nums[pointer] = nums[p0];
                nums[p0] = 0;
                p0++;
            }
            if (nums[pointer] == 2) {
                nums[pointer] = nums[p2];
                nums[p2] = 2;
                p2--;
                if (nums[pointer] != 1) {
                    pointer--;
                }
            }
            pointer++;
        }
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();

        boolean[] dp = new boolean[length + 1];

        // 初始化
        dp[0] = true;

        // 递推
        for (int i = 1; i <= length; i++) {
            for (String word : wordDict) {
                int wordLength = word.length();
                if (i >= wordLength) {
                    if (s.substring(i - wordLength, i).equals(word)) {
                        dp[i] = dp[i] || dp[i - wordLength];
                    }
                }
            }
        }

        return dp[length];
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        // 初始化
        dp[0] = nums[0];
        dp[1] = nums[1];

        // 递推
        for(int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return nums[length - 1];
    }

    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int firstIndex = searchRangeHelper(nums, target, 0, length);
        int secondIndex = searchRangeHelper(nums, target + 1, 0, length);
        if (firstIndex == length || nums[firstIndex] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{firstIndex, secondIndex - 1};
    }

    private static int searchRangeHelper(int[] nums, int target, int i, int j) {
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int length1 = num1.length();
        int length2 = num2.length();
        int i = length1 - 1, j = length2 - 1;
        int add = 0;
        while (i >= 0 || j >= 0) {
            int add1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int add2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = add1 + add2 + add;
            add = sum / 10;
            int number = sum % 10;
            stringBuilder.insert(0, number);
            i--;
            j--;
        }
        if (add != 0) {
            stringBuilder.insert(0, add);
        }
        return stringBuilder.toString();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        List<Integer> ret = new ArrayList<>();
        while (true) {
            for (int i = left; i < right; i++) {
                ret.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i < bottom; i++) {
                ret.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i > left; i--) {
                ret.add(matrix[bottom][i]);
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i < top; i--) {
                ret.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return ret;
    }

    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private static void buildMaxHeap(int[] nums, int heapSize) {
        for(int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private static void maxHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, largest, i);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        int max = 0;
        int cur;
        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            cur = Math.max(help(s, i, i), help(s, i, i + 1));
            if (cur > max) {
                max = cur;
                startIndex = i - (cur - 1) / 2;
            }
        }
        return s.substring(startIndex, startIndex + max);
    }

    private static int help(String s, int i, int j) {
        int ret = i == j ? -1 : 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            ret += 2;
            i--;
            j++;
        }
        return ret;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int index = 0;
        int length1 = nums1.length;
        int[] temp = new int[length1];
        while(p1 < m && p2 < n) {
            temp[index++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < m) {
            temp[index++] = nums1[p1++];
        }
        while (p2 < n) {
            temp[index++] = nums2[p2++];
        }
        for (int i = 0; i < length1; i++) {
            nums1[i] = temp[i];
        }
    }

    public static int maxProfit(int[] prices) {
        int boughtPrice = prices[0];
        int length = prices.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            boughtPrice = Math.min(boughtPrice, prices[i]);
            ans = Math.max(ans, prices[i] - boughtPrice);
        }
        return ans;
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int startIndex = -1;
        int length = s.length();
        int ans = 0;
        char c;
        for(int i = 0; i < length; i++) {
            c = s.charAt(i);
            if (map.containsKey(c)) {
                startIndex = Math.max(startIndex, map.get(c));
            }
            map.put(s.charAt(i), i);
            ans = Math.max(ans, i - startIndex);
        }
        return ans;
    }


    // leetcode692  前K个高频单词 优先队列
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((entry1, entry2)
                -> Objects.equals(entry1.getValue(), entry2.getValue()) ?
                entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue());

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0, j = 0;
        while (j < length) {
            while (j < length && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
            i = ++j;
        }
        reverse(chars, i, j - 1);
        return Arrays.toString(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

}
