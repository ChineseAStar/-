package com.object.oriented;


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