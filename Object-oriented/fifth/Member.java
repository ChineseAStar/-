package com.test;

/***
 * 浼氬憳绫�
 */
public class Member{
	private String memberName="tester"; 		//鏃犵敤
	private String mobile="13911111111";		//鏃犵敤
	private double deposit = 0;		//棰勫瓨鎶奸噾
	private double total = 0;		//娑堣垂鎬婚绱Н

	public Member(){
		
	}

	public Member(double deposit, double total){
		this.deposit=deposit;
		this.total=total;
	}
	public String toString()
	{
		return "deposit="+this.deposit+'\t'+"total="+this.total+'\n';
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
