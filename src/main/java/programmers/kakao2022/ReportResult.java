package programmers.kakao2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportResult {
	public static void main(String[] args) {
//		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;

		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

	/*
	각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
	신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
	한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
	k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
	유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
	다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.

	{"muzi", "frodo", "apeach", "neo"}, {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2 > [2,1,1,0]
		muzi > frodo, neo
		frodo > neo
		apeach > frodo, muzi
		neo >
	["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3 > [0,0]
	 */
	private static int[] solution(String[] id_list, String[] report, int k) {
		Map<String, Set<String>> reportCollect = new HashMap<>();
		Arrays.stream(report).forEach(str -> {
			String[] strings = str.split(" ");
			if (reportCollect.containsKey(strings[0])) {
				Set<String> list = new HashSet<>(reportCollect.get(strings[0]));
				list.add(strings[1]);
				reportCollect.replace(strings[0], list);
			} else {
				reportCollect.put(strings[0], new HashSet<>(Arrays.asList(strings[1])));
			}
		});

		// k번 신고당한 id 찾기
		List<String> reportId = Arrays.stream(id_list)
				.filter(str -> reportCollect.values().stream().filter(s -> s.contains(str)).count() >= k)
				.collect(Collectors.toList());

		// return int array
		return Arrays.stream(id_list)
				.mapToInt(str -> reportCollect.containsKey(str) ?
						(int) reportCollect.get(str).stream().filter(reportId::contains).count() : 0)
				.toArray();
	}
}