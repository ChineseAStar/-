package com.object.oriented;

import java.util.LinkedList;
import java.util.List;

/**
 * 主驱动类
 */
public class S2220151693 implements ICalculateRentAndDeposit {

	public static void main(String[] args) {

	}
	
	/**
	 * 接口实现方法
	 */
	@Override
	public Result calculate(List<MovieLease> leaseList, Member member) throws LeaseException {
		//调用之前检查输入是否有误
		new Check().calculate(leaseList,member);
		//创建接收信息对象
		Result re = new Result();
		//总费用
		double sum = 0.0;
		for(MovieLease tmp:leaseList)
		{
			//影片总费用累计：价格*部数
			sum += new Fee().calculate(tmp) * new ChangeAmount().calculate(tmp);
			//押金累计
			member.setDeposit(member.getDeposit()+new Deposit().calculate(member, tmp));
		}
		//输入总费用：总费用*折扣
		re.setSum((int)Math.floor(sum*new MemberEffect().count(member)));
		//累计会员消费信息
		member.setTotal(member.getTotal()+re.getSum());
		//输出会员信息
		re.setMemberInfo(member);
		return re;
	}
}
/**
 * 计费接口
 */
interface ICalculateRentAndDeposit
{

	Result calculate(List<MovieLease> leaseList, Member member);
	
}
