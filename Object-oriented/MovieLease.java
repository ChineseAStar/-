// By GuRui on 2017-4-10 下午3:14:49
package com.test;

import com.test.type.TypeBase;

/***
 * 租赁业务记录类
 */
public class MovieLease {
	private TypeBase[] movieType=null;	//影片类型：详情参见题目
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
	public TypeBase[] getMovieType() {
		return movieType;
	}
	public void setMovieType(TypeBase[] movieType) {
		this.movieType = movieType;
	}
	
}