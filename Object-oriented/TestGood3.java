package com.test;
import com.test.type.*;


/***
 * "欧美片","综艺音乐","电影","新片"/2天/1部
 * 结果：押金40， 收费5
 */
public class TestGood3  extends TestGoodBase{
	public TestGood3(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeWestern(), new ContentTypeShow(), new LengthTypeMovie(), new StatusTypeNew() });
		mv.setAmount(1);
		mv.setLeaseDays(2);

		leaseList.add(mv);

		member.setDeposit(0.0);
		member.setTotal(50);

		answer.setSum(5);
		answer.setMemberInfo(new Member(40, 55));
	}
}
