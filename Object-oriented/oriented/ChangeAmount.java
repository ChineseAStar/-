package com.object.oriented;

/**
 * 得到连续剧的真正部数
 */
class ChangeAmount {
	public int calculate(MovieLease tmp)
	{
		int rtn = 0;
		if(tmp.getMovieType()[2] == "连续剧" && tmp.getMovieType()[1] != "动漫少儿")
		{
			rtn = (int)(Math.ceil(tmp.getAmount()/3.0));
		}else
		{
			rtn = tmp.getAmount();
		}
		return rtn;
	}	
}