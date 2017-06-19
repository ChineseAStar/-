#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>
#define UINT_MAX 99

//---------哈弗曼树和哈夫曼编码的存储表示-----
typedef struct{
    unsigned int weight;
    unsigned int parent,lchild,rchild;
}HTNode,*HuffmanTree;//动态分配数组存储哈弗曼树

typedef char **HuffmanCode;//动态分配数组存储哈夫曼编码表

int min1(HuffmanTree t,int i)
{
    //函数void select（）调用
    int j,flag;
    unsigned int k=UINT_MAX;//取k为不小于可能的值
    for(j=1;j<=i;j++)
    {
        if(t[j].weight<k&&t[j].parent==0)
            k=t[j].weight,flag=j;
        t[flag].parent=1;
        return flag;
    }
}

void select(HuffmanTree t,int i, int &s1,int &s2)
{
    //S1为最小的两个值中序号小的那个
    int j;
    s1=min1(t,i);//权值最小的根节点序号
    s2=min1(t,i);//权值第二小的根节点序号
    if(s1>s2)//S1的序号大于S2的
    {
        j=s1;
        s1=s2;//s1是权值最小的2个中序号较小的
        s2=j;//s2是权值最小的2个中序号较大的
    }
}

int n=0;
//------输入字符数量----
int ScanfNumber()
{
    printf("\n请输入字符集大小：");
    scanf("%d",&n);
    printf("\n你输入的数据是%d",n);
    return n;
}

//------输入输入带编码字符及其权值------
void ScanfCodeAndWeight(int a)
{
    int i,*w;
    char *v;
    v=(char*)malloc(n*sizeof(char));
    w=(int*)malloc(n*sizeof(int));
    printf("\n请依次输入%d个带编码字符及其权值：",a);
    for(i=0;i<=a-1;i++)
    {
        printf("\n请输入第%d个带编码字符及其权值：\n",i+1);
        scanf("%c %d",&v+i,&w+i);
        getchar();
    }
    printf("\n输入完成！");
}

//-----------建立哈弗曼树--------
void HuffmanTreeing(HuffmanTree &HT, int *w,int a)
{
    int m,i,s1,s2,start;
    HuffmanTree p;
    char *cd;

    if(n<=1)
        return;

    m=2*n-1;
    HT=(HuffmanTree)malloc((m+1)*sizeof(HTNode));

    for(p=HT+1,i=1; i<=a; ++i ,++p,++w)
    {
        (*p).weight=*w;
        (*p).parent=0;
        (*p).lchild=0;
        (*p).rchild=0;
    }

    for(;i<=m;++i,++p)
        (*p).parent=0;

    for(i=a+1;i<=m;++i)//建立哈弗曼树
    {
        select(HT,i-1,s1,s2);
        HT[s1].parent=HT[s2].parent=i;
        HT[s1].lchild=s1;
        HT[s1].rchild=s2;
        HT[s1].weight=HT[s1].weight+HT[s2].weight;
    }

    printf("\n哈弗曼树建立成功！");
}

//-------完成哈夫曼编码HC，并显示编码-------
void HuffmanCoding(HuffmanTree HT, HuffmanCode HC, int *w,int n)
{
    int m,i,s1,s2,start;
    unsigned int c,f;
    char *cd;

    HC=(HuffmanCode)malloc((n+1)*sizeof(char*));
    cd=(char*)malloc(n*sizeof(char));
    cd[n-1]='\0';

    for(i=1;i<=n;i++)
    {
        start=n-1;
        for(c=i,f=HT[i].parent;f!=0;c=f,f=HT[f].parent)
            if(HT[f].lchild==c) cd[--start]='\0';
            else cd[--start]='1';
        HC[i]=(char*)malloc((n-start)*sizeof(char));
        strcpy(HC[i],&cd[start]);//从cd复制编码（串）到HC
    }

    free(cd);

    for(i=1;i<n;i++)
        puts(HC[i]);
}

void menu()
{
	int a,*w;
	HuffmanTree HT;
	HuffmanCode HC;

	printf("\n         1．输入字符集大小");
	printf("\n         2．输入带编码字符及其权值");
	printf("\n         3．建立哈夫曼树HT");
	printf("\n         4．完成哈夫曼编码HC，并显示编码");
	printf("\n         5．退出");
	printf("\n         请选择菜单1-5：");

	scanf("%d",&a);
	getchar();

	switch(a)
	{
	case 1:n=ScanfNumber();printf("\n输入成功！%d",n);_getch;break;
	case 2:printf("%d",n);ScanfCodeAndWeight(n);_getch;break;
	case 3:HuffmanTreeing(HT,w,n);_getch;break;
	case 4:HuffmanCoding(HT,HC,w,n);_getch;break;
	case 5:_getch;break;
	default:break;
	}

	menu();
}

int main()
{
	menu();
}
