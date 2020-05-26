package com.awaken.leetcode.array;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/26 7:42 下午
 * @Description:
 *
 *          <p>287. 寻找重复数</p>
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        int b = 3 << 2;
        System.out.println(b);
    }
}
