package com.leosanqing.leetcode.medium.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: rtliu
 * @Date: 2020/6/17 下午3:57
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description:
 *      There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *      Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 *      which is expressed as a pair: [0,1]
 *      Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *      您必须参加总共numCourses课程，从0到numCourses-1标记。
 *      有些课程可能有先决条件，例如，要参加课程0，您必须先参加课程1，表示为一对：[0,1]
 *      鉴于课程总数和先决条件对列表，您是否可以完成所有课程？
 *
 *
 *      Input: numCourses = 2, prerequisites = [[1,0]]
 *      Output: true
 *      Explanation: There are a total of 2 courses to take.
 *                   To take course 1 you should have finished course 0. So it is possible.
 *
 * @Version: 1.0
 */
public class _207_courseSchedule {

    public static void main(String[] args) {
        int[][] courses = {
                {0,1},
                {1,0}
        };

        System.out.println(canFinish(2,courses));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (x == prerequisite[0]) {
                    inDegree[prerequisite[1]] --;
                    if (inDegree[prerequisite[1]] == 0) {
                        queue.offer(prerequisite[1]);
                    }
                }
            }
        }
        for (int value : inDegree) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
