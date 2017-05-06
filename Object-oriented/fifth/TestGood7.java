package com.test;
import com.test.type.*;


/***
 * "国产片","动作科幻","电影","非新片"/7天/1部
 * "国产片","动作科幻","电影","非新片"/7天/1部
 * 结果：押金20*2， 收费14*2
 */
public class TestGood7 extends TestGoodBase {
	public TestGood7(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeChina(), new ContentTypeAction(), new LengthTypeMovie(), new StatusTypeUsed() });
		mv.setAmount(1);
		mv.setLeaseDays(7);

		MovieLease mv2 = new MovieLease();
		mv2.setMovieType(new TypeBase[] { new NationTypeChina(), new ContentTypeAction(), new LengthTypeMovie(), new StatusTypeUsed() });
		mv2.setAmount(1);
		mv2.setLeaseDays(7);

		leaseList.add(mv);
		leaseList.add(mv2);


		member.setDeposit(0.0);
		member.setTotal(0);


		answer.setSum(28);
		answer.setMemberInfo(new Member(40, 28));

	}
}
