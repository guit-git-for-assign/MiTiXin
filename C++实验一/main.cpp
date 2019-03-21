#include <iostream>
#include <conio.h>
#include <iomanip>
#include <string.h>
using namespace std;

//--------------------------------------------------------------------
struct ElemType              // 数据元素的类型
{
	int numb;
	char name[20];
	int tel;
};

const int MAXSIZE=3;     // 数组的容量

class Sqlist
{
private:
	ElemType  elem[MAXSIZE];
	int length;
    public:
		Sqlist(void);
		~Sqlist(){ };
		void  SetData();
		void  Insert( int i, ElemType e);
		ElemType Delet(int i);
		void PrintOut();
};
//-------------------------------------------------------------

Sqlist::Sqlist( ) { length=0;}

void  Sqlist::SetData( )     //初步建立一个通讯录
{
	cout<<"\n 输入人数length="<<endl;
	cin>>length;
    if(length<= MAXSIZE)
		for(int i=0;i<length;i++)
		{
			cout<<"\n 输入学号：";
			cin>>elem[i].numb;
			cout<<"\n 输入姓名：";
			cin>> elem[i].name;
			cout<<"\n 输入电话号：=";
			cin>>elem[i].tel;
		}
    else cout<<"\nlength is bigger than MAXSIZE";
}

void  Sqlist::Insert(int i, ElemType e) //请完成此函数
{
	if (length == MAXSIZE)
    {
        cout << "已加满";
    } else if (i < 1 || i > length+1)
    {
        cout << "插入位置出错";
    } else
    {
        for (int j = length; j >= i; j--)
        {
            elem[j] = elem[j-1];
        }
        elem[i-1] = e;
        length++;
    }
}

ElemType Sqlist::Delet(int i)
{
    ElemType x;
    if (i < 1 || i > length)
    {
        cout << "不在范围内aaaa";
        x.numb = -1;
        return x;
    }
    else
    {
        x = elem[i-1];
        elem[i-1] = elem[length-1];
        length--;
        return x;
    }


}

void Sqlist::PrintOut()  //输出
 {
	cout<<"\n 通讯录总人数："<<length;
	cout<<"\n PrintOut Data:\n";
	cout<<setw(16)<<"学号"<<setw(20)<<"姓名"<<setw(20)<<"电话号"<<endl;
	for(int k=0; k<length;k++)
	{
		cout<<setw(16)<<elem[k].numb<<setw(20)<<elem[k].name<<setw(20)<<elem[k].tel<<endl;
	}
 }

//--------------------------------------------------
int main( )
{
  int i,k;  ElemType e,x;
  Sqlist  as;
  cout<<"\n               通讯录演示";
  do{
      cout<<"\n\n";
      cout<<"\n\n    1. 初步建立一个通讯录（线性表） ";
      cout<<"\n\n    2. 插入一个数据元素 ";
      cout<<"\n\n    3. 删除一个元素，返回其值";
      cout<<"\n\n    4. 结束程序";
      cout<<"\n******************************** ";
      cout<<"\n    请输入你的选择(1,2,3,4)";  cin>>k;

	  switch(k)
	  {
        case 1: {  as.SetData(); as.PrintOut();  } break;

        case 2:
        {
            cout<<"\n 插入的位置， i=?"; cin>>i;
            cout<<"\n 插入的数据 编号=?"; cin>>e.numb;
            cout<<"\n 插入的数据 姓名=?"; cin>>e.name;
            cout<<"\n 插入的数据 电话号=?"; cin>>e.tel;
            as.Insert(i,e);  as.PrintOut();
        }break;

        case 3:
        {
            cout<<"\n 删除第几个元i=?";  cin>>i;
            x=as.Delet(i);
            if(x.numb!=-1)
            {
                cout<<"\n  被删除的元素数值= "<<setw(10)<<x.numb<< setw(10)<<x.name<<setw(10)<<x.tel;
                as.PrintOut();
            }
        }break;
        default:break;
	  } //switch
  }while(k>=1&&k<4);
        cout<<"\n          再见!";  cout<<"\n     按任意键，返回。";
        _getch(); return 0;
}//-----------------------------------------------
