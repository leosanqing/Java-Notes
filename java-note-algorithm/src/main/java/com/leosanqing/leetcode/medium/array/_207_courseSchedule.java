package com.leosanqing.leetcode.medium.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: rtliu
 * @Date: 2020/6/17 下午3:57
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description: There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *                  Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 *                  which is expressed as a pair: [0,1]
 *                  Given the total number of courses and a list of prerequisite pairs,
 *                  is it possible for you to finish all courses?
 * <p>
 *                  您必须参加总共numCourses课程，从0到numCourses-1标记。
 *                  有些课程可能有先决条件，例如，要参加课程0，您必须先参加课程1，表示为一对：[0,1]
 *                  鉴于课程总数和先决条件对列表，您是否可以完成所有课程？
 * <p>
 * <p>
 *    Input: numCourses = 2, prerequisites = [[1,0]]
 *    Output: true
 *    Explanation: There are a total of 2 courses to take.
 *    To take course 1 you should have finished course 0. So it is possible.
 * @Version: 1.0
 */
public class _207_courseSchedule {

    public static void main(String[] args) {
        int[][] courses = {
                {0, 1},
                {1, 2},
                {2, 3},
                {5, 3},
                {4, 2}
        };

        System.out.println(canFinish(6, courses));


    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
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
                    }
                }
            }
        }

        // 如果有一个不是0，那么就说明他没有上完
        for (int value : inDegree) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }



}
