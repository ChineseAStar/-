// By GuRui on 2017-4-24 下午2:08:57
package com.test;

import java.util.List;

import com.test.type.*;

public class S2220151693 implements ICalculateRentAndDeposit {
	
	@Override
	public Result calculate(List<MovieLease> leaseList, Member member) {
		//调用之前检查输入是否有误
		new Check().calculate(leaseList,member);
		//创建接收信息对象
		Result re = new Result();
		//总费用
		double sum = 0.0;
		for(MovieLease tmp:leaseList)
		{
			//影片总费用累计：价格*部数
			sum += new Fee().calculate(tmp) * new ChangeAmount().calculate(tmp);
			//押金累计
			member.setDeposit(member.getDeposit()+new Deposit().calculate(member, tmp));
		}
		//输入总费用：总费用*折扣
		re.setSum((int)Math.floor(sum*new MemberEffect().count(member)));
		//累计会员消费信息
		member.setTotal(member.getTotal()+re.getSum());
		//输出会员信息
		re.setMemberInfo(member);
		return re;
	}
}
/**
 * 得到连续剧的真正部数
 */
class ChangeAmount {
	public int calculate(MovieLease tmp)
	{
		int rtn = 0;
		if(tmp.getMovieType()[2].getTypeName() == "连续剧" && tmp.getMovieType()[1].getTypeName() != "动漫少儿")
		{
			rtn = (int)(Math.ceil(tmp.getAmount()/3.0));
		}else
		{
			rtn = tmp.getAmount();
		}
		return rtn;
	}	
}
/**
 * 检查各种bug和错误
 */
class Check {
	//检查类驱动方法
	public void calculate(List<MovieLease> leaseList, Member member) {
		CheckList(leaseList);
		CheckMember(member);
		for(MovieLease tmp:leaseList)
		{
			CheckMovieLease(tmp);
			CheckNum(tmp);
			CheckNation(tmp);
			CheckType(tmp);
			CheckNew(tmp);
			CheckSeries(tmp);
			CheckBug(tmp,member);
		}
	}
	//对于错误操作的检查方法
	//影片本身的信息错误
	public void CheckMovieLease(MovieLease tmp)
	{
		if(tmp == null)
		{
			throw new LeaseException("影片添加错误！");
		}
	}
	//影片信息所在集合的错误
	public void CheckList(List<MovieLease> leaseList)
	{
		if(leaseList == null || leaseList.isEmpty())
		{
			throw new LeaseException("链表添加错误！");
		}
	}
	//会员身份的错误
	public void CheckMember(Member member)
	{
		if(member == null)
		{
			throw new LeaseException("会员为空！");
		}
	}
	//对于影片类型输入错误的检查方法
	public void CheckNum(MovieLease tmp)
	{
		if(tmp.getMovieType().length<4)
		{
			TypeBase[] tbtmp = new TypeBase[4];
			for(TypeBase tb:tmp.getMovieType())
			{
				if(tb.getClass().getSuperclass().equals(NationType.class))
				{
					tbtmp[0] = tb;
				}
				else if(tb.getClass().getSuperclass().equals(ContentType.class))
				{
					tbtmp[1] = tb;
				}
				else if(tb.getClass().getSuperclass().equals(LengthType.class))
				{
					tbtmp[2] = tb;
				}
				else if(tb.getClass().getSuperclass().equals(StatusType.class))
				{
					tbtmp[3] = tb;
				}else
				{
					throw new LeaseException();
				}
			}
			if(tbtmp[0] == null)
			{
				tbtmp[0] = new NationTypeDefault();
			}
			if(tbtmp[1] == null)
			{
				tbtmp[1] = new ContentTypeDefault();
			}
			if(tbtmp[2] == null)
			{
				tbtmp[2] = new LengthTypeDefault();
			}
			if(tbtmp[3] == null)
			{
				tbtmp[3] = new StatusTypeDefault();
			}
			tmp.setMovieType(tbtmp);
		}
	}
	//国别
	public void CheckNation(MovieLease tmp)
	{
		if(!(tmp.getMovieType()[0] instanceof NationType))
		{
			throw new LeaseException("电影国别输入错误！");
		}
	}
	//种类
	public void CheckType(MovieLease tmp){
		if(!(tmp.getMovieType()[1] instanceof ContentType))
		{
			throw new LeaseException("电影类型输入错误！");
		}
	}
	//连续剧
	public void CheckSeries(MovieLease tmp)
	{		
		if(!(tmp.getMovieType()[2] instanceof LengthType))
		{
			throw new LeaseException("影片连续剧类型输入错误！");				
		}
	}
	//新旧
	public void CheckNew(MovieLease tmp)
	{
		if(!(tmp.getMovieType()[3] instanceof StatusType))
		{
			throw new LeaseException("影片新片类型输入错误！");
		}
	}
	//对于非负性检验的方法
	public void CheckBug(MovieLease tmp,Member member){
		if(tmp.getAmount()<=0)
		{
			throw new LeaseException("错误：影片部数不是正整数！");
		}else if(tmp.getLeaseDays()<=0)
		{
			throw new LeaseException("错误：租借天数不是正整数！");
		}else if(member.getTotal()<0||member.getDeposit()<0)
		{
			throw new LeaseException("错误");
		}
	}
}
/**
 * 押金计算类
 */
class Deposit {
	public double calculate(Member member,MovieLease tmp){
		double rtn = 0.0;
		rtn = 20*tmp.getAmount();
		if(tmp.getMovieType()[3].getTypeName() == "新片")
		{
			rtn += rtn;
		}
		return rtn;
	}
}
/**
 * 租金计算类
 */
class Fee {
	//费用计算驱动方法
	public double calculate(MovieLease tmp)
	{
		double pr =0.0;
		pr = basefee(tmp,pr);
		pr = addfee(tmp,pr);
		return pr;
	}
	//基础费用计算
	public double basefee(MovieLease tmp,double pr)
	{
		pr = 2*tmp.getLeaseDays();
		if(tmp.getLeaseDays()>7)
		{
			pr += 2*(tmp.getLeaseDays()-7);
		}
		return pr;
	}
	//附加费用计算
	public double addfee(MovieLease tmp,double pr) 
	{
		if(tmp.getLeaseDays()>2&&tmp.getMovieType()[3].getTypeName() == "新片")
		{
			pr += (pr-4)*0.5;
		}
		if(tmp.getMovieType()[0].getTypeName() != "国产片" && tmp.getMovieType()[3].getTypeName() == "新片")
		{
			pr += 1;
		}
		return pr;
	}
}
/**
 * 会员身份对于折扣的影响
 */
class MemberEffect {
	public double count(Member member)
	{
		//判断会员身份
		int type = 0;
		type = this.type(member, type);
		//对于不同身份的会员产生的折扣判断
		double rtn = 0.0;
		switch(type)
		{
			case 0:rtn=1;break;
			case 1:rtn=0.9;break;
			case 2:rtn=0.7;break;
			default :
				throw new LeaseException("会员类型输入错误，请重试！");
		}
		return rtn;
	}
	//判断会员身份的方法
	public int type(Member member,int type)
	{
		if(member.getTotal() >= 800)
		{
			type=2;
		}
		else if(member.getTotal() >= 100)
		{
			type=1;
		}
		return type;
	}
}