package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @source: leetcode554
 * @difficulty: medium
 * @topic: 砖墙
 * @link: https://leetcode.cn/problems/brick-wall/description/
 * @description:
 * @input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
 * @output: 2
 * @requirements:
 */
public class LeastBricks {
    public static void main(String[] args) {

    }

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int size;
        int sum;
        for (List<Integer> wallItem : wall) {
            size = wallItem.size();
            sum = 0;
            for (int i = 0; i < size - 1; i++) { // 最后一块砖不算
                sum += wallItem.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return wall.size() - res;
    }
}
