package ch11.ex08;

import java.util.StringTokenizer;

public class SplitExample {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";

		// 방법1 (split() 메소드 이용)
		String[] tokens = str.split(",");
		for (String value : tokens) {
			System.out.println(value);
		}
		System.out.println();

		// 방법2 (StringTokenizer 이용)
		StringTokenizer st = new StringTokenizer(str, ",");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
