#include <iostream.h>
#include <conio.h>
#include <iomanip.h>
#include <string.h>
//--------------------------------------------------------------------
struct ElemType              // ����Ԫ�ص�����
{ 
	int numb;
	char name[20];
	int tel;
};

const int MAXSIZE=2;     // ���������

class Sqlist
{
private:
	ElemType  elem[MAXSIZE];
	int length;
    public:
		Sqlist( void);
		~Sqlist(){ };
		void  SetData();
		 void Insert( int i, ElemType e);
		ElemType Delet(int i);
		void PrintOut();
};


Sqlist::Sqlist( ) { length=0;}
void  Sqlist::SetData( )     //��������һ��ͨѶ¼ 
{
	cout<<"\n ��������length="<<endl;
	cin>>length;
    if(length<= MAXSIZE)
		for(int i=0;i<length;i++)
		{ 
			cout<<"\n ����ѧ�ţ�";  
			cin>>elem[i].numb;
			cout<<"\n ����������"; 
			cin>> elem[i].name;
			cout<<"\n ����绰�ţ�="; 
			cin>>elem[i].tel;
		}
    else cout<<"\nlength is bigger than MAXSIZE";
}
void Sqlist::Insert( int i, ElemType e) //����ɴ˺���
{
	//�������1
	if(i==MAXSIZE-1)
		cout<<"˳�������";
	 else if(i<1||i>length+1)
		  cout<<"Ҫ�����λ�ô���";
	     
	 else {
		 for(int j=length;j>=i;j--){
			 elem[j].numb=elem[j-1].numb;
		     strcpy(elem[j].name,elem[j-1].name);
			 elem[j].tel=elem[j-1].tel;}
		elem[i-1].numb=e.numb;
		strcpy(elem[i-1].name,e.name);
		elem[i-1].tel=e.tel;
		length++;
		cout<<"success";
	 }
	
}
ElemType Sqlist::Delet(int i)
{
	//�������2
   ElemType e;
	if(i<1||i>length) 
		cout<<"Ҫɾ����λ�ô���";
		 
	else{
	  e=elem[i-1];
	  for(int j=i; j<length;j++){
		  elem[j-1].numb=elem[j].numb;
	      strcpy(elem[j-1].name,elem[j].name);
	      elem[j-1].tel=elem[j].tel;}
	      length--;
		  return e;

	}
   
}
void Sqlist::PrintOut()  //���
 { 
	cout<<"\n ͨѶ¼��������"<<length;
	cout<<"\n PrintOut Data:\n";
	cout<<setw(16)<<"ѧ��"<<setw(20)<<"����"<<setw(20)<<"�绰��"<<endl;
	for(int k=0; k<length;k++)      
	{ 
		cout<<setw(16)<<elem[k].numb<<setw(20)<<elem[k].name<<setw(20)<<elem[k].tel<<endl;
	}
 }
//--------------------------------------------------
int main( )
{ int i,k;  ElemType e,x;
  Sqlist  as;
  cout<<"\n               ͨѶ¼��ʾ";
  do{
      cout<<"\n\n";
      cout<<"\n\n    1. ��������һ��ͨѶ¼�����Ա� ";
      cout<<"\n\n    2. ����һ������Ԫ�� ";
      cout<<"\n\n    3. ɾ��һ��Ԫ�أ�������ֵ";
      cout<<"\n\n    4. ��������";
      cout<<"\n******************************** ";
      cout<<"\n    ���������ѡ��(1,2,3,4)";  cin>>k;
	  switch(k)
	  { 
	  case 1:
		  {  as.SetData(); as.PrintOut();  }break;
	  case 2:{ cout<<"\n �����λ�ã� i=?"; cin>>i;
                   cout<<"\n ��������� ���=?"; cin>>e.numb;
                   cout<<"\n ��������� ����=?"; cin>>e.name;
                   cout<<"\n ��������� �绰��=?"; cin>>e.tel;
                   as.Insert(i,e);  as.PrintOut();
                 }break;
	  case 3:{ cout<<"\n ɾ���ڼ���Ԫi=?";  cin>>i;
                  x=as.Delet(i);
                  if(x.numb!=-1)
                  {	
cout<<"\n  ��ɾ����Ԫ����ֵ= "<<setw(10)<<x.numb<< setw(10)<<x.name<<setw(10)<<x.tel;
                      as.PrintOut();
}
                 }break;
	  default:break;
	  } //switch
  }while(k>=1&&k<4);
  cout<<"\n          �ټ�!";  cout<<"\n     ������������ء�";
  _getch(); return 0;
}//-----------------------------------------------   

