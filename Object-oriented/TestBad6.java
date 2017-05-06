package com.test;
import com.test.type.*;


/***
 * null/1天/1部
 * 结果：
 */
public class TestBad6 extends TestBadBase {
	public TestBad6(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] {});
		mv.setAmount(1);
		mv.setLeaseDays(1);

		leaseList.add(mv);

		member.setDeposit(0.0);
		member.setTotal(0);

		answer.setSum(14);
		answer.setMemberInfo(new Member(20, 14));
	}
}
