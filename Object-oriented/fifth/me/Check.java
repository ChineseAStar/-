package com.test.me;

import java.util.List;

import com.test.*;
import com.test.type.*;
/**
 * ������bug�ʹ���
 */
public class Check {
	//�������������
	public void calculate(List<MovieLease> leaseList, Member member) {
		CheckList(leaseList);
		CheckMember(member);
		for(MovieLease tmp:leaseList)
		{
			CheckMovieLease(tmp);
			CheckNum(tmp);
			CheckNation(tmp);
			CheckType(tmp);
			CheckNew(tmp);
			CheckSeries(tmp);
			CheckBug(tmp,member);
		}
	}
	//���ڴ�������ļ�鷽��
	//ӰƬ�������Ϣ����
	public void CheckMovieLease(MovieLease tmp)
	{
		if(tmp == null)
		{
			throw new LeaseException("ӰƬ��Ӵ���");
		}
	}
	//ӰƬ��Ϣ���ڼ��ϵĴ���
	public void CheckList(List<MovieLease> leaseList)
	{
		if(leaseList == null || leaseList.isEmpty())
		{
			throw new LeaseException("������Ӵ���");
		}
	}
	//��Ա��ݵĴ���
	public void CheckMember(Member member)
	{
		if(member == null)
		{
			throw new LeaseException("��ԱΪ�գ�");
		}
	}
	//����ӰƬ�����������ļ�鷽��
	public void CheckNum(MovieLease tmp)
	{
		if(tmp.getMovieType().length<4)
		{
			TypeBase[] tbtmp = new TypeBase[4];
			for(TypeBase tb:tmp.getMovieType())
			{
				if(tb.getClass().getSuperclass().equals(NationType.class))
				{
					tbtmp[0] = tb;
				}
				else if(tb.getClass().getSuperclass().equals(ContentType.class))
				{
					tbtmp[1] = tb;
				}
				else if(tb.getClass().getSuperclass().equals(LengthType.class))
				{
					tbtmp[2] = tb;
				}
				else if(tb.getClass().getSuperclass().equals(StatusType.class))
				{
					tbtmp[3] = tb;
				}else
				{
					throw new LeaseException();
				}
			}
			if(tbtmp[0] == null)
			{
				tbtmp[0] = new NationTypeDefault();
			}
			if(tbtmp[1] == null)
			{
				tbtmp[1] = new ContentTypeDefault();
			}
			if(tbtmp[2] == null)
			{
				tbtmp[2] = new LengthTypeDefault();
			}
			if(tbtmp[3] == null)
			{
				tbtmp[3] = new StatusTypeDefault();
			}
			tmp.setMovieType(tbtmp);
		}
	}
	//����
	public void CheckNation(MovieLease tmp)
	{
		if(!(tmp.getMovieType()[0] instanceof NationType))
		{
			throw new LeaseException("��Ӱ�����������");
		}
	}
	//����
	public void CheckType(MovieLease tmp){
		if(!(tmp.getMovieType()[1] instanceof ContentType))
		{
			throw new LeaseException("��Ӱ�����������");
		}
	}
	//������
	public void CheckSeries(MovieLease tmp)
	{		
		if(!(tmp.getMovieType()[2] instanceof LengthType))
		{
			throw new LeaseException("ӰƬ�����������������");				
		}
	}
	//�¾�
	public void CheckNew(MovieLease tmp)
	{
		if(!(tmp.getMovieType()[3] instanceof StatusType))
		{
			throw new LeaseException("ӰƬ��Ƭ�����������");
		}
	}
	//���ڷǸ��Լ���ķ���
	public void CheckBug(MovieLease tmp,Member member){
		if(tmp.getAmount()<=0)
		{
			throw new LeaseException("����ӰƬ����������������");
		}else if(tmp.getLeaseDays()<=0)
		{
			throw new LeaseException("�����������������������");
		}else if(member.getTotal()<0||member.getDeposit()<0)
		{
			throw new LeaseException("����");
		}
	}
}