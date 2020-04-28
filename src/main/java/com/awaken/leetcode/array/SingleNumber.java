package com.awaken.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: Noseparte
 * @Date: 2020/4/28 1:09 下午
 * @Description:
 *
 *          <p>面试题56 - I. 数组中数字出现的次数</p>
 *          <p>一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *          要求时间复杂度是O(n)，空间复杂度是O(1)。</p>
 *
 *          <p>示例 1：</p>
 *          <p>输入：nums = [4,1,4,6]</p>
 *          <p>输出：[1,6] 或 [6,1]</p>
 *
 *          <p>示例 2：</p>
 *          <p>输入：nums = [1,2,10,4,1,4,3,3]</p>
 *          <p>输出：[2,10] 或 [10,2]</p>
 *
 */
public class SingleNumber {

    public static int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for (int num : nums) {
            k ^= num;
        }

        //获得k中最低位的
        int mask = 1;

        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] numbers = SingleNumber.singleNumbers(new int[]{4, 1, 4, 6});
        System.out.println(Arrays.toString(numbers));
    }

}
