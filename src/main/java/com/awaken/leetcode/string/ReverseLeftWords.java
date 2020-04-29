package com.awaken.leetcode.string;

/**
 * @Auther: Noseparte
 * @Date: 2020/4/29 1:19 下午
 * @Description:
 *
 *          <p>
 *              面试题58 - II. 左旋转字符串
 *              字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 *              比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *          </p>
 */
class ReverseLeftWord {

    //解法一  最简单的
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    //解法二  要求不能使用切片函数
    public static String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = ReverseLeftWord.reverseLeftWords("helloWorld", 5);
        String s2 = ReverseLeftWord.reverseLeftWords2("helloChina", 5);
        System.out.println(s);
        System.out.println(s2);
    }

}
