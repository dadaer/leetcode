package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode406
 * @difficulty: medium
 * @topic: 根据身高重建队列
 * @link: https://leetcode.cn/problems/queue-reconstruction-by-height/
 * @description:
 * @input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * @output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * @requirements:
 */
public class ReconstructQueue_ {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0},
                {6, 1}, {5,2}})));
    }

    // 一般这种数对，还涉及排序的，
    // 根据第一个元素正向排序，根据第二个元素反向排序，
    // 或者根据第一个元素反向排序，根据第二个元素正向排序，往往能够简化解题过程。
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    // 若结果大于0，说明person2 > person1, 降序
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });

        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] > list.size()) {
                list.add(people[i]);
            } else {
                list.add(people[i][1],people[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
