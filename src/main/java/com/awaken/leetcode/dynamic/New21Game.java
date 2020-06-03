package com.awaken.leetcode.dynamic;

/**
 * @Auther: Noseparte
 * @Date: 2020/6/3 4:05 下午
 * @Description:
 *
 *          <p>837. 新21点</p>
 */
public class New21Game {

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        double probability = new New21Game().new21Game(6, 1, 10);
        System.out.println(probability);
    }

}
