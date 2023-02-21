package programmers.queue_stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class print {
	public static void main(String[] args) {
		int[] p = {2, 1, 3, 2};
		int r = 2;

		System.out.println(Arrays.toString(solution(p, r)));
	}

	/*
	[중요도], 대기목록 위치 > 인쇄 요청한 문서가 몇 번째로 인쇄되는지
	[2, 1, 3, 2], 2 > 1
	c d a b
	[1, 1, 9, 1, 1, 1], 0 > 5
	c d e f a b
	 */
	private static int[] solution(int[] priorities, int location) {
		List<Integer> integerList = Arrays.stream(priorities).boxed().collect(Collectors.toList());
		List<Integer> sorted = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		Queue queue = new LinkedList();
		

		return null;
	}
}