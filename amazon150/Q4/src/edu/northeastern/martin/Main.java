package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenOne = nums1.length;
        int lenTwo = nums2.length;
        int [] arr = new int[lenOne+lenTwo];
        int indexOne = 0, indexTwo = 0;
        for(int i = 0;i < arr.length;i++){
            if(indexOne < lenOne && indexTwo < lenTwo){
                int one = nums1[indexOne];
                int two = nums2[indexTwo];
                if(one < two){
                    arr[i] = one;
                    indexOne++;
                }else{
                    arr[i] = two;
                    indexTwo++;
                }
            }else{
                if(indexOne < lenOne){
                    arr[i] = nums1[indexOne];
                    indexOne++;
                }else{
                    arr[i] = nums2[indexTwo];
                    indexTwo++;
                }
            }
        }
        int size = arr.length;
        if(arr.length %2 == 0){
            return (arr[(size-1)/2]+arr[(size-1)/2+1])/2.0;
        }else{
            return arr[(size-1)/2];
        }
    }

    public static double findMedianSortedArraysEF(int[] nums1, int[] nums2) {
        //如果nums长度大于nums2，两边换一下
        if(nums1.length > nums2.length){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        //两个arr 整体左边的数量
        int totalLeft = (m+n+1)/2;
        int i;
        for (i = 0; i < m; i++) {
            int j = totalLeft - i;
            if(nums2[j-1] > nums1[i]){
                continue;
            }else{
                break;
            }
        }
        int j = totalLeft -i;

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if((m+n) % 2 == 1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        }else {
            return (Math.max(nums1LeftMax,nums2LeftMax) +Math.min(nums1RightMin,nums2RightMin))/2.0;
        }

    }


}
