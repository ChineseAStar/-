package com.test;
import com.test.type.*;


/***
 * "国产片","动作科幻","电影","非新片"/7天/1部
 * 结果：押金20， 收费14
 */
public class TestBad10 extends TestBadBase {
	public TestBad10(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeChina(), new ContentTypeAction(), new LengthTypeMovie(), new StatusTypeUsed() });
		mv.setAmount(1);
		mv.setLeaseDays(7);

		leaseList.add(mv);

		member.setDeposit(0.0);
		member.setTotal(-14); // Error

		answer.setSum(14);
		answer.setMemberInfo(new Member(20, 0));
	}
}
