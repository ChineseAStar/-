package com.object.oriented;

/***
 * 租赁业务记录类
 */
public class MovieLease {
	private String[] movieType=null;	//影片类型：详情参见题目
	private int leaseDays=0;		//租期
	private int amount=0;			//租赁集数
		
	public int getLeaseDays() {
		return leaseDays;
	}
	public void setLeaseDays(int leaseDays) {
		this.leaseDays = leaseDays;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String[] getMovieType() {
		return movieType;
	}
	public void setMovieType(String[] movieType) {
		this.movieType = movieType;
	}
	
}