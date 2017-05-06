package com.test;
import com.test.type.*;


/***
 * "日韩片","动漫少儿","连续剧","新片"/3天/2部
 * 结果：押金80， 收费 2*[4+2*1.5+1]=16*0.7=11
 */
public class TestGood6  extends TestGoodBase{
	public TestGood6(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeEastern(), new ContentTypeCartoon(), new LengthTypeSeries(), new StatusTypeNew() });
		mv.setAmount(2);
		mv.setLeaseDays(3);

		
		leaseList.add(mv);

		
		member.setDeposit(0.0);
		member.setTotal(1000);

		
		answer.setSum(11);
		answer.setMemberInfo(new Member(80, 1011));
	}
}
