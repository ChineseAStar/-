package com.object.oriented;

import java.util.List;
/**
 * ������bug�ʹ���
 */
class Check {
	//�������������
	public void calculate(List<MovieLease> leaseList, Member member) {
		CheckList(leaseList);
		CheckMember(member);
		for(MovieLease tmp:leaseList)
		{
			CheckMovieLease(tmp);
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
		if(tmp == null || tmp.getMovieType().length != 4)
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
	//����
	public void CheckNation(MovieLease tmp)
	{
		if(!(tmp.getMovieType()[0] == "ŷ��Ƭ" ||tmp.getMovieType()[0] == "����Ƭ" 
				|| tmp.getMovieType()[0] == "�պ�Ƭ" || tmp.getMovieType()[0] == "�������Ƭ")){
			throw new LeaseException("��Ӱ�����������");
		}
	}
	//����
	public void CheckType(MovieLease tmp){
		if(!(tmp.getMovieType()[1] == "�����ƻ�" ||tmp.getMovieType()[1] == "����ϲ��" 
				|| tmp.getMovieType()[1] == "�����ٶ�" || tmp.getMovieType()[1] == "��������"))
		{
			throw new LeaseException("��Ӱ�����������");
		}
	}
	//�¾�
	public void CheckNew(MovieLease tmp)
	{
		if(!(tmp.getMovieType()[3] == "��Ƭ" || tmp.getMovieType()[3] == "����Ƭ"))
		{
			throw new LeaseException("ӰƬ��Ƭ�����������");
		}
	}
	//������
	public void CheckSeries(MovieLease tmp)
	{		
		if(!(tmp.getMovieType()[2] == "������" || tmp.getMovieType()[2] == "��Ӱ"))
		{
			throw new LeaseException("ӰƬ�����������������");				
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