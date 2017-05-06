package com.test;

public abstract class TestBadBase extends TestBase {
	
	@Override
	public boolean test(ICalculateRentAndDeposit myObj){
		try {

			Result result = myObj.calculate(leaseList, member);
			if (answer.equals(result)) {
				return false;
			} else {
				return true;
			}
		} catch (LeaseException e) {
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

}
