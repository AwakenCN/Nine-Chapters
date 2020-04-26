package com.awaken.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Noseparte
 * @Date: 2020/4/26 5:03 下午
 * @Description:
 *
 *          <p>leetcode 15.三数之和</p>
 *
 *          给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *          注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int j = i + 1; // left pointer
            int k = nums.length - 1; //right pointer

            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> curr = new ArrayList<Integer>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    result.add(curr);
                    j++;
                    k--;
                    while (j < nums.length && nums[j] == nums[j - 1]) j++;
                    while (k > j && nums[k] == nums[k + 1]) j--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(ThreeSum.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }


}
