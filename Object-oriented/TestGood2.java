package com.test;
import com.test.type.*;


/***
 * "国产片","言情喜剧","电影","非新片"/8天/2部
 * 结果：押金40， 收费36
 */
public class TestGood2 extends TestGoodBase{
	public TestGood2(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeChina(), new ContentTypeDrama(), new LengthTypeMovie(), new StatusTypeUsed() });
		mv.setAmount(2);
		mv.setLeaseDays(8);

		leaseList.add(mv);
		
		member.setDeposit(0.0);
		member.setTotal(0);

		answer.setSum(36);
		answer.setMemberInfo(new Member(40, 36));
	}
}
