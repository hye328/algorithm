package leetcode;

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] arr = {1,3};
		int tar = 3;

		System.out.println(searchInsert(arr, tar));
	}

	private static int searchInsert(int[] nums, int target) {
		int rtn = nums.length;

		if (nums[0] >= target) {
			return 0;
		}

		if (nums[rtn-1] < target) {
			return rtn;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				rtn = i;
				break;
			}
		}

		return rtn;
	}
}