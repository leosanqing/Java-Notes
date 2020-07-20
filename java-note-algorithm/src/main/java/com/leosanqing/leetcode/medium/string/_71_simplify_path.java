package com.leosanqing.leetcode.medium.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * @Author: rtliu
 * @Date: 2020/7/20 下午1:56
 * @Package: com.leosanqing.leetcode.medium.string
 * @Description: 1
 * `          Given an absolute path for a file (Unix-style), simplify it.
 * `          Or in other words, convert it to the canonical path.
 * `          In a UNIX-style file system, a period .
 * `          refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 * `
 * `          Note that the returned canonical path must always begin with a slash /,
 * `          and there must be only a single slash / between two directory names.
 * `          The last directory name (if it exists) must not end with a trailing /.
 * `          Also, the canonical path must be the shortest string representing the absolute path.
 * `
 * `          给定文件的绝对路径（Unix风格），请简化它。
 * `          或者换句话说，将其转换为规范路径。
 * `          在UNIX样式的文件系统中，为period。
 * `          指当前目录。此外，双倍..将目录上移
 * `          请注意，返回的规范路径必须始终以斜杠/开头。
 * `          并且两个目录名称之间只能有一个斜杠/。
 * `          最后的目录名称（如果存在）不得以/结尾。
 * `          同样，规范路径必须是代表绝对路径的最短字符串。
 * `
 * `      Example 1:
 * `          Input: "/home/"
 * `          Output: "/home"
 * `          Explanation:
 * `              Note that there is no trailing slash after the last directory name.
 * `      Example 2:
 * `          Input: "/../"
 * `          Output: "/"
 * `          Explanation:
 * `              Going one level up from the root directory is a no-op,
 * `              as the root level is the highest level you can go.
 * `      Example 3:
 * `          Input: "/home//foo/"
 * `          Output: "/home/foo"
 * `          Explanation:
 * `              In the canonical path, multiple consecutive slashes are replaced by a single one.
 * `      Example 4:
 * `          Input: "/a/./b/../../c/"
 * `          Output: "/c"
 * `      Example 5:
 * `          Input: "/a/../../b/../c//.//"
 * `          Output: "/c"
 * `      Example 6:
 * `          Input: "/a//b////c/d//././/.."
 * `          Output: "/a/b/c"
 * @Version: 1.0
 */
public class _71_simplify_path {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    public static String simplifyPath(String path) {
        if (path == null || "".equals(path)) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        HashSet<String> pathSet = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String s : split) {
            if ("..".equals(s) && !stack.isEmpty()) {
                stack.pop();
            } else if (!pathSet.contains(s)) {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();

    }

}
