package ch11;

public class NewInstanceExample {

	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("ch11.SendAction");
			Class clazz1 = Class.forName("ch11.ReceiveAction");
			Action action = (Action) clazz.newInstance();
			action.execute();
			Action action1 = (Action) clazz1.newInstance();
			action1.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
