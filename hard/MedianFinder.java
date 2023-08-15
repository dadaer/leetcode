package hard;

import java.util.PriorityQueue;

/**
 * @source: leetcode295
 * @difficulty: hard
 * @topic: 数据流的中位数
 * @link: https://leetcode.cn/problems/find-median-from-data-stream/description/
 * @description: 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受
 * @input:
 * @output:
 * @requirements:
 */
public class MedianFinder {
    PriorityQueue<Integer> minQueue; // 小于等于中位数 大顶堆
    PriorityQueue<Integer> maxQueue; // 大雨中位数 小顶堆

    public static void main(String[] args) {

    }

    public MedianFinder() {
        minQueue = new PriorityQueue<>((a, b) -> (b - a));
        maxQueue = new PriorityQueue<>(); // 默认小顶堆
    }

    public void addNum(int num) {
        if (minQueue.isEmpty() || num < minQueue.peek()) {
            minQueue.offer(num);
            if (minQueue.size() > maxQueue.size() + 1) {
                minQueue.offer(minQueue.poll());
            }
        } else {
            maxQueue.offer(num);
            if (maxQueue.size() > minQueue.size()) {
                minQueue.offer(maxQueue.poll());
            }
        }
    }

    public double findMedian() {
        if (minQueue.size() > maxQueue.size()) {
            return minQueue.peek();
        }
        return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }
}
