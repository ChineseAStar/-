package com.object.oriented;


/**
 * ��������
 */
class Fee {
	//���ü�����������
	public double calculate(MovieLease tmp)
	{
		double pr =0.0;
		pr = basefee(tmp,pr);
		pr = addfee(tmp,pr);
		return pr;
	}
	//�������ü���
	public double basefee(MovieLease tmp,double pr)
	{
		pr = 2*tmp.getLeaseDays();
		if(tmp.getLeaseDays()>7)
		{
			pr += 2*(tmp.getLeaseDays()-7);
		}
		return pr;
	}
	//���ӷ��ü���
	public double addfee(MovieLease tmp,double pr) 
	{
		if(tmp.getLeaseDays()>2&&tmp.getMovieType()[3] == "��Ƭ")
		{
			pr += (pr-4)*0.5;
		}
		if(tmp.getMovieType()[0]!="����Ƭ" && tmp.getMovieType()[3] == "��Ƭ")
		{
			pr += 1;
		}
		return pr;
	}
}
