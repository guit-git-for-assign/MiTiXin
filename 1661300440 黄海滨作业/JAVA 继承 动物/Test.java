package T;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test {

	void AnimalMove(List<Animal> Animals)
	{
		Random random= new Random();
		for (int i = 0; i < Animals.size(); i++) {
			if(Animals.get(i).life==false)continue;
			Animals.get(i).Move(random.nextInt(4));
		}
	}
	
	void AnimalEat(List<Animal> Animals)
	{
		List<Animal> AnimalsTemp =new ArrayList<Animal>();
		
		for (int i = 0; i < Animals.size(); i++) {
			if(!Animals.get(i).life)continue;
			for (int j = i+1; j <  Animals.size(); j++) {
				if(!Animals.get(j).life)continue;
				if(Animals.get(i).Now_X == Animals.get(j).Now_X && Animals.get(i).Now_Y == Animals.get(j).Now_Y)
				{
					AnimalsTemp.add(Animals.get(i));
					AnimalsTemp.add(Animals.get(j));
				}
				
			}
		}
		
		HashSet hashSet=new HashSet(AnimalsTemp);
		AnimalsTemp.clear();
		AnimalsTemp.addAll(hashSet);
		

		for (int i = 0; i < AnimalsTemp.size(); i++) {
			if(i==AnimalsTemp.size()-1)break;
			if(i+1<AnimalsTemp.size())
			{
				if(AnimalsTemp.get(i).Lv > AnimalsTemp.get(i+1).Lv)
				{
					System.out.println(AnimalsTemp.get(i+1).AnimalName+" 被 "+AnimalsTemp.get(i).AnimalName+" 吃掉了");
					Animals.get(Animals.indexOf((AnimalsTemp.get(i+1)))).life=false;
				}
				else
				{
					System.out.println(AnimalsTemp.get(i).AnimalName+" 被 "+AnimalsTemp.get(i+1).AnimalName+" 吃掉了");
					Animals.get(Animals.indexOf((AnimalsTemp.get(i)))).life=false;
				}
			}
			
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Animal> Animals =new ArrayList<Animal>();
//		Animal lion=new Lion("狮子",3,0);
//		Animal wolf=new Wolf("狼",2,0);
//		Animal Rabbit=new Lion("兔子",1,0);
		Animal lion=new Lion("狮子",3);
		Animal wolf=new Wolf("狼",2);
		Animal Rabbit=new Lion("兔子",1);
		Animals.add(lion);
		Animals.add(wolf);
		Animals.add(Rabbit);
		Test test =new Test();
		
		while (true) {
			int count=0;
			test.AnimalMove(Animals);
			test.AnimalEat(Animals);
			for (int i = 0; i < Animals.size(); i++) 
				if(Animals.get(i).life)count++;
			if(count==1)
			{
				System.out.println("只剩下一只动物，程序结束");
				break;
			}
				
			try {Thread.sleep(1*1000);} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println("---------------------------------------------");
		}
		
		
		
	}

}
