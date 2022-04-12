package ch17;

import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain2 extends Application {
	public AppMain2() {
		System.out.println(Thread.currentThread().getName() + ": AppMain2() 호출");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": init() 호출");
		Parameters params = getParameters();
		List<String> list = params.getRaw();
//		list.forEach(a->System.out.println(a));
		list.forEach(System.out::println);
		Map<String, String> map = params.getNamed();
	}

	@Override
	public void start(Stage primaryStage) {
		System.out.println(Thread.currentThread().getName() + ": start() 호출");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": stop() 호출");
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + ": main() 호출");
		launch(args);
	}
}
