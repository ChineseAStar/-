package com.object.oriented;

import java.util.List;
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
		if(tmp == null || tmp.getMovieType().length != 4)
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
	//国别
	public void CheckNation(MovieLease tmp)
	{
		if(!(tmp.getMovieType()[0] == "欧美片" ||tmp.getMovieType()[0] == "国产片" 
				|| tmp.getMovieType()[0] == "日韩片" || tmp.getMovieType()[0] == "其他外国片")){
			throw new LeaseException("电影国别输入错误！");
		}
	}
	//种类
	public void CheckType(MovieLease tmp){
		if(!(tmp.getMovieType()[1] == "动作科幻" ||tmp.getMovieType()[1] == "言情喜剧" 
				|| tmp.getMovieType()[1] == "动漫少儿" || tmp.getMovieType()[1] == "综艺音乐"))
		{
			throw new LeaseException("电影类型输入错误！");
		}
	}
	//新旧
	public void CheckNew(MovieLease tmp)
	{
		if(!(tmp.getMovieType()[3] == "新片" || tmp.getMovieType()[3] == "非新片"))
		{
			throw new LeaseException("影片新片类型输入错误！");
		}
	}
	//连续剧
	public void CheckSeries(MovieLease tmp)
	{		
		if(!(tmp.getMovieType()[2] == "连续剧" || tmp.getMovieType()[2] == "电影"))
		{
			throw new LeaseException("影片连续剧类型输入错误！");				
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