package com.leetcode.oneDayoneProblem;

/**
 * @className: searchInsert
 * @description: TODO 类描述
 * @date: 2023/1/12
 **/
public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0 ;
        while (low <= high){
            mid = low + (high - low)/2;
            if (nums[mid] > target){
                high = mid - 1;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return mid-1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(new searchInsert().searchInsert(nums,2));;
    }
}
