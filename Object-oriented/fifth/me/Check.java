package com.test.me;

import java.util.List;

import com.test.*;
import com.test.type.*;
/**
 * 检查各种bug和错误
 */
public class Check {
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