package com.awaken.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/12 7:58 下午
 * @Description:
 *
 *          <p>118. 杨辉三角</p>
 */
public class YangHuiTrigonometric {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new YangHuiTrigonometric().generate(5);
        lists.forEach(System.out::println);
//        System.out.println(lists);

    }

}
