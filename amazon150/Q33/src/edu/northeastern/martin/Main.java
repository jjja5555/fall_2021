package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(search(new int[]{4,5,6,7,0,1,2,3},0));
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
       while(left <= right){
           int mid = (left+right)/2;
           if(nums[mid] == target)return mid;
           //mid在左段还是右段
           if (nums[0] <= nums[mid]) {//左
               //target在左段，target 小于mid
               if (nums[0] <= target && target < nums[mid]) {
                   right = mid - 1;
               } else {
                   left = mid + 1;
               }
           } else {//右
               //target在右段，target大于mid
               if (nums[mid] < target && target < nums[0]) {
                   left = mid + 1;
               } else {
                   right = mid - 1;
               }
           }
       }
        return -1;
    }
}
