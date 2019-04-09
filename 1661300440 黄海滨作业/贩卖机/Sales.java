import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sales {
	List<Product> products =new ArrayList<>();
	void AddProduct(Product p)//售货机增加商品
	{
		if(GetPId_byPname(p.Pname)==-1)
		products.add(p);
		else
		products.get(GetPId_byPname(p.Pname)).Pnumber+=p.Pnumber;
	}
	
	void SalesProduct(String name, float money)//售货机销售商品
	{
		int temp=GetPId_byPname(name);
		if(temp==-1)
		{
			System.out.println("\n没有这个商品！");
			return;
		}
		else if(products.get(temp).Pnumber>0)
		{
			if(money>=products.get(temp).Pprice)
			{
				products.get(temp).Pnumber--;
				System.out.println("售出'"+products.get(temp).Pname+"'一"+products.get(temp).Punit);
				System.out.println("找零  "+(money-products.get(temp).Pprice)+"元");
				return;
			}
			System.out.println("投币金额不足，已退币，请重新投币");
		}
		else 
		{
			System.out.println("商品库存不足！！");
		}
	}
	
	
	void printf_message()
	{
		for (int i = 0;i < products.size(); i++) {
			System.out.println("商品名称        商品价格    剩余数量    单位");
			System.out.println(products.get(i).Pname+"       "+products.get(i).Pprice+"    "+products.get(i).Pnumber+"    "+products.get(i).Punit);
		}
		
	}
	
	int GetPId_byPname(String name)//获取商品在List里的下标，用于做数量堆叠
	{
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).Pname.equals(name))
			{
				
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Sales s1=new Sales();
		Cola cola=new Cola("可口可乐", 2.5f, 1, "罐");
		Cola cola1=new Cola("可口可乐", 2.5f, 1, "罐");
		Cola cola2=new Cola("可口可乐", 2.5f, 100, "罐");
		Cola cola3=new Cola("可口可乐", 2.5f, 100, "罐");
//		Sweet sweet =new Sweet("棒棒糖", 0.5f,100, "根");
//		Crisps crisp=new Crisps("可比克薯片", 5f, 100, "包");
		s1.AddProduct(cola);
		s1.AddProduct(cola1);
		s1.AddProduct(cola2);
		s1.AddProduct(cola3);
		while (true) {
			float money;
			String name;
			s1.printf_message();
			System.out.println("请输入需要购买的商品名称:");
			Scanner scanner=new Scanner(System.in);
			name=scanner.nextLine();
			scanner=new Scanner(System.in);
			System.out.println("请输入投币金额:");
			money=scanner.nextFloat();
			System.out.println("请输入投币金额:");
			s1.SalesProduct(name,money);
			
			
			scanner=new Scanner(System.in);
			System.out.println("回车继续");
			scanner.nextLine();
		}

		
		
	}

}
