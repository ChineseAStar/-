package com.object.oriented;

public class Result {

	private int sum; //本次应缴费总额
	private Member memberInfo; //根据收费情况修改后的会员信息

	
	
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