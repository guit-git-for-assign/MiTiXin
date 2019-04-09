import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sales {
	List<Product> products =new ArrayList<>();
	void AddProduct(Product p)//�ۻ���������Ʒ
	{
		if(GetPId_byPname(p.Pname)==-1)
		products.add(p);
		else
		products.get(GetPId_byPname(p.Pname)).Pnumber+=p.Pnumber;
	}
	
	void SalesProduct(String name, float money)//�ۻ���������Ʒ
	{
		int temp=GetPId_byPname(name);
		if(temp==-1)
		{
			System.out.println("\nû�������Ʒ��");
			return;
		}
		else if(products.get(temp).Pnumber>0)
		{
			if(money>=products.get(temp).Pprice)
			{
				products.get(temp).Pnumber--;
				System.out.println("�۳�'"+products.get(temp).Pname+"'һ"+products.get(temp).Punit);
				System.out.println("����  "+(money-products.get(temp).Pprice)+"Ԫ");
				return;
			}
			System.out.println("Ͷ�ҽ��㣬���˱ң�������Ͷ��");
		}
		else 
		{
			System.out.println("��Ʒ��治�㣡��");
		}
	}
	
	
	void printf_message()
	{
		for (int i = 0;i < products.size(); i++) {
			System.out.println("��Ʒ����        ��Ʒ�۸�    ʣ������    ��λ");
			System.out.println(products.get(i).Pname+"       "+products.get(i).Pprice+"    "+products.get(i).Pnumber+"    "+products.get(i).Punit);
		}
		
	}
	
	int GetPId_byPname(String name)//��ȡ��Ʒ��List����±꣬�����������ѵ�
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
		Cola cola=new Cola("�ɿڿ���", 2.5f, 1, "��");
		Cola cola1=new Cola("�ɿڿ���", 2.5f, 1, "��");
		Cola cola2=new Cola("�ɿڿ���", 2.5f, 100, "��");
		Cola cola3=new Cola("�ɿڿ���", 2.5f, 100, "��");
//		Sweet sweet =new Sweet("������", 0.5f,100, "��");
//		Crisps crisp=new Crisps("�ɱȿ���Ƭ", 5f, 100, "��");
		s1.AddProduct(cola);
		s1.AddProduct(cola1);
		s1.AddProduct(cola2);
		s1.AddProduct(cola3);
		while (true) {
			float money;
			String name;
			s1.printf_message();
			System.out.println("��������Ҫ�������Ʒ����:");
			Scanner scanner=new Scanner(System.in);
			name=scanner.nextLine();
			scanner=new Scanner(System.in);
			System.out.println("������Ͷ�ҽ��:");
			money=scanner.nextFloat();
			System.out.println("������Ͷ�ҽ��:");
			s1.SalesProduct(name,money);
			
			
			scanner=new Scanner(System.in);
			System.out.println("�س�����");
			scanner.nextLine();
		}

		
		
	}

}
