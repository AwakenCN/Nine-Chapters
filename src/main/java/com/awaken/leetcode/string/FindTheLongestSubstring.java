package com.awaken.leetcode.string;

import java.util.Arrays;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/20 2:52 下午
 * @Description:
 *
 *          <p>1371. 每个元音包含偶数次的最长子字符串</p>
 */
public class FindTheLongestSubstring {

    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                //1 << 0
                status ^= (1);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int substring = new FindTheLongestSubstring().findTheLongestSubstring("sdfrsgsfsfweqwsdc");
        System.out.println(substring);
    }

}
