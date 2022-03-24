package ch15.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample1 {

	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(Integer.valueOf(87), "홍길동");
		scores.put(Integer.valueOf(98), "이동수");
		scores.put(Integer.valueOf(75), "박길순");
		scores.put(Integer.valueOf(95), "신용권");
		scores.put(Integer.valueOf(80), "김자바");

		Map.Entry<Integer, String> entry = null;

		entry = scores.firstEntry();
		System.out.println("가장 낮은 점수: " + entry.getKey() + "-" + entry.getValue());

		entry = scores.lastEntry();
		System.out.println("가장 높은 점수: " + entry.getKey() + "-" + entry.getValue() + "\n");

		entry = scores.lowerEntry(Integer.valueOf(95));
		System.out.println("95점 아래 점수: " + entry.getKey() + "-" + entry.getValue());

		entry = scores.higherEntry(Integer.valueOf(95));
		System.out.println("95점 위의 점수: " + entry.getKey() + "-" + entry.getValue() + "\n");

		entry = scores.floorEntry(Integer.valueOf(95));
		System.out.println("95점 이거나 바로 아래 점수: " + entry.getKey() + "-" + entry.getValue());

		entry = scores.ceilingEntry(Integer.valueOf(85));
		System.out.println("85점 이거나 바로 위의 점수: " + entry.getKey() + "-" + entry.getValue() + "\n");

		while (!scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			System.out.println(entry.getKey() + "-" + entry.getValue() + "(남은 객체 수: " + scores.size() + ")");
		}
	}

}
