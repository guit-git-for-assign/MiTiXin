package T;

import java.util.Random;

public class Animal {
	protected String AnimalName;
	protected int Lv;
	protected int Now_X;
	protected int Now_Y;
	protected int MaxX=2;
	protected int MaxY=2;
	public boolean life=true;
	Random random= new Random();
	public Animal(String AnimalNmae,int Lv) {
		this.AnimalName=AnimalNmae;
		this.Lv=Lv;
		Now_X=random.nextInt(MaxX-1);
		Now_Y=random.nextInt(MaxY-1);
	}
	
	public Animal(String AnimalNmae,int Lv,int t) {
		this.AnimalName=AnimalNmae;
		this.Lv=Lv;
		Now_X=0;
		Now_Y=0;
	}
	
	public void Move(int direction){
		switch (direction) {
		case 0://上
				if(Now_Y<MaxY-1)
					Now_Y++;
			break;

		case 1://下
				if(Now_Y>0)
					Now_Y--;
			break;
			
		case 2://左
				if(Now_X>0)
					Now_X--;
			break;
			
		case 3://右
				if(Now_X<MaxX-1)
					Now_X++;
			break;
		}
		
		System.out.println(AnimalName+"(当前坐标):["+Now_X+","+Now_Y+"]");
	}
	

}
