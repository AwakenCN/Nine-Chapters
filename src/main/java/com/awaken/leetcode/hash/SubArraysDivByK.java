package com.awaken.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/27 8:37 下午
 * @Description:
 *
 *          <p>974. 和可被 K 整除的子数组</p>
 */
public class SubArraysDivByK {

    public int subArraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int byK = new SubArraysDivByK().subArraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println(byK);
    }

}
