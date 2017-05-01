package com.object.oriented;

import java.util.List;
import java.util.LinkedList;

public class file{
	/***
	 * "����Ƭ","�����ƻ�","��Ӱ","����Ƭ"/7��/1��
	 * �����Ѻ��20�� �շ�14
	 */
	public boolean S2220151693Good1(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","����Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(7);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			Result result=t.calculate(leaseList, member);
			if(answer.equals(result)){
				return true;
			}else{
				return false;
			}
		}catch(Throwable e){
			System.out.println("test");
			return false;
		}
	}
	
	/***
	 * "����Ƭ","����ϲ��","��Ӱ","����Ƭ"/8��/2��
	 * �����Ѻ��40�� �շ�36
	 */
	public boolean S2220151693Good2(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","����ϲ��","��Ӱ","����Ƭ"});
		mv.setAmount(2);
		mv.setLeaseDays(8);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(36);
		answer.setMemberInfo(new Member(40,36));
		
		try{
			S2220151693 t = new S2220151693();
			Result result=t.calculate(leaseList, member);
			if(answer.equals(result)){
				return true;
			}else{
				return false;
			}
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "ŷ��Ƭ","��������","��Ӱ","��Ƭ"/2��/1��
	 * �����Ѻ��40�� �շ�5
	 */
	public boolean S2220151693Good3(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"ŷ��Ƭ","��������","��Ӱ","��Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(2);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(50);
		
		Result answer=new Result();
		answer.setSum(5);
		answer.setMemberInfo(new Member(40,55));
		
		try{
			S2220151693 t = new S2220151693();
			Result result=t.calculate(leaseList, member);
			if(answer.equals(result)){
				return true;
			}else{
				return false;
			}
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "�������Ƭ","��������","������","��Ƭ"/8��/4��
	 * �����Ѻ��80�� �շ�2*[(4+(10+4)*1.5)+1]=52
	 */
	public boolean S2220151693Good4(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"�������Ƭ","��������","������","��Ƭ"});
		mv.setAmount(4);
		mv.setLeaseDays(8);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(52);
		answer.setMemberInfo(new Member(80,52));
		
		try{
			S2220151693 t = new S2220151693();
			Result result=t.calculate(leaseList, member);
			if(answer.equals(result)){
				return true;
			}else{
				System.out.println("��ʦ"+'\t'+'\t'+answer);
				System.out.println("�ҵ�"+'\t'+'\t'+result);
				return false;
			}
		}catch(Throwable e){
			return false;
		}
	}
	
	
	/***
	 * "����Ƭ","�����ٶ�","������","����Ƭ"/2��/4��
	 * �����Ѻ��80�� �շ�16*0.9=14
	 */
	public boolean S2220151693Good5(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ٶ�","������","����Ƭ"});
		mv.setAmount(4);
		mv.setLeaseDays(2);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(200);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(80,214));
		
		try{
			S2220151693 t = new S2220151693();
			Result result=t.calculate(leaseList, member);
			if(answer.equals(result)){
				return true;
			}else{
				return false;
			}
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "�պ�Ƭ","�����ٶ�","������","��Ƭ"/3��/2��
	 * �����Ѻ��80�� �շ� 2*[4+2*1.5+1]=16*0.7=11
	 */
	public boolean S2220151693Good6(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"�պ�Ƭ","�����ٶ�","������","��Ƭ"});
		mv.setAmount(2);
		mv.setLeaseDays(3);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(1000);
		
		Result answer=new Result();
		answer.setSum(11);
		answer.setMemberInfo(new Member(80,1011));
		
		try{
			S2220151693 t = new S2220151693();
			Result result=t.calculate(leaseList, member);
			if(answer.equals(result)){
				return true;
			}else{
				return false;
			}
		}catch(Throwable e){
			return false;
		}
	}
	
	
	/***
	 * "����Ƭ","�����ƻ�","��Ӱ","����Ƭ"/7��/1��
	 * "����Ƭ","�����ƻ�","��Ӱ","����Ƭ"/7��/1��
	 * �����Ѻ��20*2�� �շ�14*2
	 */
	public boolean S2220151693Good7(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","����Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(7);
		
		MovieLease mv2=new MovieLease();
		mv2.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","����Ƭ"});
		mv2.setAmount(1);
		mv2.setLeaseDays(7);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		leaseList.add(mv2);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(28);
		answer.setMemberInfo(new Member(40,28));
		
		try{
			S2220151693 t = new S2220151693();
			Result result=t.calculate(leaseList, member);
			if(answer.equals(result)){
				return true;
			}else{
				return false;
			}
		}catch(Throwable e){
			return false;
		}
	}
	
	////////////////////////////////////////////////////////
	
	/***
	 * "����Ƭ","�����ƻ�","��Ӱ","����Ƭ"/0��/1��
	 * �����
	 */
	public boolean S2220151693Bad1(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","����Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(0);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(leaseList, member);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "����Ƭ","�����ƻ�","��Ӱ","����Ƭ"/1��/0��
	 * �����
	 */
	public boolean S2220151693Bad2(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","����Ƭ"});
		mv.setAmount(0);
		mv.setLeaseDays(1);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(leaseList, member);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "xxx","�����ƻ�","��Ӱ","����Ƭ"/1��/1��
	 * �����
	 */
	public boolean S2220151693Bad3(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"xxx","�����ƻ�","��Ӱ","����Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(1);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(leaseList, member);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "����Ƭ","�����ƻ�","��Ӱ","��Ƭ"/1��/1��
	 * �����
	 */
	public boolean S2220151693Bad4(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","��Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(1);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(leaseList, member);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "����Ƭ","�����ƻ�","��Ƶ","����Ƭ"/1��/1��
	 * �����
	 */
	public boolean S2220151693Bad5(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ƶ","����Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(1);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(leaseList, member);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * null/1��/1��
	 * �����
	 */
	public boolean S2220151693Bad6(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{});
		mv.setAmount(1);
		mv.setLeaseDays(1);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(leaseList, member);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * null,null,null,null/1��/1��
	 * �����
	 */
	public boolean S2220151693Bad7(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{null,null,null,null});
		mv.setAmount(1);
		mv.setLeaseDays(1);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(leaseList, member);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "����Ƭ","�����ƻ�","��Ӱ","����Ƭ"/1��/1��
	 * �����
	 */
	public boolean S2220151693Bad8(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","����Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(1);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(null, null);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "����Ƭ","�����ƻ�","��Ӱ","����Ƭ"/1��/1��
	 * �����
	 */
	public boolean S2220151693Bad9(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","����Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(1);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(null);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(0);
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,14));
		
		try{
			S2220151693 t = new S2220151693();
			t.calculate(leaseList, member);
			return false;
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}
	
	/***
	 * "����Ƭ","�����ƻ�","��Ӱ","����Ƭ"/7��/1��
	 * �����Ѻ��20�� �շ�14
	 */
	public boolean S2220151693Bad10(){
		MovieLease mv=new MovieLease();
		mv.setMovieType(new String[]{"����Ƭ","�����ƻ�","��Ӱ","����Ƭ"});
		mv.setAmount(1);
		mv.setLeaseDays(7);
		
		List<MovieLease> leaseList=new LinkedList<MovieLease>();
		leaseList.add(mv);
		
		Member member = new Member();
		member.setDeposit(0.0);
		member.setTotal(-14);		//Error
		
		Result answer=new Result();
		answer.setSum(14);
		answer.setMemberInfo(new Member(20,0));
		
		try{
			S2220151693 t = new S2220151693();
			Result result=t.calculate(leaseList, member);
			if(answer.equals(result)){
				System.out.println("test");
				return false;
			}else{
				return true;
			}
		}catch(LeaseException e){
			return true;
		}catch(Throwable e){
			return false;
		}
	}	
	
	
}//End of class S22201516935