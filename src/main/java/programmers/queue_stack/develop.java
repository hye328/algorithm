package programmers.queue_stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class develop {
	public static void main(String[] args) {
//		int[] progresses = {99, 99, 99};
//		int[] speeds = {1, 1, 1};
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1, 30, 5};
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};

		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	/*
	[93, 30, 55], [1, 30, 5] > [2, 1]
		7, 3, 9 ((100-p)/s)
	[95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1] > [1, 3, 2]
		5, 10, 1, 1, 20, 1
	 */
	// todo queue and stack !!!
	private static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> needs = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		IntStream.range(0, progresses.length)
				.forEach(i -> needs.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i])));

		int days = 1;
		int n = needs.get(0);
		for (int i = 1; i < needs.size(); i++) {
			int u = needs.get(i);

			if (n < u) {
				answer.add(days);
				days = 0;
				n = u;
			}
			days++;
		}
		answer.add(days);

		return answer.stream().mapToInt(Integer::valueOf).toArray();
	}
}