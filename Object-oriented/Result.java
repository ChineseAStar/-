package com.test;

public class Result {

	private int sum; //鏈搴旂即璐规�婚
	private Member memberInfo; //鏍规嵁鏀惰垂鎯呭喌淇敼鍚庣殑浼氬憳淇℃伅

	public String toString()
	{
		return "sun="+this.sum+'\t'+this.memberInfo ;
	}
	
	public Member getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(Member memberInfo) {
		this.memberInfo = memberInfo;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null || !(obj instanceof Result)){
			return false;
		}
		
		Result ro=(Result)obj;
		if(this.memberInfo!=null && this.sum==ro.sum && this.memberInfo.equals(ro.memberInfo)){
			return true;
		}
		return false;
	}
}
