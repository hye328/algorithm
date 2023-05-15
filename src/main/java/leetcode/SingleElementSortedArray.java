package leetcode;

public class SingleElementSortedArray {
	public static void main(String[] args) {
//		int[] arr = {3,3,7,7,10,11,11};
//		int[] arr = {1};
		int[] arr = {1,1,2};
//		int[] arr = {1,1,2,3,3,4,4,8,8};

		System.out.println(singleNonDuplicate(arr));
	}

	private static int singleNonDuplicate(int[] nums) {
		int rtn = 0;

		if (nums.length == 1) {
			return nums[0];
		}

		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length-1) {
				rtn = nums[nums.length-1];
				break;
			}
			if (nums[i] == nums[i+1]) {
				i++;
				continue;
			}
			rtn = nums[i];
		}

		return rtn;
	}

//	private static int singleNonDuplicate(int[] nums) {
//		Map<Integer, Integer> map = new HashMap<>();
//		Arrays.stream(nums).forEach(i -> {
//			if (map.containsKey(i)) {
//				map.remove(i);
//			} else {
//				map.put(i, 0);
//			}
//		});
//
//		return map.keySet().stream().findFirst().orElse(0);
//	}
}