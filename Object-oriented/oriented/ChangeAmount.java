package com.object.oriented;

/**
 * �õ����������������
 */
class ChangeAmount {
	public int calculate(MovieLease tmp)
	{
		int rtn = 0;
		if(tmp.getMovieType()[2] == "������" && tmp.getMovieType()[1] != "�����ٶ�")
		{
			rtn = (int)(Math.ceil(tmp.getAmount()/3.0));
		}else
		{
			rtn = tmp.getAmount();
		}
		return rtn;
	}	
}