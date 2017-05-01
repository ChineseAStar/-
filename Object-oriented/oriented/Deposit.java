package com.object.oriented;


/**
 * 押金计算类
 */
class Deposit {
	public double calculate(Member member,MovieLease tmp){
		double rtn = 0.0;
		rtn = 20*tmp.getAmount();
		if(tmp.getMovieType()[3] == "新片")
		{
			rtn += rtn;
		}
		return rtn;
	}
}
