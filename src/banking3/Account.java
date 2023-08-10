package banking3;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account {

	private String accountNumber; //계좌번호 
	private String name; //이름
	int balance; //잔액
	
	public Account(String accountNumber, String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//메뉴출력
	public static void showMenu() {
		System.out.println("-----Menu------");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입 금");
		System.out.println("3. 출 금");
		System.out.println("4. 계좌정보출력");
		System.out.println("5. 프로그램종료");
		System.out.print("선택: ");
	}
	
   public void accountInfo() {
	   System.out.println("계좌번호: "+accountNumber);
	   System.out.println("고객이름: "+name);
	   System.out.println("잔고: "+balance);

	   }
	
	//계좌개설을 위한 함수
	public static void makeAccount() {
		
	}
	
	//입금
	public static void depoitMoney() {
		
	}
	
	//출금
	public static void withdrawMoney() {
		
	}
	
	//전체계좌정보출력
	public static void showAccInfo() {
		
	}
	
	//입금처리
	public boolean plusAccmoney(int money) {
		balance += money;
		return true;
	}
	
	//출금처리
	public boolean minusAccmoney(int money) {
		balance -= money;
		return true;
	}
	
	
}
