#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

//-------------哈夫曼树和哈夫曼编码的存储表示----------
typedef struct{
    unsigned int weight;
    unsigned int parent,lchild,rchild;
}HTNode,*HuffmanTree;//动态分配数组存储哈夫曼树

typedef struct{
    char c;
    int q;
}Num,*NumL;//字符和权值结构

typedef char **HuffmanCode;//动态分配数组存储哈夫曼编码表

//1.输入字符集大小
void inputN(int &n)
{
    printf("请输入权值的个数(>1):");
    scanf("%d",&n);
    printf("输入完成！");
}

//2.输入带编码字符及其权值
void inputNum(int n,NumL &w)
{
    w = (NumL)malloc(n*(sizeof(int)+sizeof(char)));
    for(int i = 0;i<=n-1;i++)
    {
        printf("请依次输入第%d个权值(字符,整数):\n",i+1);
        scanf("%c,%d",&((w+i)->c),&((w+i)->q));
        getchar();
    }
    printf("输入完成！");
}

//3.1
int minl(HuffmanTree t,int i)
{
    int j,flag;
    unsigned int k = 65535;
    for(j = 1;j<=i;j++)
    {
        if(t[j].weight<k&&t[j].parent==0)
        {
            k = t[j].weight,flag = j;
        }
    }
    t[flag].parent = 1;
    return flag;
}

//3.2筛选函数
void select(HuffmanTree t,int i,int &s1,int &s2)
{
    int j;
    s1 = minl(t,i);
    s2 = minl(t,i);
    if(s1>s2)
    {
        j = s1;
        s1 = s2;
        s2 = j;
    }
}

//3.建立哈夫曼树HT
void buildTC(HuffmanTree &HT,NumL w,int n)
{
    int m,i,s1,s2;
    HuffmanTree p,h;
    if(n<=1)//叶子节点数不大于n
    {
        return;
    }
    m = 2*n-1;//n个叶子节点数的哈夫曼树共有m个结点
    HT = (HuffmanTree)malloc((m+1)*sizeof(HTNode));//0号单元未用

    for(p = HT+1,i = 1;i<=n;++i,++p,++w)//从1号单元开始到n号单元，给叶子节点赋值
    {
        (*p).weight = w->q;//赋权值
        (*p).parent = 0;
        (*p).lchild = 0;
        (*p).rchild = 0;
    }
    for(;i<= m;++i,++p)//初始化双亲的位置
    {
        (*p).parent = 0;//其余结点双亲域初值为0
    }
    for(i = n+1;i<=m;++i)
    {
        //select
        select(HT,i-1,s1,s2);
        HT[s1].parent = HT[s2].parent = i;
        HT[i].lchild = s1;
        HT[i].rchild = s2;
        HT[i].weight = HT[s1].weight = HT[s2].weight;
    }
        for(h = HT+1,i = 0;i<n;h++,i++)
    {
        printf("%d\t%d\t%d\t%d\n",p->weight,p->parent,p->lchild,p->rchild);
    }

}

//4.完成哈夫曼编码HC，并显示编码
void show(HuffmanTree &HT,HuffmanCode &HC,NumL w,int n)
{
    int start;
    unsigned int c,f;
    char *cd;
    HC = (HuffmanCode)malloc((n+1)*sizeof(char*));
    cd = (char*)malloc(n*sizeof(char));
    cd[n-1] = '\0';
    for(int i = 1;i<=n;i++)
    {
        start = n-1;
        for(c = i,f = HT[i].parent;f!=0;c = f,f = HT[f].parent)
        {
            if(HT[f].lchild == c)
            {
                cd[--start] = '0';
            }else
            {
                cd[--start] = '1';
            }
        }
        HC[i] = (char*)malloc((n-start)*sizeof(char));
        for(int j = 0;start!=n;start++,j++)
		{
			HC[i][j] = cd[start];
		}
    }
    free(cd);
    for(int j = 1;j<=n;j++,w++)
    {
		printf("%c:\t",w->c);
        puts(HC[j]);
    }
}

//5.退出
void back()
{
    printf("感谢您的使用，谢谢！");
    exit(0);
}

void choose(HuffmanTree &HT,HuffmanCode &HC,int &n,NumL &w)
{
    int t = 0;
    scanf("%d",&t);
    getchar();
    switch(t)
    {
        case 1:inputN(n);_getch();
            break;
        case 2:inputNum(n,w);_getch();
            break;
        case 3:buildTC(HT,w,n);_getch();
            break;
        case 4:show(HT,HC,w,n);_getch();
            break;
        case 5:back();
            break;
        default:printf("输入错误，请重试！");_getch();
    }
}

void menu()
{
    system("cls");
    printf("\n\n\n");
    printf("\t\t\t1．输入字符集大小\n");
    printf("\t\t\t2．输入带编码字符及其权值\n");
    printf("\t\t\t3．建立哈夫曼树HT\n");
    printf("\t\t\t4．完成哈夫曼编码HC，并显示编码\n");
    printf("\t\t\t5．退出\n");
    printf("\t\t\t请选择菜单1—５：");
}

int main()
{
    HuffmanTree HT;
    HuffmanCode HC;
    int n;
    NumL w;
    while(1)
    {
        menu();
        choose(HT,HC,n,w);
    }
    return 0;
}
