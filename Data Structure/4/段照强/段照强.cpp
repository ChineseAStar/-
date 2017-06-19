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
	printf("����������Ҫ���������,��data����13ʱ����ֹͣ����:\n");
	printf("��ʽ��:\nrow\tcol\tdata\n");
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
printf("1����Ԫ����ʽ����ϡ�����A:\n");
printf("2���������A(��Ԫ����ʽ):\n");
printf("3��Aת��ΪB :\n");
printf("4. ���B:\n");
printf("5���˳�:\n");
printf("��ѡ��1-5:\n");
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
