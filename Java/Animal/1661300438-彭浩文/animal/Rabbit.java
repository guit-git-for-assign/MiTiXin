package xyz.frt.animal;

public class Rabbit extends Animal {

	public Rabbit() {
		
	}
	
	public Rabbit(int level, String type, String name, int health) {
		super(level, type, name, health);
	}
	
	@Override
	public void attack(Animal animal) {
		if (animal.getHealth() > 0) {
			animal.setHealth(animal.getHealth() - 3);
			String log = this.getName() + "[" + this.getType() + "]攻击了" + animal.getName() + ", 还剩" + animal.getHealth() + "点血;";
			System.out.println(log);
		}
	}

}
