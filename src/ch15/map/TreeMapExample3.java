package ch15.map;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapExample3 {

	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		treeMap.put("apple", Integer.valueOf(10));
		treeMap.put("forever", Integer.valueOf(60));
		treeMap.put("description", Integer.valueOf(40));
		treeMap.put("ever", Integer.valueOf(50));
		treeMap.put("zoo", Integer.valueOf(10));
		treeMap.put("base", Integer.valueOf(20));
		treeMap.put("guess", Integer.valueOf(70));
		treeMap.put("cherry", Integer.valueOf(30));
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "f", true);
		for (Map.Entry<String, Integer> entry : rangeMap.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue() + "페이지");
		}
	}

}
