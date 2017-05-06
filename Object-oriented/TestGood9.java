package com.test;
import com.test.type.*;


/***
 * "国产片","动作科幻","电影",[缺]/1天/1部
 * 结果：
 */
public class TestGood9 extends TestGoodBase {
	public TestGood9(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeChina(), new ContentTypeAction(), new LengthTypeMovie()});
		mv.setAmount(1);
		mv.setLeaseDays(1);
		
		leaseList.add(mv);

		member.setDeposit(0.0);
		member.setTotal(0);

		answer.setSum(14);
		answer.setMemberInfo(new Member(20, 14));

	}
}
