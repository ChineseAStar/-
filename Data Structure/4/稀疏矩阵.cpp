#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

//----------------------ϡ��������Ԫ��˳���洢��ʾ-------------------------//
#define MAXSIZE 12500   //�������Ԫ�ĸ��������ֵΪ12500

typedef struct{
    int i,j;//�÷���Ԫ�����±�����±�
    int e;
}Triple;

typedef struct{
    Triple data[MAXSIZE+1]; //����Ԫ��Ԫ���data��0��δ��
    int mu,nu,tu;   //����������������ͷ���Ԫ����
}TSMatrix;

//1����Ԫ����ʽ����ϡ�����A
void inputA(TSMatrix &A)
{
    printf("�����������������ͷ���Ԫ������mu,nu,tu��\n");
    scanf("%d,%d,%d",&A.mu,&A.nu,&A.tu);
    for(int tmp=1;tmp<=A.tu;tmp++)
    {
        system("cls");
        printf("�������%d������\n",tmp);
        scanf("%d,%d,%d",&A.data[tmp].i,&A.data[tmp].j,&A.data[tmp].e);
    }
}

//2���������A(��Ԫ����ʽ)
void outputA(TSMatrix A)
{
    system("cls");
    printf("A�������Ԫ�����\n");
    printf("\t\t\ti\tj\tv\n");
    for(int tmp=1;tmp<=A.tu;tmp++)
    {
        printf("\t\t\t%d\t%d\t%d\n",A.data[tmp].i,A.data[tmp].j,A.data[tmp].e);
    }
}

//3��Aת��ΪB
void FastTransposeSMatrix(TSMatrix A,TSMatrix &B)
{
    //������ϡ�����A��ת�þ���B
    int p,q,col,*num,*cpot;
    num = (int*)malloc((A.nu+1)*sizeof(int));
    cpot = (int*)malloc((A.nu+1)*sizeof(int));
    B.nu = A.mu;
    B.mu = A.nu;
    B.tu = A.tu;
    if(B.tu)
    {
        for(col = 1;col<=A.nu;++col)
        {
            num[col] = 0;
        }
        for(p = 1;p<=A.tu;++p)
        {
            ++num[A.data[p].j];
        }
        cpot[1] = 1;
        for(col = 2;col<=A.nu;++col)
        {
            cpot[col] = cpot[col-1]+num[col-1];
        }
        for(p = 1;p<=A.tu;++p)
        {
            col = A.data[p].j;
            q = cpot[col];
            B.data[q].i = A.data[p].j;
            B.data[q].j = A.data[p].i;
            B.data[q].e = A.data[p].e;
            ++cpot[col];
        }
    }
    free(num);
    free(cpot);
    printf("ת�óɹ���");
}

//4. ���B
void outputB(TSMatrix B)
{
    system("cls");
    printf("B�������Ԫ�����\n");
    printf("\t\t\ti\tj\tv\n");
    for(int tmp=1;tmp<=B.tu;tmp++)
    {
        printf("\t\t\t%d\t%d\t%d\n",B.data[tmp].i,B.data[tmp].j,B.data[tmp].e);
    }
    printf("B����ľ��������\n");
    int T[B.mu][B.nu];
    for(int n = 0;n<B.mu;n++)
    {
        for(int m = 0;m<B.nu;m++)
        {
            T[n][m] = 0;
        }
    }
    for(int z = 1;z<=B.tu;z++)
    {
        T[B.data[z].i-1][B.data[z].j-1] = B.data[z].e;
    }
    for(int a = 0;a<B.mu;a++)
    {
        for(int b = 0;b<B.nu;b++)
        {
            printf("\t%d",T[a][b]);
        }
        printf("\n");
    }
}

//5���˳�
void back()
{
    printf("��л����ʹ�ã��ټ���");
    exit(0);
}

//ѡ����
void choose(TSMatrix &A,TSMatrix &B)
{
    int a;
    scanf("%d",&a);
    getchar();
    switch(a)
    {
        case 1:inputA(A);_getch();
        break;
        case 2:outputA(A);_getch();
        break;
        case 3:FastTransposeSMatrix(A,B);_getch();
        break;
        case 4:outputB(B);_getch();
        break;
        case 5:back();
        break;
        default:
        printf("���벻��ȷ�����ԣ�");_getch();
    }
}

//�˵�����
void menu()
{
    system("cls");
    printf("\t\t\t-------------ϡ�����ת��-----------------\n");
    printf("\t\t\t1����Ԫ����ʽ����ϡ�����A\n");
    printf("\t\t\t2���������A(��Ԫ����ʽ)\n");
    printf("\t\t\t3��Aת��ΪB \n");
    printf("\t\t\t4. ���B\n");
    printf("\t\t\t5���˳�\n");
    printf("\t\t\t��ѡ��1��5��");
}

//������
int main()
{
    TSMatrix A,B;
    while(1)
    {
        menu();
        choose(A,B);
    }
    return 0;
}
