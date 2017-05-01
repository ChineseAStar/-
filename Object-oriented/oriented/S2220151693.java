package com.object.oriented;

import java.util.LinkedList;
import java.util.List;

import finish.ChangeAmount;
import finish.Check;
import finish.Deposit;
import finish.Fee;
import finish.ICalculateRentAndDeposit;
import finish.LeaseException;
import finish.Member;
import finish.MemberEffect;
import finish.MovieLease;
import finish.Result;

/**
 * ��������
 */
public class S2220151693 implements ICalculateRentAndDeposit {

	public static void main(String[] args) {

	}
	
	/**
	 * �ӿ�ʵ�ַ���
	 */
	@Override
	public Result calculate(List<MovieLease> leaseList, Member member) throws LeaseException {
		//����֮ǰ��������Ƿ�����
		new Check().calculate(leaseList,member);
		//����������Ϣ����
		Result re = new Result();
		//�ܷ���
		double sum = 0.0;
		for(MovieLease tmp:leaseList)
		{
			//ӰƬ�ܷ����ۼƣ��۸�*����
			sum += new Fee().calculate(tmp) * new ChangeAmount().calculate(tmp);
			//Ѻ���ۼ�
			member.setDeposit(member.getDeposit()+new Deposit().calculate(member, tmp));
		}
		//�����ܷ��ã��ܷ���*�ۿ�
		re.setSum((int)Math.floor(sum*new MemberEffect().count(member)));
		//�ۼƻ�Ա������Ϣ
		member.setTotal(member.getTotal()+re.getSum());
		//�����Ա��Ϣ
		re.setMemberInfo(member);
		return re;
	}
}
/**
 * �Ʒѽӿ�
 */
interface ICalculateRentAndDeposit
{

	Result calculate(List<MovieLease> leaseList, Member member);
	
}