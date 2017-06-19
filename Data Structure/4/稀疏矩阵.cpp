#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

//----------------------稀疏矩阵的三元组顺序表存储表示-------------------------//
#define MAXSIZE 12500   //假设非零元的个数的最大值为12500

typedef struct{
    int i,j;//该非零元的行下标和列下标
    int e;
}Triple;

typedef struct{
    Triple data[MAXSIZE+1]; //非零元三元组表，data【0】未用
    int mu,nu,tu;   //矩阵的行数、列数和非零元个数
}TSMatrix;

//1．三元组形式输入稀疏矩阵A
void inputA(TSMatrix &A)
{
    printf("请输入行数、列数和非零元个数（mu,nu,tu）\n");
    scanf("%d,%d,%d",&A.mu,&A.nu,&A.tu);
    for(int tmp=1;tmp<=A.tu;tmp++)
    {
        system("cls");
        printf("请输入第%d个数据\n",tmp);
        scanf("%d,%d,%d",&A.data[tmp].i,&A.data[tmp].j,&A.data[tmp].e);
    }
}

//2．输出矩阵A(三元组形式)
void outputA(TSMatrix A)
{
    system("cls");
    printf("A矩阵的三元输出：\n");
    printf("\t\t\ti\tj\tv\n");
    for(int tmp=1;tmp<=A.tu;tmp++)
    {
        printf("\t\t\t%d\t%d\t%d\n",A.data[tmp].i,A.data[tmp].j,A.data[tmp].e);
    }
}

//3．A转置为B
void FastTransposeSMatrix(TSMatrix A,TSMatrix &B)
{
    //快速求稀疏矩阵A的转置矩阵B
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
    printf("转置成功！");
}

//4. 输出B
void outputB(TSMatrix B)
{
    system("cls");
    printf("B矩阵的三元输出：\n");
    printf("\t\t\ti\tj\tv\n");
    for(int tmp=1;tmp<=B.tu;tmp++)
    {
        printf("\t\t\t%d\t%d\t%d\n",B.data[tmp].i,B.data[tmp].j,B.data[tmp].e);
    }
    printf("B矩阵的矩阵输出：\n");
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

//5．退出
void back()
{
    printf("感谢您的使用，再见！");
    exit(0);
}

//选择函数
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
        printf("输入不正确请重试！");_getch();
    }
}

//菜单函数
void menu()
{
    system("cls");
    printf("\t\t\t-------------稀疏矩阵转置-----------------\n");
    printf("\t\t\t1．三元组形式输入稀疏矩阵A\n");
    printf("\t\t\t2．输出矩阵A(三元组形式)\n");
    printf("\t\t\t3．A转置为B \n");
    printf("\t\t\t4. 输出B\n");
    printf("\t\t\t5．退出\n");
    printf("\t\t\t请选择1—5：");
}

//主函数
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
