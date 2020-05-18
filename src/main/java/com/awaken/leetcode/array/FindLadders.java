package com.awaken.leetcode.array;

import java.util.*;

/**
 * @Auther: Noseparte
 * @Date: 2020/5/18 5:56 下午
 * @Description:
 *
 *          <p>leetcode 面试题 17.22. 单词转换</p>
 */
public class FindLadders {

    List<String> wordList;
    boolean[] marked;
    List<String> output;
    String endWord;
    List<String> result;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.wordList = wordList;
        output = new ArrayList();
        marked = new boolean[wordList.size()];
        result = new ArrayList();
        this.endWord = endWord;
        dfs(beginWord);
        return result;
    }

    public void dfs(String s) {
        output.add(s);
        Queue<String> queue = oneCharDiff(s);
        for (String str : queue) {
            if (str.equals(endWord)) {
                output.add(str);
                result = new ArrayList(output);
                return;
            }
            dfs(str);
            output.remove(output.size() - 1);
        }

    }

    public Queue<String> oneCharDiff(String s) {
        Queue<String> queue = new LinkedList();
        for (int j = 0; j < wordList.size(); j++) {
            String str = wordList.get(j);
            int diffNum = 0;
            if (str.length() != s.length() || marked[j]) continue;
            for (int i = 0; i < str.length(); i++) {
                if (diffNum >= 2) break;
                if (str.charAt(i) != s.charAt(i)) diffNum++;
            }
            if (diffNum == 1) {
                queue.add(str);
                marked[j] = true;
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        List<String> ladders = new FindLadders().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladders);
    }

}
