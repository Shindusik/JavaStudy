package ch11;

import java.util.Map;
import java.util.Set;

public class SystemEnvExample {

	public static void main(String[] args) {
//		String javaHome = System.getenv("JAVA_HOME");
//		System.out.println("JAVA_HOME: " + javaHome);

		Map<String, String> map = System.getenv();
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + System.getenv(key));
		}
	}

}
