package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class maxNumber {
	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2};
//		int[] numbers = {3, 30, 34, 5, 9};
		int[] numbers = {40, 403};

		System.out.println(solution(numbers));
	}

	/*
	[6, 10, 2]	"6210"
		6 10 2, 6 2 10
		10 6 2, 10 2 6
		2 6 10, 2 10 6
	[3, 30, 34, 5, 9]	"9534330" > 9 5 34 3 30
		9
		5
		3 30 34
	 */
	static List<String > values = new ArrayList<>();
	private static String solution(int[] numbers) {
		int[] rtn = new int[numbers.length];
		boolean[] visit = new boolean[numbers.length];

		permutation(numbers, rtn, visit, 0);
		return Collections.max(values);
	}

	// 경우의 수 - 순열
	private static void permutation(int[] numbers, int[] rtn, boolean[] visit, int depth) {
		if (depth == numbers.length) {
			values.add(Arrays.stream(rtn).mapToObj(String::valueOf).collect(Collectors.joining()));
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				rtn[depth] = numbers[i];
				permutation(numbers, rtn, visit, depth + 1);
				visit[i] = false;
			}
		}
	}
}