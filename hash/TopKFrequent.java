package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @source: leetcode347
 * @difficulty: medium
 * @topic: 前k个高频元素
 * @link: https://leetcode.cn/problems/top-k-frequent-elements/
 * @description: 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * @input: nums = [1,1,1,2,2,3], k = 2
 * @output: [1, 2]
 * @requirements:
 */
public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 1, 1, 1, 2, 2, 4}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        int maxTimes = Integer.MIN_VALUE;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxTimes = Math.max(maxTimes, map.get(num));
        }
        // 在优先队列中存储二元组 (num, cnt), cnt 表示元素值 num 在数组中的出现次数
        // 出现次数按从队头到队尾的顺序是从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // 大顶堆需要对所有元素进行排序
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

//       小顶堆版本
//        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
//            public int compare(int[] m, int[] n) {
//                return m[1] - n[1];
//            }
//        });
//        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
//            int num = entry.getKey(), count = entry.getValue();
//            if (queue.size() == k) {  这里要判断对元素的个数，如果小于 k，直接插入；大于 则需要判断
//                if (queue.peek()[1] < count) {
//                    queue.poll();
//                    queue.offer(new int[]{num, count});
//                }
//            } else {
//                queue.offer(new int[]{num, count});
//            }
//        }
//
        for (int i = 0; i < k; i++) { // 依次从队头弹出k个,就是出现频率前 k 高的元素
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
