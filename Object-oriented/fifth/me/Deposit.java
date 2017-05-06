package com.test.me;

import com.test.*;

/**
 * 押金计算类
 */
public class Deposit {
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
