package xyz.frt.animal;

import java.util.Arrays;
import java.util.List;

public abstract class Animal {

	private int level; // 食物链等级
	private String type; // 动物类型
	private String name; // 动物别名
	private int health; // 动物生命值
	private int[] pos = { 0, 0 };// 当前位置

	public Animal() {

	}

	public Animal(int level, String type, String name, int health) {
		this.level = level;
		this.type = type;
		this.name = name;
		this.health = health;
	}

	/**
	 * 攻击
	 * 
	 * @param animal 被攻击的动物 削减生命值
	 */
	public abstract void attack(Animal animal);

	/**
	 * 随机移动
	 * 
	 * @param map
	 * @param pos 0,东 1,南 2,西 3,北
	 */
	public void move(Map map, int pos) {
		// 获取随机移动方向
		String posStr = "";
		switch (pos) {
		case 0:
			posStr = "东";
			if (this.pos[0] == map.getWidth()) {
				this.pos[0] = 0;
			} else {
				this.pos[0]++;
			}
			break;
		case 1:
			posStr = "南";
			if (this.pos[1] == 0) {
				this.pos[1] = map.getLength();
			} else {
				this.pos[1]--;
			}
			break;
		case 2:
			posStr = "西";
			if (this.pos[0] == 0) {
				this.pos[0] = map.getWidth();
			} else {
				this.pos[0]--;
			}
			break;
		case 3:
			posStr = "北";
			if (this.pos[1] == map.getLength()) {
				this.pos[1] = 0;
			} else {
				this.pos[1]++;
			}
			break;
		default:
			System.err.println("未知方向");
			break;
		}
		System.out.println(this.name + "[" + this.type + "]向" + posStr + "方向移动了1格，当前位置为[" + this.pos[0] + ", " + this.pos[1] + "]...");
		//判断是否触发攻击
		List<Animal> list = map.getAnimals();
		for (int i = 0; i < list.size(); i++) {
			Animal a = list.get(i);
			if (a.getName() != this.name) {
				if (Arrays.equals(a.getPos(), this.pos)) {
					if (a.getLevel() > this.level) {
						a.attack(this);
						if (this.health <= 0) {
							list.remove(this);
							System.out.println(this.name + "[" + this.type + "]已被杀死！");
						}
					} else {
						this.attack(a);
						if (a.health <= 0) {
							list.remove(a);
							System.out.println(a.name + "[" + a.type + "]已被杀死！");
						}
					}
				}
			}
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setPos(int[] pos) {
		this.pos = pos;
	}
	
	public int[] getPos() {
		return pos;
	}

}
