package com.test;
import com.test.type.*;


/***
 * "国产片","动作科幻","电影","非新片"/1天/1部
 * 结果：
 */
public class TestBad9 extends TestBadBase {
	public TestBad9(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeChina(), new ContentTypeAction(), new LengthTypeMovie(), new StatusTypeUsed() });
		mv.setAmount(1);
		mv.setLeaseDays(1);

		leaseList.add(null); //Error

		member.setDeposit(0.0);
		member.setTotal(0);

		answer.setSum(14);
		answer.setMemberInfo(new Member(20, 14));
	}
}
