package xyz.frt.animal;

public class Wolf extends Animal {

	public Wolf() {
		
	}
	
	public Wolf(int level, String type, String name, int health) {
		super(level, type, name, health);
	}
	
	@Override
	public void attack(Animal animal) {
		if (animal.getHealth() > 0) {
			animal.setHealth(animal.getHealth() - 8);
			String log = this.getName() + "[" + this.getType() + "]攻击了" + animal.getName() + ", 还剩" + animal.getHealth() + "点血;";
			System.out.println(log);
		}
	}

}
