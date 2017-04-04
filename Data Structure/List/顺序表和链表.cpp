#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

//定义全局变量
int n;
//线性表
#define LIST_INIT_SIZE 100      //线性表存储空间的出事分配量
#define LISTINCREMENT 10        //线性表存储空间的分配增量

typedef struct{
    ElemType *elem;             //存储空间基址
    int length;                 //当前长度
    int listsize;               //当前分配的存储容量（以sizeof（ElemType）为单位）
}

//0菜单函数
void menu()
{
	system("cls");
	printf("\n\n\n");
	printf("\t\t1.顺序表的插入\n");
	printf("\t\t2.顺序表的删除\n");
	printf("\t\t3.顺序表的长度\n");
	printf("\t\t4.顺序表的显示输出\n");
	printf("\t\t5.链式表的插入\n");
	printf("\t\t6.链表的删除\n");
	printf("\t\t7.取链表的第i个元素入\n");
	printf("\t\t8.链表的输出\n");
	printf("\t\t9.继续或退出（Y/N or y/n）\n");
}

//00顺序表的创建
void sInitList()
{
    while()
    {

    }
}

//000链表的创建
void lCreateList()
{
}

//1顺序表的插入
void sListInsert()
{
}

//2顺序表的删除
void sListDelete()
{
}

//3顺序表的长度
void sListLength()
{
}

//4顺序表的显示输出
void sListShow()
{
}

//5链式表的插入
void lListInsert()
{
}

//6链表的删除
void lListDelete()
{
}

//7取链表的第i个元素
void lGetElem()
{
}

//8链表的输出
void lListShow()
{
}

//9继续或退出（Y/N or y/n）
void choose()
{
}

//主函数
int main()
{
	while(1)
	{
		menu();
		scanf("%d",&n);
		switch(n)
		{
			case '1':break;
			case '2':break;
			case '3':break;
			case '4':break;
			case '5':break;
			case '6':break;
			case '7':break;
			case '8':break;
			case '9':break;
			default:break;
		}
	}
	return 0;
}
