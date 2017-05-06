package com.test;
import com.test.type.*;


/***
 * "其他外国片","综艺音乐","连续剧","新片"/8天/4集
 * 结果：押金160， 收费2*[(4+(10+4)*1.5)+1]=52
 */
public class TestGood4  extends TestGoodBase{
	public TestGood4(){
		MovieLease mv = new MovieLease();
		mv.setMovieType(new TypeBase[] { new NationTypeOtherArea(), new ContentTypeShow(), new LengthTypeSeries(), new StatusTypeNew() });
		mv.setAmount(4);
		mv.setLeaseDays(8);

		leaseList.add(mv);

		member.setDeposit(0.0);
		member.setTotal(0);

		answer.setSum(52);
		answer.setMemberInfo(new Member(160, 52));

	}
}
