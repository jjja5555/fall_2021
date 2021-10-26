package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        merge(nums1,2,nums2,3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null || n == 0){

        }
        if(nums2[0] >= nums1[m-1]){
            for (int i = 0; i < n; i++) {
                nums1[m+i] = nums2[i];
            }
        }

        int p1 = m-1;
        int p2 = n-1;
        int tail = m+n-1;
        int temp;
        while(p1 >= 0 || p2 >= 0){
            if(p1 == -1){
                temp = nums2[p2--];
            }else if(p2 == -1){
                temp = nums1[p1--];
            }else if(nums1[p1] > nums2[p2]){
                temp = nums1[p1--];
            }else{
                temp = nums2[p2--];
            }
            nums1[tail--] = temp;
        }


    }
}
