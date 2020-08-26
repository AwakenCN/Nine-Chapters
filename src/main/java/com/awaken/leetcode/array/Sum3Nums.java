package com.awaken.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @Description:    java类作用描述,https://leetcode-cn.com/problems/3sum/
* @Author:         kirago
* @CreateDate:     2020/8/26 9:54 下午
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Sum3Nums {
    
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum=0,length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]>0) return res;
            if(i>0 && nums[i-1] == nums[i]) continue;
            int left=i+1,right=length-1;
            while (left<right){
                sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(list);
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right-1] == nums[right]) right--;
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
    
    
}
