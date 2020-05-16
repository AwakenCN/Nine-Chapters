package com.awaken.leetcode.array;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/15 8:09 下午
 * @Description:
 *
 *          <p>1252. 奇数值单元格的数目</p>
 */
public class OddCells {

    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < indices.length; i++) {
            row[indices[i][0]]++;
            col[indices[i][1]]++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if ((row[i] + col[j]) % 2 > 0)
                    ans++;
            }
        return ans;
    }

    public static void main(String[] args) {
        int cells1 = new OddCells().oddCells(2, 3, new int[][]{{0, 1}, {1, 1}});
        System.out.println(cells1);
        int cells = new OddCells().oddCells(2, 2, new int[][]{{1, 1}, {0, 0}});
        System.out.println(cells);
    }


}
