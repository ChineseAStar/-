package com.test;
import com.test.type.*;


/***
 * "国产片","动漫少儿","连续剧","非新片"/2天/4集
 * 结果：押金80， 收费16*0.9=14
 */
public class TestGood5  extends TestGoodBase{
	public TestGood5(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeChina(), new ContentTypeCartoon(), new LengthTypeSeries(), new StatusTypeUsed() });
		mv.setAmount(4);
		mv.setLeaseDays(2);

		leaseList.add(mv);
		
		member.setDeposit(0.0);
		member.setTotal(200);

		answer.setSum(14);
		answer.setMemberInfo(new Member(80, 214));
	}
}
