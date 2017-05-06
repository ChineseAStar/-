package com.test;

import java.util.LinkedList;
import java.util.List;

public abstract class TestBase implements ITest{
	protected List<MovieLease> leaseList = new LinkedList<MovieLease>();
	protected Member member = new Member();
	protected Result answer = new Result();
}
