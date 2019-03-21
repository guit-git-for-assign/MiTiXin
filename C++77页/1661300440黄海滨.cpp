#include <iostream>
#include <string>
using namespace std;


class Sqlist
{
    private:
	int length=0;
	const int MAXSIZE=3;
	string strs[3];
    public:
	void Insert( int i, string s) ;
	void Delet(int i);
	void PrintOut() ;
	
	
};

void  Sqlist::Insert( int i, string s) 
{  
	if(length==MAXSIZE)
		cout<<"通讯录已满"<<endl;
	else if(i<1 || i>length+1)
		cout<<"非法插入位置"<<endl;
	else{
		for (int j=length;j>=1;j--)
       		 	strs[j]=strs[j-1];
		strs[i-1]=s;
		length++;
	   	cout<<"插入成功"<<endl;
	}
}
void Sqlist::Delet(int i)
{   

	if(i<1 || i>length){
		cout<<"非法删除位置"<<endl;
	}
	else{
	
		for (int j =i;j<length;j++){
			strs[j-1]=strs[j];
		}
		length--;
		cout<<"删除成功"<<endl;
	}
}
void Sqlist::PrintOut()
 { 
	cout<<"\n 元素个数："<<length<<endl;
	for(int k=0; k<length;k++)      
	{ 
		cout<<k<<setw(16)<<strs[k]<<endl;
	}
 }
int main( )
{
	int temp,pos=0;
	string body;
	Sqlist s;
	while(true)
	{
	cout<<"-----功能选择-------"<<endl；
	cout<<"-----1.插入（新建）元素-------"<<endl；
	cout<<"-----2.删除元素-------"<<endl；
	cin>>temp;
		switch(temp)
		{
			case 1:
				cout<<"-----输入插入的位置-------"<<endl；
				cin>>pos;
				cout<<"-----输入插入的内容-------"<<endl；
				cin>>body;
				s.Insert(pos,body);
				s.PrintOut();
			break;
			case 2:
				cout<<"-----输入删除的位置-------"<<endl；
				cin>>pos;
				s.Delet(pos);
				s.PrintOut();
			break;
		}
	}
	
}  