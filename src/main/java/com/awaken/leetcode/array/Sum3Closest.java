package com.awaken.leetcode.array;

import java.util.Arrays;

/**
* @description:    https://leetcode-cn.com/problems/3sum-closest/
* @author:         kirago
* @date:     2020/8/26 10:12 下午
* @updateRemark:   
* @version:        1.0
*/
public class Sum3Closest {
    public int threeSum(int[] nums,int target){
        int len = nums.length;
        int ans = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            int l=i+1,r=len-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(Math.abs(ans-target) > Math.abs(sum -target)){
                    ans = sum;
                }
                if(ans - target < 0){
                    l++;
                }else if(ans - target > 0){
                    r--;
                }else return ans;
            }
        }
        return ans;
    }
}
