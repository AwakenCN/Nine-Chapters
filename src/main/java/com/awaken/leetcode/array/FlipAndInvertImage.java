package com.awaken.leetcode.array;

import java.util.Arrays;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/13 7:37 下午
 * @Description:
 *
 *          <p>832. 翻转图像</p>
 */
public class FlipAndInvertImage {

    public int[][] flipAndInvertImage(int[][] A) {

        int length = A.length;

        int[][] result = new int[A.length][];

        for (int j = 0; j < length; j++) {
            int[] a = A[j];
            int n = a.length;
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                int image = a[n - 1 - i] == 0 ? 1 : 0;
                b[i] = image;
            }
            result[j] = b;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] image = new FlipAndInvertImage().flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}});
        for (int[] a : image) {
            System.out.println(Arrays.toString(a));
        }
    }

}
