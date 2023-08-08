package banking1;

import java.util.Scanner;

public class Account {

	private String accountNumber; //계좌번호 
	private String name; //이름
	private int balance; //잔액
	
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

	
	//입금처리
	public boolean plusAccmoney(int money) {
		balance += money;
		return true;
	}
	
	//출금처리
	public void minusAccmoney(int money) {
		balance -= money;
	}
	
	
}
