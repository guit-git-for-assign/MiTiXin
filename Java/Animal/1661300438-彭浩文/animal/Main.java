package xyz.frt.animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// 生成动物
		Lion lion = new Lion(5, "狮子", "Anan", 20);
		Wolf wolf = new Wolf(4, "浪", "Wooo", 15);
		Rabbit rab = new Rabbit(1, "兔子", "Rad", 10);

		List<Animal> list = new ArrayList<>();
		list.add(lion);
		list.add(wolf);
		list.add(rab);

		// 生成地图
		Map map = new Map(3, 3, list);

		Random radom = new Random();

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				for (Animal a : list) {
					a.move(map, radom.nextInt(3));
					// map.printOut();
					if (list.size() == 1) {
						System.exit(0);
					}
				}
				System.out.println("------------------------");
			}
		};

		timer.schedule(task, 0, 2000);
		/*
		while(true) {
			for (Animal a : list) {
				a.move(map, radom.nextInt(3));
				// map.printOut();
				if (list.size() == 1) {
					System.exit(0);
				}
			}
			System.out.println("------------------------");
			Thread.sleep(1000);
		}
*/
	}

}
