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
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>

//定义全局变量
int n;

//顺序表
#define LIST_INIT_SIZE 100      //线性表存储空间的初始分配量
#define LISTINCREMENT 10        //线性表存储空间的分配增量

//-------顺序表结点的存储结构---------//
typedef struct{
    int *elem;             //存储空间基址
    int length;                 //当前长度
    int listsize;               //当前分配的存储容量（以sizeof（ElemType）为单位）
}SqList;

//-------单链表结点的存储结构---------//
typedef struct LNode{
    int data;//数据域
    struct LNode *next;//指针域
}LNode,*LinkList;

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

//1顺序表的插入
void sListInsert(SqList &L,int i,int e)
{
    //在顺序表L中第i个位置之前插入新的数据元素e，L的长度加1
    int *newbase,*q,*p;
    if(i<1||i>L.length+1)//输入的i不合法
    exit(0);
    if(L.length>=L.listsize)//当前存储空间已满，增加分配
    {
        //realloc改变L.elem所有内存的大小，原始所指内存中的数据不变
        newbase=(int *)realloc(L.elem,(L.listsize+LISTINCREMENT)*sizeof(int));
        if(!newbase)
        exit(0);
        L.elem = newbase;//新基址
        L.elem+=LISTINCREMENT;//增加存储容量
    }
    q = L.elem+i-1;//指定插入的位置
    for(p=L.elem+L.length-1;p>=q;--p)//q之后的元素右移一步，以腾出位置
    *(p+1) = *p;
    *q = e;//插入e
    ++L.length;//表长增1
}

//00顺序表的创建
void sInitList(SqList &L)
{
    L.elem = (int *)malloc(LIST_INIT_SIZE*sizeof(int));
    if(!L.elem)//存储分配失败
    {
        printf("test");
        exit(0);
    }
    L.length = 0;                           //空表长度为0
    L.listsize = LIST_INIT_SIZE;            //初始存储容量
    printf("请输入定义顺序表数据个数\n");
    int a;
    scanf("%d",&a);
    for(int i = 1;i<=a;i++)
    {
        system("cls");
        printf("请输入第%d个数据\n",i);
        int e;
        scanf("%d",&e);
        sListInsert(L,i,e);
    }
}

//2顺序表的删除
void sListDelete(SqList &L,int i,int &e)
{
    //删除L的第i个元素，并用e返回其值，L的长度减1
    int *p,*q;
    if(i<1||i>L.length)//i值不合法
    exit(0);
    p = L.elem+i-1;//p为被删除的元素的位置
    e = *p;//被删除元素的位置
    q = L.elem + L.length - 1;//表尾元素的位置
    for(++p;p<=q;++p)
        *(p-1) = *p;//删除元素之后的元素左移
    L.length--;//表长减1
}

//3顺序表的长度
void sListLength(SqList &L)
{
    printf("此顺序表的长度是：%d\n",L.length);
    printf("按任意键返回主菜单");
    _getch();
}

//4顺序表的显示输出
void sListShow(SqList &L)
{
    system("cls");
    int *p,*q,i;
    i=0;
    q = L.elem + L.length-1;
    printf("位置\t数据\n");
    for(p = L.elem;p<=q;p++)
    {
        i++;
        printf("%d\t%d\n",i,*p);
    }
    _getch();
}

//5链式表的插入
void lListInsert(LinkList &L,int i,int e)
{
    //再不设头结点单链表中第i个位置之前插入元素e
    int j = 1;//计数器初值为1
    LinkList p = L,s;//p指向第1个结点
    if(i<1)//i值不合法
        exit(0);
    s = (LinkList)malloc(sizeof(struct LNode));//生成新结点
    s->data = e;//插入L中
    if(i==1)//插在表头
    {
        s->next = L;
        L = s;
    }
    else
    {
        //插在表的其余处
        while(p&&j<i-1)
        {
            j++;//计数器+1
            p = p->next;//p指向下一个结点
        }
        if(!p)//i大于表长+1
            exit(0);
        s->next = p->next;//新结点指向原第i个结点
        p->next = s;//原第i-1个结点指向新结点
    }
}

//000链表的创建
void lCreateList(LinkList &L)
{
    system("cls");
    printf("请输入要输入链式表的个数\n");
    int a;
    scanf("%d",&a);
    for(int i = 1;i<=a;i++)
    {
        system("cls");
        printf("请输入第%d个数据\n",i);
        int e;
        scanf("%d",&e);
        lListInsert(L,i,e);
    }
}

//6链表的删除
void lListDelete(LinkList &L,int i,int e)
{
    //再不设头结点的单链L中，删除第i个元素，并由e返回其值
    int j = 1;
    LinkList p = L,q;//p指向第1个结点
    if(!L)//表L非空
    {
        printf("空表，删除失败\n");
        printf("按任意键返回");
        _getch();
    }
    else if(i==1)//删除第1个结点
    {
        L = p->next;//L由第2个结点开始
        e = p->data;//将待删结点的值赋给e
        free(p);
    }
    else
    {
        while(p->next&&j<i-1)
        {
            j++;//计数器+1
        p = p->next;//p指向下一个结点
        }
        if(!p->next||j>i-1)//删除位置不合理
        {
            printf("删除位置不合理，删除失败\n");
            printf("按任意键返回");
            _getch();
        }
        q = p->next;//p指向待删除节点
        p->next = q->next;//待删除节点的前驱指向待删结点的后继
        e = q->data;//将待删结点的值赋给e
        free(q);//释放待删结点
    }
}

//7取链表的第i个元素
int lGetElem(LinkList L,int i,int &e)
{
    int j = 1;
    LinkList p = L;
    if(i<1)
    {
        printf("输入插入位置不合法\n");
        printf("按任意键返回");
        _getch();
    }
    while(j<i&&p)
    {
        j++;
        p = p->next;
    }
    if(j==1&&p)
    {
        e = p->data;
        return e;
    }
    else
    {
        printf("该位置元素不存在\n");
        printf("按任意键返回");
        _getch();
    }
}

//8链表的输出
void lListShow(LinkList &L)
{
    system("cls");
    LinkList p;
    int a = 1;
    printf("位置\t数据\n");
    for(p=L;p!=NULL;a++)
    {
        printf("%d\t%d\n",a,p->data);
        p = p->next;
    }
    _getch();
}

//9继续或退出（Y/N or y/n）
void choose()
{
    char a;
    printf("请输入（Y/N or y/n）");
    scanf("%c",&a);
    scanf("%c",&a);
    switch(a)
    {
        case 'n': exit(0);break;
        case 'N': exit(0);break;
        case 'y': break;
        case 'Y': break;
        default : printf("输入格式错误！");_getch();
    }
}

//主函数
int main()
{

    //初始化顺序链表
    SqList S;
    //printf("test");
    sInitList(S);
    //创建链表
    LinkList L = NULL;
    lCreateList(L);
	while(1)
	{
        menu();
		scanf("%d",&n);
		int i,e;
		switch(n)
		{
			case 1:printf("请输入：\n位置,数据\n");scanf("%d,%d",&i,&e);sListInsert(S,i,e);break;
			case 2:scanf("%d,%d",&i,&e);sListDelete(S,i,e);break;
			case 3:sListLength(S);break;
			case 4:sListShow(S);break;
			case 5:printf("请输入：\n位置,数据\n");scanf("%d,%d",&i,&e);lListInsert(L,i,e);break;
			case 6:printf("请输入：\n位置,数据\n");scanf("%d,%d",&i,&e);lListDelete(L,i,e);break;
			case 7:printf("请输入位置：\n");scanf("%d",&i);lGetElem(L,i,e);break;
			case 8:lListShow(L);break;
			case 9:choose();break;
			default:printf("输入错误，请重试！");_getch();
		}
	}
	return 0;
}

