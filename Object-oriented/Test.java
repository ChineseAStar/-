package com.test;

import java.util.LinkedList;
import java.util.List;

///////////////// 以下部分需要自行完成并拷贝提交 ///////////////////

public class Test implements ICalculateRentAndDeposit {
	private double totalScore=0.0;
	private StringBuilder output= new StringBuilder();
	
	private void doTest(List<ITest> list, ICalculateRentAndDeposit myObj){
		for(ITest itg:list){
			if (itg.test(myObj)) {
				totalScore += 0.5;
			} else {
				output.append(itg.getClass().toString()).append(" failed\n");
			}
		}
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		ICalculateRentAndDeposit myObj = new S2220151693();
		StringBuilder buf = new StringBuilder();

		List<ITest> goodTestList = new LinkedList<ITest>();
		goodTestList.add(new TestGood1());
		goodTestList.add(new TestGood2());
		goodTestList.add(new TestGood3());
		goodTestList.add(new TestGood4());
		goodTestList.add(new TestGood5());
		goodTestList.add(new TestGood6());
		goodTestList.add(new TestGood7());
		goodTestList.add(new TestGood8());
		goodTestList.add(new TestGood9());
		
		t.doTest(goodTestList, myObj);

		System.out.println(buf.toString());
		System.out.printf("==== Final:%f\n", t.totalScore);
		
		List<ITest> badTestList = new LinkedList<ITest>();
		badTestList.add(new TestBad1());
		badTestList.add(new TestBad2());
		badTestList.add(new TestBad5());
		badTestList.add(new TestBad6());
		badTestList.add(new TestBad7());
		badTestList.add(new TestBad8());
		badTestList.add(new TestBad9());
		badTestList.add(new TestBad10());
		
		t.doTest(badTestList, myObj);
		
		System.out.println(buf.toString());
		System.out.printf("==== Final:%f\n", t.totalScore);
	}

	@Override
	public Result calculate(List<MovieLease> leaseList, Member member) {
		throw new RuntimeException("TODO");
	}


}
