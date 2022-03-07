package ch11;

import java.io.IOException;

public class KeyboardToStringExample {

	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];
		
		System.out.print("입력: ");
		// 배열에 읽은 바이트를 저장하고 읽은 바이트수를 리턴
		int readByteNo = System.in.read(bytes);
		
		// 캐리지리턴 + 라인피드 2개를 빼줘야 함.
		String str = new String(bytes, 0, readByteNo - 2);
		System.out.println(str + "(읽은 바이트 수: " + readByteNo + ")");
	}

}
