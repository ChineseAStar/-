#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>


//-------队列存储表示----------
#define MAXQSIZE 20

typedef int QElemType;

typedef struct QNode{
    QElemType data;
    struct QNode *next;
}QNode,*QueuePtr;

typedef struct{
    QueuePtr front;
    QueuePtr rear;
}LinkQueue;

void InitQueue(LinkQueue &Q)
{
    Q.front = Q.rear = (QueuePtr)malloc(sizeof(QNode));
    if(!Q.front)
    {
        printf("生成头结点失败!");
        exit(0);
    }
    Q.front->next = NULL;
}

bool QueueEmpty(LinkQueue Q)
{
    if(Q.front->next == NULL)
    {
        return true;
    }else
    {
        return false;
    }
}

void EnQueue(LinkQueue &Q,QElemType e)
{
    QueuePtr p = (QueuePtr)malloc(sizeof(QNode));
    if(!p)
    {
        printf("存储分配失败!");
        exit(0);
    }
    p->data = e;
    p->next = NULL;
    Q.rear->next = p;
    Q.rear = p;
}

void DeQueue(LinkQueue &Q,QElemType &e)
{
    QueuePtr p;
    if(Q.front == Q.rear)
    {
        printf("队列为空!");
    }
    p = Q.front->next;
    e = p->data;
    Q.front->next =  p->next;
    if(Q.rear == p)
    {
        Q.rear == Q.front;
    }
    free(p);
}

//-------图的邻接表存储表示---------
#define MAX_VERTEX_NUM 20
#define MAXNAME 10
typedef char VertexType[MAXNAME];
typedef struct ArcNode{
    int adjvex; //该弧所指向的顶点的位置
    struct ArcNode *nextarc;    //指向吓一条弧的指针
}ArcNode;

typedef struct VNode{
    VertexType data;
    ArcNode *firstarc;
}VNode,AdjList[MAX_VERTEX_NUM];

typedef struct{
    AdjList vertices;
    int vexnum,arcnum;
    int kind;
}ALGraph;

int FirstAdjVex(ALGraph G,int v){
    if(G.vertices[v].firstarc)
        return G.vertices[v].firstarc->adjvex;
    else
        return -1;
}

int NextAdjVex(ALGraph G,int v,int w){
    ArcNode* p = G.vertices[v].firstarc;
    while(p->adjvex!=w)
        p = p->nextarc;
    if(p->nextarc)
        return p->nextarc->adjvex;
    else
        return -1;
}


//取结点的下标
int Get(ALGraph G,VertexType t)
{
    int i;
    for(i = 0;i<G.vexnum;i++)
    {
        if(!strcmp(t,G.vertices[i].data))
        {
            return i;
        }
    }
    return -1;
}

//1…图的建立
void CreateGraph(ALGraph &G)
{
    char p;
    printf("请输入节点数(<20)：");
    scanf("%d",&G.vexnum);
    printf("请输入结点数据(以空格隔开):\n");
    getchar();
    for(int i = 0;i<G.vexnum;i++)
    {
        VertexType t;
		p = getchar();
        for(int n = 0;p != ' '&&p != '\n';n++)
        {
            t[n] = p;
            t[n+1] = '\0';
            p = getchar();
        }
        strcpy(G.vertices[i].data,t);
		G.vertices[i].firstarc = (ArcNode*)malloc(sizeof(ArcNode));
    }
    printf("点集读取完毕!\n\n");
    for(int j = 0;j<G.vexnum;j++)
    {
        ArcNode *tmp = (ArcNode*)malloc((G.vexnum-1)*sizeof(ArcNode));
        printf("请输入第%d个结点的相邻结点(以空格分开):\n",j+1);
        VertexType t;
		p = getchar();
        for(int n = 0;p != ' '&&p != '\n';n++)
        {
            t[n] = p;
            t[n+1] = '\0';
            p = getchar();
        }
		G.vertices[j].firstarc = tmp;
        tmp->adjvex = Get(G,t);
        while(p != '\n')
        {
			tmp->nextarc = tmp+1;
			tmp = tmp->nextarc;
			p = getchar();
            for(int n = 0;p != ' '&&p != '\n';n++)
            {
                t[n] = p;
                t[n+1] = '\0';
                p = getchar();
            }
			tmp->adjvex = Get(G,t);
        }
        tmp->nextarc = NULL;
    }
    printf("边集读取完毕!");
}

//遍历
bool visited[MAX_VERTEX_NUM];//访问标志数组(全局变量)
void (*VisitFunc)(VertexType v);
char* GetVex(ALGraph &G,int v)
{
	return G.vertices[v].data;
}

void Print(VertexType i)//显示顶点
{
	printf("%s->",i);
}

//2…深度优先遍历图
void DFS(ALGraph G,int v)
{
    //从第v个定点出发递归地深度优先遍历图G
    int w;
    visited[v] = true;//设置访问标志位TRUE(已访问)
    VisitFunc(GetVex(G,v));
    for(w = FirstAdjVex(G,v);w>=0;w = NextAdjVex(G,v,w))
    {
        if(!visited[w])
        {
            DFS(G,w);
        }
    }
}
void DFSGraph(ALGraph G,void (*Visit)(VertexType))
{
    int v;
	VisitFunc=Visit;
    for(v = 0;v<G.vexnum;v++)
    {
        visited[v] = false;
    }
    printf("输出深度优先访问次序:\n");
    for(v = 0;v<G.vexnum;v++)
    {
        if(!visited[v])
        {
            DFS(G,v);
        }
    }
    printf("\b\b  \n完毕!");
}

//3…广度优先遍历图
void BFSGraph(ALGraph G,void (*Visit)(VertexType))
{
    int u,v,w;
    LinkQueue Q;
    InitQueue(Q);
    for(v = 0;v<G.vexnum;v++)
    {
        visited[v] = false;
    }
    printf("输出广度优先访问次序:\n");
    for(v = 0;v<G.vexnum;v++)
    {
        if(!visited[v])
        {
            visited[v] = true;
			Visit(GetVex(G,v));
            EnQueue(Q,v);
            while(!QueueEmpty(Q))
            {
                DeQueue(Q,u);
                for(w = FirstAdjVex(G,u);w>=0;w = NextAdjVex(G,u,w))
                {
                    if(!visited[w])
                    {
                        visited[w] = true;
                        Visit(GetVex(G,w));
                        EnQueue(Q,w);
                    }
                }
            }
        }
    }
    printf("\b\b  \n完毕!");
}

//4…结束
void back()
{
    printf("感谢您的使用，再见！");
    exit(0);
}

void menu()
{
    system("cls");
    printf("\n\n\n");
    printf("\t\t\t1…图的建立\n");
    printf("\t\t\t2…深度优先遍历图\n");
    printf("\t\t\t3…广度优先遍历图\n");
    printf("\t\t\t4…结束\n");
    printf("\t\t\t请选择菜单1—4：");
}

void choose(ALGraph &G)
{
    int t;
    scanf("%d",&t);
	getchar();
    switch(t)
    {
        case 1:CreateGraph(G);_getch();
        break;
        case 2:DFSGraph(G,Print);_getch();
        break;
        case 3:BFSGraph(G,Print);_getch();
        break;
        case 4:back();
        break;
        default:printf("输入错误请重试！");_getch();
    }
}

int main()
{
    ALGraph G;
    while(1)
    {
        menu();
        choose(G);
    }
    return 0;
}
