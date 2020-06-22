package com.leosanqing.leetcode.medium.array;

import java.util.*;

/**
 * @Author: rtliu
 * @Date: 2020/6/22 下午4:13
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: There are a total of n courses you have to take, labeled from 0 to n-1.  Some courses may have
 * prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take
 * to finish all courses.  There may be multiple correct orders, you just need to return one of them. If it is
 * impossible to finish all courses, return an empty array.
 * @Version: 1.0
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 * Example 2:
 * <p>
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 */
public class _210_courseScheduleII {

    public static void main(String[] args) {
        int[][] courses = {
                {0, 1},
                {1, 2},
                {2, 3},
                {5, 3},
                {4, 2}
        };

        canFinish(6, courses);

    }


    public static int[] canFinish(int numCourses, int[][] prerequisites) {


        int[] answer = new int[numCourses];
        int cur = numCourses - 1;


        if (numCourses <= 0) {
            return new int[]{};
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        // 因为依赖的课程在第二个位置，所以可以查看有多少个课程依赖了这个课程
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]]++;
        }

        // 把最基础的课程(没有其他依赖的)加入队列
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                answer[cur--] = i;

            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (x == prerequisite[0]) {
                    inDegree[prerequisite[1]]--;
                    // 如果没有课程依赖了，那么这个课程就要被放入之前的队列中，再次循环
                    if (inDegree[prerequisite[1]] == 0) {
                        queue.offer(prerequisite[1]);
                        answer[cur--] = prerequisite[1];
                    }
                }
            }
        }

        // 如果有一个不是0，那么就说明他没有上完
        for (int value : inDegree) {
            if (value != 0) {
                return new int[]{};
            }
        }

        return answer;
    }
}
