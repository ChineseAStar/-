package com.test.me;

import com.test.*;

/**
 * Ѻ�������
 */
public class Deposit {
	public double calculate(Member member,MovieLease tmp){
		double rtn = 0.0;
		rtn = 20*tmp.getAmount();
		if(tmp.getMovieType()[3].getTypeName() == "��Ƭ")
		{
			rtn += rtn;
		}
		return rtn;
	}
}
