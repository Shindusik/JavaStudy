package ch09.ex06;

public class Chtting {
	void startChat(String chatId) {
		// 로컬 클래스에서 사용된 매개변수와 로컬변수는 모두 final 특성을 갖는다.
//		String nickName = null;
//		nickName = chatId;
		String nickName = chatId;
		Chat chat = new Chat() {
			@Override
			void start() {
				while (true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "] " + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}

	class Chat {
		void start() {

		}

		void sendMessage(String message) {

		}
	}
}
