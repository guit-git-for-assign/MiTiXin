#include <iostream>
using namespace std;

struct ElemType
{
	int num;
};

const int MAXSIZE = 10;

class Sqlist 
{
private:
	ElemType elems[MAXSIZE];
	int length = 0;
public:
	void setData();
	void sort();
	int getLength();
	void delet();
	void printOut();
	void insert();
};

int Sqlist::getLength()
{
	return length;
}

void Sqlist::setData()
{
	cout << "请输入长度:" << endl;
	cin >> length;
	if (length <= MAXSIZE)
	{
		for (int i = 0; i < length; i++)
		{
			cout << "请输入第" << (i+1) << "个数:" << endl;
			cin >> elems[i].num;
		}
	}
	else
	{
		cout << "长度超过容量上限";
	}
}

void Sqlist::sort()
{
	for (int i = 0; i < length-1; i++)
	{
		int temp = 0;
		for (int j = 0; j < length-1; j++)
		{
			if (elems[j].num > elems[j+1].num)
			{
				temp = elems[j].num;
				elems[j].num = elems[j + 1].num;
				elems[j + 1].num = temp;
			}
		}
	}
}

void Sqlist::delet()
{
	sort();
	cout << "请输入要删除的元素:" << endl;
	int num = 0;
	cin >> num;
	if (num == elems[length - 1].num)
	{
		int c = 0;
		for (int i = 0; i < length; i++)
		{
			if (num == elems[i].num)
			{
				c++;
			}
		}
		length = length - c;
	}
	else
	{
		for (int i = 0; i < length; i++)
		{
			if (num == elems[i].num)
			{
				elems[i].num = elems[length - 1].num;
				length--;
			}
		}
	}
	
}

void Sqlist::printOut() 
{
	sort();
	for (int i = 0; i < length; i++)
	{
		cout << elems[i].num << " |" ;
	}
	cout << endl;
	
}

void Sqlist::insert()
{
	int i = 0;
	ElemType e;

	cout << "请输入一个值:";
	cin >> i;
	e.num = i;
	if (length != MAXSIZE)
	{
		elems[length] = e;
		length++;
	}
	else 
	{
		cout << "顺序表已满" << endl;
	}
}

int main()
{
	int k = 0;
	Sqlist sqlist;
	
	do 
	{
		cout << "1.创建一个顺序线性表" << endl;
		cout << "2.添加一个元素" << endl;
		cout << "3.删除元素" << endl;
		cout << "4.遍历顺序线性表" << endl;
		cout << "0.退出" << endl;

		cin >> k;

		switch (k)
		{
		case 1: sqlist.setData(); break;
		case 2: sqlist.insert(); break;
		case 3: sqlist.delet(); break;
		case 4: sqlist.printOut(); break;

		default:
			break;
		}

	} while (k!=0);
	return 0;
}