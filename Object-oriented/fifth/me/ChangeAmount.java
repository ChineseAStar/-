package com.test.me;

import com.test.*;

/**
 * �õ����������������
 */
public class ChangeAmount {
	public int calculate(MovieLease tmp)
	{
		int rtn = 0;
		if(tmp.getMovieType()[2].getTypeName() == "������" && tmp.getMovieType()[1].getTypeName() != "�����ٶ�")
		{
			rtn = (int)(Math.ceil(tmp.getAmount()/3.0));
		}else
		{
			rtn = tmp.getAmount();
		}
		return rtn;
	}	
}