package com.awaken.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Kirago
 * @date 2020/9/11 9:02
 * @description https://leetcode-cn.com/problems/combination-sum-iii/ 
 * @version version-1.0
 */


public class CombinationSum3 {
    private Queue<Integer> queue = new ArrayDeque<>();

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n<0) return null;
        inner(1, k, n);
        return res;
    }
    
    private void inner(int index ,int nums, int reduction){

        if(reduction < 0 || nums < 0) return;
        if( reduction == 0 && nums == 0 ){
            res.add(new ArrayList<>(queue));
            return;
        }
        for(int i=index;i<10;i++){
            queue.add(i);
            inner(++index, nums-1, reduction-i);
            queue.remove(i);
        }
    }
    
    public static void main(String[] args){
        CombinationSum3 combinationSum3 = new CombinationSum3();
        combinationSum3.combinationSum3(3,7);
    }
}
