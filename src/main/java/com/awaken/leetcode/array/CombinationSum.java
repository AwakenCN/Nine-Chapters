package com.awaken.leetcode.array;

import java.util.*;


/**
 * @author Kirago
 * @date 2020/9/10 16:44
 * @description https://leetcode-cn.com/problems/combination-sum-ii/ 
 * @version version-1.0
 */


public class CombinationSum {
    
//    private int[] candinates;
//    
//    private List<List<Integer>> res = new ArrayList<>();
//    
//    private int target;
//
//
//    public List<List<Integer>> combinationSum2(int[] candinates, int target){
//        this.candinates = candinates;
//        this.target = target;
//        
//        if(candinates == null || candinates.length == 0) return res;
//
//        Arrays.sort(candinates);
//        
//        List<Integer> list = new ArrayList<>();
//        
//        int len = candinates.length;
//        
//        inner(0, len, 0, list);
//        return res;
//    }
//    
//    private void inner(int index, int len, int sum, List<Integer> list){
//        if(sum == target){
//            List<Integer> item = new ArrayList<>();
//            item.addAll(list);
//            res.add(item);
//        }else if(sum < target && index < len){
//            for(int i=index;i<len;i++){
//                int tmp = i;
//                sum += candinates[i];
//                i = i+1;
//                list.add(candinates[tmp]);
//                inner(i, len, sum, list);
//                sum -= tmp;
//                list.remove(candinates[tmp]);
//                i--;
//            }
//        }
//        
//    }
    private void dfs(int[] candidates, int len, int begin, int residue, Deque<Integer> path, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝
            if (residue - candidates[i] < 0) {
                break;
            }
    
            // 小剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
    
            path.addLast(candidates[i]);
    
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, residue - candidates[i], path, res);
    
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }
    
    public static void main(String[] args){
        int[] nums = new int[]{2,5,2,1,2};
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum2(nums, 5);
    }
}
