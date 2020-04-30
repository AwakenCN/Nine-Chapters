package com.awaken.leetcode.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: Noseparte
 * @Date: 2020/4/30 12:28 下午
 * @Description:
 *
 *          <p>leetcode 202.快乐数</p>
 *
 *          <p>编写一个算法来判断一个数 n 是不是快乐数。</p>
 *          <p>「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 *          也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。</p>
 *          <p>如果 n 是快乐数就返回 True ；不是，则返回 False 。</p>
 *
 *          示例：
 *              输入：19
 *              输出：true
 *              解释：
 *                  12 + 92 = 82
 *                  82 + 22 = 68
 *                  62 + 82 = 100
 *                  12 + 02 + 02 = 1
 */
public class HappyNumber {

    //方法一、用HashSet检测循环
    public static boolean getHappyNumber(int num) {
        Set<Integer> seen = new HashSet<>();
        while (num != 1 && !seen.contains(num)) {
            seen.add(num);
            num = getNext(num);
        }
        return num == 1;
    }

    //方法二、单向链表法
    //快慢指针法
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }


    private static final Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    //方法三、数学法
    public boolean isHappyMath(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }


    private static int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int d = n % 10;//个位数
            n = n / 10;
            next += d ^ 2;
        }
        return next;
    }

    public static void main(String[] args) {
        boolean isHappy = HappyNumber.getHappyNumber(14);
        System.out.println(isHappy);
    }


}
