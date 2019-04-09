#include <iostream.h>
#include <conio.h>
#include <iomanip.h>
#include <string.h>
//--------------------------------------------------------------------
struct ElemType              // 数据元素的类型
{ 
	int numb;
};

const int MAXSIZE=50;     // 数组的容量

class Sqlist
{
private:
	ElemType  elem[MAXSIZE];
	int length;
    public:
		Sqlist( void);
		~Sqlist(){ };
		void  SetData();
		void  Insert(ElemType e);
		void  Remove();
		ElemType Delet(ElemType e);
		void PrintOut();
};
//-------------------------------------------------------------
Sqlist::Sqlist( ) { length=0;}
void  Sqlist::SetData( )     //初步建立一个通讯录 
{
cout<<"\n 输入个数length="<<endl;
	cin>>length;
    if(length<= MAXSIZE)
		for(int i=0;i<length;i++)
		{ 
			cout<<"\n 输入数值";  
			cin>>elem[i].numb;
		}
    else cout<<"\n length is bigger than MAXSIZE";
	Remove();

}

void Sqlist::Remove()
{
	for(int x=0;x<length;x++)
		for(int y=x+1;y<length;y++)
			if(elem[x].numb>elem[y].numb)
			{
				int b=elem[x].numb;
				elem[x].numb=elem[y].numb;
				elem[y].numb=b;
			}

}

void  Sqlist::Insert( ElemType e) //请完成此函数
{
	
	int i=0;
	if(length==MAXSIZE)
	{
		cout << "OVER_FLOW"<<endl;
	}
	else{
		elem[length]=e;
		length++;
			}
	
Remove();
}
ElemType Sqlist::Delet(ElemType e)
{
	int i=0,j;
	while (i <= length-1&&elem[i].numb < e.numb )
		i++;
	if(i<=length-1&&elem[i].numb==e.numb)
	{
		j=i+1;
		while(j<=length -1&& elem[j].numb==e.numb)
			j++;
		while(j<=length)
		{
			elem[i++]=elem[j++];
		}
		length=length+i-j;        
	}
	return e;
	
}
void Sqlist::PrintOut()  //输出
 { 
	cout<<"\n 数值的总数为"<<length;
	cout<<"\n PrintOut Data:\n";
	cout<<setw(16)<<"学号"<<endl;
	for(int k=0; k<length;k++)      
	{ 
		cout<<setw(16)<<elem[k].numb<<endl;
	}
 }
//--------------------------------------------------
int main( )
{ int i,k;  ElemType e,x;
  Sqlist  as;
  cout<<"\n********************************";
  do{
      cout<<"\n\n";
      cout<<"\n\n    1. 初步建立一个线性表 ";
      cout<<"\n\n    2. 插入一个数据元素 ";
      cout<<"\n\n    3. 删除一个元素，返回其值";
      cout<<"\n\n    4. 结束程序";
      cout<<"\n******************************** ";
      cout<<"\n    请输入你的选择(1,2,3,4)";  cin>>k;
	  switch(k)
	  { 
	  case 1:
		  {  as.SetData(); as.PrintOut();  }break;
	  case 2:{   cout<<"\n 插入的数据=?"; cin>>e.numb;
                   as.Insert(e);  as.PrintOut();
                 }break;
	  case 3:{ cout<<"\n 删除的值为=?";  cin>>e.numb;
                  x=as.Delet(e);
                  if(x.numb!=-1)
                  {	
cout<<"\n  被删除的元素数值= "<<setw(10)<<x.numb;
                      as.PrintOut();
}
                 }break;
	  default:break;
	  } //switch
  }while(k>=1&&k<4);
  cout<<"\n          再见!";  cout<<"\n     按任意键，返回。";
  _getch(); return 0;
}
