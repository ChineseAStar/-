package com.object.oriented;

/***
 * 会员类
 */
public class Member{
	private String memberName="tester"; 		//无用
	private String mobile="13911111111";		//无用
	private double deposit = 0;		//预存押金
	private double total = 0;		//消费总额累积

	public Member(){
		
	}

	public Member(double deposit, double total){
		this.deposit=deposit;
		this.total=total;
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj==null || !(obj instanceof Member)){
			return false;
		}
		Member m=(Member)obj;
		if(this.deposit==m.deposit && this.total==m.total){
			return true;
		}
		return false;
	}
	
	
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
