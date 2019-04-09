package xyz.frt.animal;

import java.util.ArrayList;
import java.util.List;

public class Map {

	private int length;
	private int width;
	private List<Animal> animals;

	public Map() {

	}

	public Map(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public Map(int length, int width, List<Animal> animals) {
		this.length = length;
		this.width = width;
		this.animals = animals;
	}

	/**
	 * 显示当前地图
	 */
	public void printOut() {
		for (int i = 0; i < this.length; i++) {
			for (int k = 0; k < this.width; k++) {
				int[] cur = { k, i };
				String animalStr = " ";
				for (Animal a : animals) {
					if (a.getPos().equals(cur)) {
						animalStr += a.getName();
						animalStr += " ";
					}
				}
				if (k == 0) {
					if (!animalStr.trim().equals("")) {
						System.out.print("|——————" + animalStr + "——————|");
					} else {
						System.out.print("|——————————————————|");
					}
				} else {
					System.out.print("——————————————————|");
				}
			}
			System.out.println();
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public static void main(String[] args) {
		Lion lion = new Lion(1, "狮子", "A", 100);
		List<Animal> list = new ArrayList<>();
		list.add(lion);
		Map map = new Map(5, 8, list);
		map.printOut();
	}
}
