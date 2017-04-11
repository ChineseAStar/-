import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class demo {

	public static void main(String[] args) throws FileNotFoundException {
		//定义输入列表
		FileReader f = new FileReader("/input.txt");
		RM rm = new RM(f);
		Calculator cal = new Calculator(rm.getList());
		System.out.printf("%d",(int)Math.rint(cal.getAns()));
	}

}

//读取器
class RM
{
	private ArrayList<Film> list = new ArrayList<Film>();
	public ArrayList<Film> getList() {
		return list;
	}
	public RM(FileReader f) throws FileNotFoundException
	{
		Scanner sc = new Scanner(f);
		sc.nextLine();
		//循环读取数据
		while(sc.hasNextLine())
		{
			Film film = new Film();	
			Scanner sc2 =new Scanner(sc.nextLine());			
			film.setType(sc2.next());
			film.setFresh(sc2.nextBoolean());
			film.setSitcom(sc2.nextBoolean());
			film.setNum(sc2.nextInt());
			film.setDay(sc2.nextInt());
			list.add(film);
			sc2.close();
		}
		sc.close();
	}
}

//计算器
class Calculator
{
	private double ans=0;
	public Calculator(ArrayList<Film> list)
	{
		for(Film tmp:list)
		{
			double fee;
			fee = 2*tmp.getDay();
			if(tmp.getDay()>=2)
			{
				fee += 2*(tmp.getDay()-2);
			}
			//如果是新片加价
			if(tmp.isFresh()&&tmp.getDay()>1)
			switch(tmp.getType())
			{
			case "欧美片": fee++;break;
			case "日韩片": break;
			case "大陆片": break;
			case "动画片": fee++;break;
			case "其他外国片":break;
			default:break;
			}
			if(tmp.isSitcom())
			{
				fee *= Math.ceil(tmp.getNum()/3.0);
			}
			else
			{
				fee *= tmp.getNum();
			}
			this.ans += fee;
		}
	}
	public double getAns() {
		return ans;
	}
}

//影片类
class Film
{
	private String type;//影片类型
	private boolean fresh;//是否为新片
	private boolean sitcom;//是否为连续剧
	private int day;//天数
	private int num;//部数
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isFresh() {
		return fresh;
	}
	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}
	public boolean isSitcom() {
		return sitcom;
	}
	public void setSitcom(boolean sitcom) {
		this.sitcom = sitcom;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
