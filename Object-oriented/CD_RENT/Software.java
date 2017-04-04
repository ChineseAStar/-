import java.util.*;

public class Software {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义输入列表
		ArrayList<Film> list = new ArrayList<Film>();
		//定义读取对象
		System.out.println("请输入：");
		Scanner sc = new Scanner(System.in);		
		//循环读取数据
		while(sc.hasNextLine())
		{
			Film film = new Film();
			String a = sc.nextLine();				
			//连续输入换行跳出
			if(a.equals("")) break;
			Scanner sc2 = new Scanner(a);			
			film.setTy(sc2.next());
			film.setYn(sc2.next());
			film.setT(sc2.nextInt());;
			list.add(film);							
			System.out.println("请输入：");
		}
		//输出收费清单
		System.out.println("片种"+'\t'+"新旧"+'\t'+"时长"+'\t'+"收费");
		double sum = 0;
		for(Film tmp:list)
		{
			tmp.setFee();
			System.out.println(tmp);
			sum += tmp.getFee();
		}
		System.out.println("总金额为："+sum);
	}
}

//片类
class Film
{
	//定义属性
	private String ty;				
	private String yn;				
	private double re;				
	private double fee;				
	private int t;					
	//属性的getter和setter方法
	public String getTy() {
		return ty;
	}
	public void setTy(String ty) {
		this.ty = ty;
	}
	public String getYn() {
		return yn;
	}
	public void setYn(String yn) {
		this.yn = yn;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(){
		this.fee = calFee();
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	//费用计算
	private double calFee()
	{
		double tmp;
		tmp = 2*this.t;
		if(this.t>=2)
		{
			tmp += 2*(this.t-2);
		}
		//如果是新片加价
		if(this.yn.equals("是"))
		switch(this.ty)
		{
		case "欧美片": re = 0.5*tmp;break;
		case "日韩片": re = 0.3*tmp;break;
		case "国产片": re = 0.4*tmp;break;
		default:break;
		}
		//单部影片收费
		if(this.t!=1)
		tmp = tmp+re;
		return tmp ;
	}
	//toString打印列表方法
	public String toString()
	{
		return this.ty+'\t'+this.yn+'\t'+this.t+'\t'+this.fee;
	}
}
