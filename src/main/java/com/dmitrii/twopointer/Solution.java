package com.dmitrii.twopointer;

class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        for(int i = 0; i< end; i++){
            switch (nums[i]){
                case 0:{
                    nums[i] = nums[start];
                    nums[start] = 0;
                    start++;
                }
                case 2:{
                    nums[i] = nums[end];
                    nums[end] = 2;
                    i--;
                    end--;
                }
                default:
            }
        }
    }
}