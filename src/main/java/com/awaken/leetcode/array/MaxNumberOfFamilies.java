package com.awaken.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/11 11:09 上午
 * @Description:
 *
 *          <p>1386. 安排电影院座位</p>
 */
public class MaxNumberOfFamilies {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int left = 0b11110000;
        int middle = 0b11000011;
        int right = 0b00001111;

        Map<Integer, Integer> occupied = new HashMap<>();
        for (int[] seat : reservedSeats) {
            if (seat[1] >= 2 && seat[1] <= 9) {
                int origin = occupied.getOrDefault(seat[0], 0);
                int value = origin | (1 << seat[1] - 2);
                occupied.put(seat[0], value);
            }
        }

        int nas = (n - occupied.size()) * 2;
        for (Map.Entry<Integer, Integer> entry : occupied.entrySet()) {
            int bitmask = entry.getValue();
            if (((bitmask | left) == left) || ((bitmask | middle) == middle) || ((bitmask | right) == right)) {
                ++nas;
            }
        }
        return nas;

    }

    public static void main(String[] args) {
        int number = new MaxNumberOfFamilies().maxNumberOfFamilies(2, new int[][]{{2, 1}, {1, 8}, {2, 6}});
        System.out.println(number);
    }

}
