package programmers.queue_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class number {
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
//		int[] arr = {4,4,4,3,3};

		System.out.println(Arrays.toString(solution(arr)));
	}

	/*
	[1,1,3,3,0,1,1] > [1,3,0,1]
	[4,4,4,3,3] > [4,3]
	 */
	private static int[] solution(int[] arr) {
		List<Integer> answer = new ArrayList<>();
		answer.add(arr[0]);

		for (int i=1; i < arr.length; i++) {
			if (arr[i-1] != arr[i]) {
				answer.add(arr[i]);
			}
		}

		return answer.stream().mapToInt(Integer::valueOf).toArray();
	}
}