package com.object.oriented;


/**
 * ��Ա��ݶ����ۿ۵�Ӱ��
 */
class MemberEffect {
	public double count(Member member)
	{
		//�жϻ�Ա���
		int type = 0;
		type = this.type(member, type);
		//���ڲ�ͬ��ݵĻ�Ա�������ۿ��ж�
		double rtn = 0.0;
		switch(type)
		{
			case 0:rtn=1;break;
			case 1:rtn=0.9;break;
			case 2:rtn=0.7;break;
			default :
				throw new LeaseException("��Ա����������������ԣ�");
		}
		return rtn;
	}
	//�жϻ�Ա��ݵķ���
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