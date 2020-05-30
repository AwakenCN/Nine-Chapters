package com.awaken.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/30 8:27 下午
 * @Description:
 *
 *          <p>84. 柱状图中最大的矩形</p>
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int area = 0;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int area = new LargestRectangleArea().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(area);
    }

}
