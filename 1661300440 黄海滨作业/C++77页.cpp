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
		cout<<"ͨѶ¼����"<<endl;
	else if(i<1 || i>length+1)
		cout<<"�Ƿ�����λ��"<<endl;
	else{
		for (int j=length;j>=1;j--)
       		 	strs[j]=strs[j-1];
		strs[i-1]=s;
		length++;
	   	cout<<"����ɹ�"<<endl;
	}
}
void Sqlist::Delet(int i)
{   

	if(i<1 || i>length){
		cout<<"�Ƿ�ɾ��λ��"<<endl;
	}
	else{
	
		for (int j =i;j<length;j++){
			strs[j-1]=strs[j];
		}
		length--;
		cout<<"ɾ���ɹ�"<<endl;
	}
}
void Sqlist::PrintOut()
 { 
	cout<<"\n Ԫ�ظ�����"<<length<<endl;
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
	cout<<"-----����ѡ��-------"<<endl��
	cout<<"-----1.���루�½���Ԫ��-------"<<endl��
	cout<<"-----2.ɾ��Ԫ��-------"<<endl��
	cin>>temp;
		switch(temp)
		{
			case 1:
				cout<<"-----��������λ��-------"<<endl��
				cin>>pos;
				cout<<"-----������������-------"<<endl��
				cin>>body;
				s.Insert(pos,body);
				s.PrintOut();
			break;
			case 2:
				cout<<"-----����ɾ����λ��-------"<<endl��
				cin>>pos;
				s.Delet(pos);
				s.PrintOut();
			break;
		}
	}
	
}  