package com.object.oriented;

/***
 * ����ҵ���¼��
 */
public class MovieLease {
	private String[] movieType=null;	//ӰƬ���ͣ�����μ���Ŀ
	private int leaseDays=0;		//����
	private int amount=0;			//���޼���
		
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