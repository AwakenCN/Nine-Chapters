package com.awaken.leetcode.string;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/19 3:06 下午
 * @Description:
 *
 *          <p>680. 验证回文字符串 Ⅱ</p>
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean validPalindrome = new ValidPalindrome().validPalindrome("aba");
        System.out.println(validPalindrome);
    }

}
