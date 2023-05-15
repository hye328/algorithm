package leetcode;

import java.util.Arrays;

public class TwoSum {
	public static void main(String[] args) {
//		int[] arr = {2,4,11,3};
//		int[] arr = {3,2,4};
//		int[] arr = {2,7,11,15};
		int[] arr = {2,5,5,11};

//		int tar = 6;
//		int tar = 6;
//		int tar = 9;
		int tar = 10;

		System.out.println(Arrays.toString(twoSum(arr, tar)));
	}

	private static int[] twoSum(int[] nums, int target) {
		int[] rtn = {};
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (i != j && nums[i] + nums[j] == target) {
					rtn = new int[]{i, j};
					break;
				}
			}
		}

		return rtn;
	}
}