package com.test;

import java.util.List;

/***
 * 计费接口
 */
public interface ICalculateRentAndDeposit{
	public Result calculate(List<MovieLease> leaseList, Member member);	//测试运行的计费方法
}