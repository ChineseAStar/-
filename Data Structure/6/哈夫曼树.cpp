#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

//-------------���������͹���������Ĵ洢��ʾ----------
typedef struct{
    unsigned int weight;
    unsigned int parent,lchild,rchild;
}HTNode,*HuffmanTree;//��̬��������洢��������

typedef struct{
    char c;
    int q;
}Num,*NumL;//�ַ���Ȩֵ�ṹ

typedef char **HuffmanCode;//��̬��������洢�����������

//1.�����ַ�����С
void inputN(int &n)
{
    printf("������Ȩֵ�ĸ���(>1):");
    scanf("%d",&n);
    printf("������ɣ�");
}

//2.����������ַ�����Ȩֵ
void inputNum(int n,NumL &w)
{
    w = (NumL)malloc(n*(sizeof(int)+sizeof(char)));
    for(int i = 0;i<=n-1;i++)
    {
        printf("�����������%d��Ȩֵ(�ַ�,����):\n",i+1);
        scanf("%c,%d",&((w+i)->c),&((w+i)->q));
        getchar();
    }
    printf("������ɣ�");
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

//3.2ɸѡ����
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

//3.������������HT
void buildTC(HuffmanTree &HT,NumL w,int n)
{
    int m,i,s1,s2;
    HuffmanTree p,h;
    if(n<=1)//Ҷ�ӽڵ���������n
    {
        return;
    }
    m = 2*n-1;//n��Ҷ�ӽڵ����Ĺ�����������m�����
    HT = (HuffmanTree)malloc((m+1)*sizeof(HTNode));//0�ŵ�Ԫδ��

    for(p = HT+1,i = 1;i<=n;++i,++p,++w)//��1�ŵ�Ԫ��ʼ��n�ŵ�Ԫ����Ҷ�ӽڵ㸳ֵ
    {
        (*p).weight = w->q;//��Ȩֵ
        (*p).parent = 0;
        (*p).lchild = 0;
        (*p).rchild = 0;
    }
    for(;i<= m;++i,++p)//��ʼ��˫�׵�λ��
    {
        (*p).parent = 0;//������˫�����ֵΪ0
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

//4.��ɹ���������HC������ʾ����
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

//5.�˳�
void back()
{
    printf("��л����ʹ�ã�лл��");
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
        default:printf("������������ԣ�");_getch();
    }
}

void menu()
{
    system("cls");
    printf("\n\n\n");
    printf("\t\t\t1�������ַ�����С\n");
    printf("\t\t\t2������������ַ�����Ȩֵ\n");
    printf("\t\t\t3��������������HT\n");
    printf("\t\t\t4����ɹ���������HC������ʾ����\n");
    printf("\t\t\t5���˳�\n");
    printf("\t\t\t��ѡ��˵�1������");
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
