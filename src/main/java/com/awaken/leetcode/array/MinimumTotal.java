package com.awaken.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/16 5:54 下午
 * @Description:
 *
 *          <p>leetcode 120. 三角形最小路径和</p>
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minLen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) { //第i行有i+1个数字
                minLen[i] = Math.min(minLen[i], minLen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minLen[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        triangle.add(list);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);

        int minimumTotal = new MinimumTotal().minimumTotal(triangle);
        System.out.println(minimumTotal);
    }
}
