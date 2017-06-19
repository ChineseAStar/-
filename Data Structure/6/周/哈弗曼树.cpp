#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<string.h>
#define UINT_MAX 99

//---------���������͹���������Ĵ洢��ʾ-----
typedef struct{
    unsigned int weight;
    unsigned int parent,lchild,rchild;
}HTNode,*HuffmanTree;//��̬��������洢��������

typedef char **HuffmanCode;//��̬��������洢�����������

int min1(HuffmanTree t,int i)
{
    //����void select��������
    int j,flag;
    unsigned int k=UINT_MAX;//ȡkΪ��С�ڿ��ܵ�ֵ
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
    //S1Ϊ��С������ֵ�����С���Ǹ�
    int j;
    s1=min1(t,i);//Ȩֵ��С�ĸ��ڵ����
    s2=min1(t,i);//Ȩֵ�ڶ�С�ĸ��ڵ����
    if(s1>s2)//S1����Ŵ���S2��
    {
        j=s1;
        s1=s2;//s1��Ȩֵ��С��2������Ž�С��
        s2=j;//s2��Ȩֵ��С��2������Žϴ��
    }
}

int n=0;
//------�����ַ�����----
int ScanfNumber()
{
    printf("\n�������ַ�����С��");
    scanf("%d",&n);
    printf("\n�������������%d",n);
    return n;
}

//------��������������ַ�����Ȩֵ------
void ScanfCodeAndWeight(int a)
{
    int i,*w;
    char *v;
    v=(char*)malloc(n*sizeof(char));
    w=(int*)malloc(n*sizeof(int));
    printf("\n����������%d���������ַ�����Ȩֵ��",a);
    for(i=0;i<=a-1;i++)
    {
        printf("\n�������%d���������ַ�����Ȩֵ��\n",i+1);
        scanf("%c %d",&v+i,&w+i);
        getchar();
    }
    printf("\n������ɣ�");
}

//-----------������������--------
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

    for(i=a+1;i<=m;++i)//������������
    {
        select(HT,i-1,s1,s2);
        HT[s1].parent=HT[s2].parent=i;
        HT[s1].lchild=s1;
        HT[s1].rchild=s2;
        HT[s1].weight=HT[s1].weight+HT[s2].weight;
    }

    printf("\n�������������ɹ���");
}

//-------��ɹ���������HC������ʾ����-------
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
        strcpy(HC[i],&cd[start]);//��cd���Ʊ��루������HC
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

	printf("\n         1�������ַ�����С");
	printf("\n         2������������ַ�����Ȩֵ");
	printf("\n         3��������������HT");
	printf("\n         4����ɹ���������HC������ʾ����");
	printf("\n         5���˳�");
	printf("\n         ��ѡ��˵�1-5��");

	scanf("%d",&a);
	getchar();

	switch(a)
	{
	case 1:n=ScanfNumber();printf("\n����ɹ���%d",n);_getch;break;
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
