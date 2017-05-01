package com.object.oriented;


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
		if(tmp.getLeaseDays()>2&&tmp.getMovieType()[3] == "新片")
		{
			pr += (pr-4)*0.5;
		}
		if(tmp.getMovieType()[0]!="国产片" && tmp.getMovieType()[3] == "新片")
		{
			pr += 1;
		}
		return pr;
	}
}
