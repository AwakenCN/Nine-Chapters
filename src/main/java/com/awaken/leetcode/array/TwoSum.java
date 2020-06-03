package com.awaken.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Noseparte
 * @Date: 2020/6/3 4:09 下午
 * @Description:
 *
 *          <p></p>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] sum = new TwoSum().twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(sum));
    }

}
