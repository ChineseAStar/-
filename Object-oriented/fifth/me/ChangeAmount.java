package com.test.me;

import com.test.*;

/**
 * 得到连续剧的真正部数
 */
public class ChangeAmount {
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