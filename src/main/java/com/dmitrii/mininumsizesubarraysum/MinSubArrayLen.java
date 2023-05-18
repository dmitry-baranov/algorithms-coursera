package com.dmitrii.mininumsizesubarraysum;

class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        quickSort(nums, 0, nums.length-1);
        int i = nums.length -1;
        int count = 0;
        while(i>=0 && target > 0){
            target = target - nums[i];
            count++;
            i--;
        }
        return target > 0 ? 0 : count;
    }

    public void quickSort(int[] array, int low, int high){
        if(low<high){
            int pi = partition(array, low, high);
            quickSort(array, low, pi -1);
            quickSort(array, pi + 1, high);
        }
    }
    public int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low - 1;
        for(int j = low; j<=high-1; j++){
            if(array[j] < pivot){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, high);
        return i+1;
    }
    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}