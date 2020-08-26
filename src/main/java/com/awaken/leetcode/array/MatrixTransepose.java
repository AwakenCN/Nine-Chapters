package com.awaken.leetcode.array;

/**
 * @author Kirago
 * @date 2020/8/26 14:30
 * @description https://leetcode-cn.com/problems/transpose-matrix/ 
 * @version version-1.0
 */

public class MatrixTransepose {
    /**
     * @author Kirago
     * @date 2020/8/26 14:32
     * @description 利用空间换时间，通过复制一个原空间大小的矩阵进行赋值
     * @param A
     * @return 
     * @version version-1.0
     */
    
    
    public int[][] transpose(int[][] A){
        int i=A.length;
        int j=A[0].length;
        int[][] result = new int[j][i];
        for(int x=0;x<j;x++){
            for(int y=0;y<i;y++){
                result[x][y] = A[y][x];
            }
        }
        return result;
    }
}
