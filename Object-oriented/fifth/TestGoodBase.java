package com.test;

public abstract class TestGoodBase extends TestBase{

	@Override
	public boolean test(ICalculateRentAndDeposit myObj){
		try {

			Result result = myObj.calculate(leaseList, member);
			if (answer.equals(result)) {
				return true;
			} else {
				return false;
			}
		} catch (Throwable e) {
			System.out.println("Å×³ö´íÎó");
			return false;
		}
	}
}
