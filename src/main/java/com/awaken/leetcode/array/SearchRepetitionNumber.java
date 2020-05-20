package com.awaken.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/20 4:52 下午
 * @Description:
 *
 *          <p>面试题53 - I. 在排序数组中查找数字 I</p>
 */
public class SearchRepetitionNumber {

    public int search1(int[] nums, int target) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer bun : nums) {
            if (!map.containsKey(bun)) {
                map.put(bun, 1);
            } else {
                map.put(bun, map.get(bun) + 1);
            }
        }

        return map.getOrDefault(target, 0);
    }

    //官网优化后的方案
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int time = new SearchRepetitionNumber().search(nums, 8);
        System.out.println(time);
    }
}
