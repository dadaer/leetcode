package graph;

import java.util.*;

/**
 * leetcode207
 * medium
 * 课程表
 */
public class CanFinish {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{0, 1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // get(i) 表示包含 i 课程为先修课程的所有课程
        List<List<Integer>> edges = new ArrayList<>();
        // 入度数组
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        for (int[] ints : prerequisites) {
            edges.get(ints[1]).add(ints[0]);
            ++indeg[ints[0]];
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            for (int v: edges.get(u)){
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 建一个邻接表
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        // 建一个入度数组
        int[] inDegrees = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }

        // 建一个队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            for (int v : edges.get(u)) {
                inDegrees[v]--;
                if (inDegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}
