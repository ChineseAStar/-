package com.test;

import java.util.LinkedList;
import java.util.List;

/***
 * 租赁业务记录类
 */
class MovieLease {
	private String movieType=null;	//影片类型：欧美片、国产片、日韩片、动画片、其他外国片   之一
	private int leaseDays=0;		//租期
	private int amount=0;			//租赁部数
	private boolean isNew=false;	//是否是新片
	private boolean isSeries=false;	//是否是连续剧
		
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public int getLeaseDays() {
		return leaseDays;
	}
	public void setLeaseDays(int leaseDays) {
		this.leaseDays = leaseDays;
	}
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public boolean isSeries() {
		return isSeries;
	}
	public void setSeries(boolean isSeries) {
		this.isSeries = isSeries;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

/***
 * 会员类
 */
class Member{
	private int memeberType = 0;	//0:非会员， 1:普通会员， 2:VIP会员
	private double deposit = 0;		//预存押金
	private double total = 0;			//消费总额
	public int getMemeberType() {
		return memeberType;
	}
	public void setMemeberType(int memeberType) {
		this.memeberType = memeberType;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
/***
* 租借业务处理异常类
*/
class LeaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public LeaseException(){
		
	}

	public LeaseException(String msg){
		super(msg);
	}
	
	public LeaseException(Exception e){
		super(e);
	}
	
}

///////////////// 以下部分需要自行完成并拷贝提交 ///////////////////

public class Test implements ICalculateRent{ //类名需修改为S+学号形式

	public static void main(String[] args){
		Test t=new Test();
		MovieLease mv=new MovieLease();
		mv.setMovieType("国产片");
		mv.setAmount(2);
		mv.setLeaseDays(2);
		mv.setNew(false);
		mv.setSeries(false);
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		Member m = new Member();
		m.setDeposit(100.0);
		m.setMemeberType(0);
		m.setTotal(0.0);
		System.out.printf("此次租赁应收费：%d元",t.calculate(mlist,m));
	}
	
	@Override
	public int calculate(List<MovieLease> leaseList, Member member) {
		// TODO 完成此方法
		return 0;
	}


}


/*
//测试代码:
	private int checkOutput(ICalculateRent calculator, StringBuilder buf){
		int total=0;
		total += this.testMovieType(calculator, buf);
		total += this.testZeroAmount(calculator, buf);
		total += this.testZeroDays(calculator, buf);
		total += this.testMemberType(calculator, buf);
		total += this.testNonMemberFee(calculator, buf);
		total += this.testMemberFee(calculator, buf);
		total += this.testVIPFee(calculator, buf);
		total += this.testSeriesNonMember(calculator, buf);
		if(total >=10.0){
			buf.append(" √ 测试全部通过。恭喜!");
		}
		return total;
	}
	
	private int testMovieType(ICalculateRent calculator, StringBuilder buf){
		MovieLease mv=new MovieLease();
		mv.setAmount(1);
		mv.setLeaseDays(1);
		mv.setNew(false);
		mv.setSeries(false);
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		Member m = new Member();
		m.setDeposit(100.0);
		m.setMemeberType(0);
		m.setTotal(0.0);
		
		int score = 0;
		int rst=-1;
		boolean failed=false;
		//欧美片、国产片、日韩片、动画片、其他外国片
		try{
			mv.setMovieType(null);
			rst=calculator.calculate(mlist,m);
			if(rst>0){failed=true;}
			mv.setMovieType("不知名");
			rst=calculator.calculate(mlist,m);
			if(rst>0){failed=true;}
			
			mv.setMovieType("欧美片");
			rst=calculator.calculate(mlist,m);
			if(rst<=0){failed=true;}
			mv.setMovieType("国产片");
			rst=calculator.calculate(mlist,m);
			if(rst<=0){failed=true;}
			mv.setMovieType("日韩片");
			rst=calculator.calculate(mlist,m);
			if(rst<=0){failed=true;}
			mv.setMovieType("动画片");
			rst=calculator.calculate(mlist,m);
			if(rst<=0){failed=true;}
			mv.setMovieType("其他外国片");
			rst=calculator.calculate(mlist,m);
			if(rst<=0){failed=true;}
		}catch(Throwable e){
			failed=true;
		}
		
		if(failed){
			buf.append("影片类型测试失败。注意必须考虑所有可能，并且不能错一个字\n");
		}else{
			buf.append(" √ 影片类型测试通过\n");
			score = 1;
		}
		return score;
	}
	
	private int testZeroAmount(ICalculateRent calculator, StringBuilder buf){
		MovieLease mv=new MovieLease();
		mv.setMovieType("日韩片");
		mv.setAmount(0); //Zero
		mv.setLeaseDays(1);
		mv.setNew(false);
		mv.setSeries(false);
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		Member m = new Member();
		m.setDeposit(100.0);
		m.setMemeberType(0);
		m.setTotal(0.0);
		
		int score = 0;
		boolean failed=false;
		try{
			calculator.calculate(mlist,m);
			failed=true;
		}catch(LeaseException e){
			score=1; //passed!
		}catch(Throwable e){
			failed=true;
		}
		
		if(failed){
			buf.append("影片数量（部数）测试失败\n");
		}else{
			buf.append(" √ 影片数量（部数）测试通过\n");
			score = 1;
		}
		return score;
	}
	
	private int testZeroDays(ICalculateRent calculator, StringBuilder buf){
		MovieLease mv=new MovieLease();
		mv.setMovieType("日韩片");
		mv.setAmount(1); 
		mv.setLeaseDays(0); //Zero
		mv.setNew(false);
		mv.setSeries(false);
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		Member m = new Member();
		m.setDeposit(100.0);
		m.setMemeberType(0);
		m.setTotal(0.0);
		
		int score = 0;
		boolean failed=false;
		try{
			calculator.calculate(mlist,m);
			failed=true;
		}catch(LeaseException e){
			score=1; //passed!
		}catch(Throwable e){
			failed=true;
		}
		
		if(failed){
			buf.append("影片租借天数测试失败\n");
		}else{
			buf.append(" √ 影片租借天数测试通过\n");
			score = 1;
		}
		return score;
	}
	
	private int testMemberType(ICalculateRent calculator, StringBuilder buf){
		MovieLease mv=new MovieLease();
		mv.setMovieType("日韩片");
		mv.setAmount(1); 
		mv.setLeaseDays(1);
		mv.setNew(false);
		mv.setSeries(false);
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		Member m = new Member();
		m.setDeposit(100.0);
		m.setMemeberType(-1);  //Wrong
		m.setTotal(0.0);
		
		int score = 0;
		boolean failed=false;
		try{
			calculator.calculate(mlist,m);
			failed=true;
		}catch(LeaseException e){
			score=1; //passed!
		}catch(Throwable e){
			failed=true;
		}
		
		if(failed){
			buf.append("会员类型测试失败\n");
		}else{
			buf.append(" √ 会员类型测试通过\n");
			score = 1;
		}
		return score;
	}	
	
	private int testNonMemberFee(ICalculateRent calculator, StringBuilder buf){
		MovieLease mv=new MovieLease(); //2元
		mv.setMovieType("欧美片");
		mv.setAmount(1);
		mv.setLeaseDays(1);
		mv.setNew(true);
		mv.setSeries(false);
		
		MovieLease mv2=new MovieLease(); //6元
		mv2.setMovieType("国产片"); 
		mv2.setAmount(1);
		mv2.setLeaseDays(2);
		mv2.setNew(true);
		mv2.setSeries(false);
		
		MovieLease mv3=new MovieLease(); //22元
		mv3.setMovieType("动画片"); 
		mv3.setAmount(2);
		mv3.setLeaseDays(3);
		mv3.setNew(true);
		mv3.setSeries(false);
		
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		mlist.add(mv2);
		mlist.add(mv3);
		
		Member m = new Member();
		m.setMemeberType(0);
		m.setTotal(0.0);
		
		int score = 0;
		int rst=-1;
		boolean failed=false;
		//欧美片、国产片、日韩片、动画片、其他外国片
		try{
			rst = calculator.calculate(mlist, m);
			if(rst!=(2+6+22)){
				failed=true;
			}
		}catch(Throwable e){
			failed=true;
		}
		
		if(failed){
			buf.append("普通会员计费测试失败\n");
		}else{
			buf.append(" √ 普通会员计费测试通过\n");
			score = 1;
		}
		return score;
	}
	
	private int testMemberFee(ICalculateRent calculator, StringBuilder buf){
		MovieLease mv=new MovieLease(); //4元
		mv.setMovieType("欧美片");
		mv.setAmount(2);
		mv.setLeaseDays(1);
		mv.setNew(true);
		mv.setSeries(false);
		
		MovieLease mv2=new MovieLease(); //12元
		mv2.setMovieType("国产片"); 
		mv2.setAmount(2);
		mv2.setLeaseDays(2);
		mv2.setNew(true);
		mv2.setSeries(false);
		
		MovieLease mv3=new MovieLease(); //8元
		mv3.setMovieType("动画片"); 
		mv3.setAmount(1);
		mv3.setLeaseDays(3);
		mv3.setNew(false);
		mv3.setSeries(false);
		
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		mlist.add(mv2);
		mlist.add(mv3);
		
		Member m = new Member();
		m.setMemeberType(1);
		m.setTotal(0.0);
		
		int score = 0;
		int rst=-1;
		boolean failed=false;
		//欧美片、国产片、日韩片、动画片、其他外国片
		try{
			rst = calculator.calculate(mlist, m);
			if(rst!=21){ //(4+12+8)*0.9=21.6
				failed=true;
			}
		}catch(Throwable e){
			failed=true;
		}
		
		if(failed){
			buf.append("非会员计费测试失败\n");
		}else{
			buf.append(" √ 非会员计费测试通过\n");
			score = 1;
		}
		return score;
	}
	
	private int testVIPFee(ICalculateRent calculator, StringBuilder buf){
		MovieLease mv=new MovieLease(); //4元
		mv.setMovieType("欧美片");
		mv.setAmount(2);
		mv.setLeaseDays(1);
		mv.setNew(true);
		mv.setSeries(false);
		
		MovieLease mv2=new MovieLease(); //12元
		mv2.setMovieType("国产片"); 
		mv2.setAmount(2);
		mv2.setLeaseDays(2);
		mv2.setNew(true);
		mv2.setSeries(false);
		
		MovieLease mv3=new MovieLease(); //8元
		mv3.setMovieType("动画片"); 
		mv3.setAmount(1);
		mv3.setLeaseDays(3);
		mv3.setNew(false);
		mv3.setSeries(false);
		
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		mlist.add(mv2);
		mlist.add(mv3);
		
		Member m = new Member();
		m.setMemeberType(2);
		m.setTotal(0.0);
		
		int score = 0;
		int rst=-1;
		boolean failed=false;
		//欧美片、国产片、日韩片、动画片、其他外国片
		try{
			rst = calculator.calculate(mlist, m);
			if(rst!=16){ //(4+12+8)*0.7=16.8
				failed=true;
			}
		}catch(Throwable e){
			failed=true;
		}
		
		if(failed){
			buf.append("VIP计费测试失败\n");
		}else{
			buf.append(" √ VIP计费测试通过\n");
			score = 1;
		}
		return score;
	}
		
	private int testSeriesNonMember(ICalculateRent calculator, StringBuilder buf){
		MovieLease mv=new MovieLease(); //2元
		mv.setMovieType("欧美片");
		mv.setAmount(3);
		mv.setLeaseDays(1);
		mv.setNew(true);
		mv.setSeries(true);
		
		MovieLease mv2=new MovieLease(); //4元
		mv2.setMovieType("国产片"); 
		mv2.setAmount(4);
		mv2.setLeaseDays(2);
		mv2.setNew(false);
		mv2.setSeries(true);
		
		List<MovieLease> mlist=new LinkedList<MovieLease>();
		mlist.add(mv);
		mlist.add(mv2);
		
		Member m = new Member();
		m.setMemeberType(0);
		m.setTotal(0.0);
		
		int score = 0;
		int rst=-1;
		boolean failed=false;
		//欧美片、国产片、日韩片、动画片、其他外国片
		try{
			rst = calculator.calculate(mlist, m);
			if(rst!=6){ //(2+4)=6
				failed=true;
			}
		}catch(Throwable e){
			failed=true;
		}
		
		if(failed){
			buf.append("非会员连续剧计费测试失败\n");
		}else{
			buf.append(" √ 非会员连续剧计费测试通过\n");
			score = 1;
		}
		return score;
	}
*/
