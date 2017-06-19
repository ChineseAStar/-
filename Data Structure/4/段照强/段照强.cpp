#include <stdio.h>
#include <stdlib.h>
#define MAX_SIZE 100
/*************************************************/
typedef int ElementType;
typedef struct{
	int row;
	int col;
	ElementType data;
}sanYuanZu;
typedef struct{
	int hangShu;
	int lieShu;
	int numbers;
	sanYuanZu secondData[MAX_SIZE];
} sanYuanZuShuZu;
/*************************************************/
void printMenu();
void inputXiShuJuZhenBySanYuanZu(sanYuanZuShuZu& s1);
void printSanYuanZuShuZu(sanYuanZuShuZu s1);
void zhuanZhiSanYuanZuShuZu(sanYuanZuShuZu s1,sanYuanZuShuZu& s2);
/*************************************************/
void inputXiShuJuZhenBySanYuanZu(sanYuanZuShuZu& s1){
	s1.numbers=0;
	printf("请输入您所要输入的数据,当data等于13时将会停止输入:\n");
	printf("格式是:\nrow\tcol\tdata\n");
	for(int i=0;s1.secondData[i-1].data!=13;i++){
		scanf("%d%d%d",&s1.secondData[i].row,&s1.secondData[i].col,&s1.secondData[i].data);
		s1.numbers++;
	}
	return;
}
void printSanYuanZuShuZu(sanYuanZuShuZu s1){
	printf("row\tcol\tdata\n");
	for(int i=0;i<s1.numbers;i++){
	printf("%d\t%d\t%d\n",s1.secondData[i].row,s1.secondData[i].col,s1.secondData[i].data);
	}
	return;
}
void zhuanZhiSanYuanZuShuZu(sanYuanZuShuZu s1,sanYuanZuShuZu& s2){
	for(int i=0;i<s1.numbers;i++){
		s2.secondData[i].col=s1.secondData[i].row;
		s2.secondData[i].row=s1.secondData[i].col;
		s2.secondData[i].data=s1.secondData[i].data;
	}
}
void printMenu(){
printf("1．三元组形式输入稀疏矩阵A:\n");
printf("2．输出矩阵A(三元组形式):\n");
printf("3．A转置为B :\n");
printf("4. 输出B:\n");
printf("5．退出:\n");
printf("请选择1-5:\n");
int i=0;
sanYuanZuShuZu s1;
sanYuanZuShuZu s2;
scanf("%d",&i);
switch(i){
	case 1:{
		inputXiShuJuZhenBySanYuanZu(s1);
	}
	case 2:{
		printSanYuanZuShuZu(s1);
	}
	case 3:{
		zhuanZhiSanYuanZuShuZu(s1,s2);break;
	}
	case 4:{
		printSanYuanZuShuZu(s2);
	}
	case 5:{
		return;
	}
}
}
/*************************************************/
int main(){
	printMenu();
	return 0;
}
