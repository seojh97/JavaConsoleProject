package banking1;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystemMain {

	//메뉴출력
	public static void showMenu() {
		System.out.println("-----Menu------");
		System.out.println("===================================================");
		System.out.print("1. 계좌개설 ");
		System.out.print("2. 입 금 ");
		System.out.print("3. 출 금 ");
		System.out.print("4. 계좌정보출력 ");
		System.out.println("5. 프로그램종료 ");
		System.out.println("===================================================");
		System.out.print("선택: ");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			showMenu();
			int choice = scan.nextInt();
			switch(choice) {
			case MenuSelectException.MAKE:
				makeAccount();
				break;
			case MenuSelectException.DEPOSIT:
				depoitMoney();
				break;
			case MenuSelectException.WITHDRAW:
				withdrawMoney();
				break;
			case MenuSelectException.INQUIRE:
				showAccInfo();
				break;
			case MenuSelectException.EXIT:
				System.out.println("프로그램종료");
				return;
			}
		}
	}


ArrayList<Account> accounts;
	
	public static Account[] accArray = new Account[50];

	//계좌 생성
	public static void makeAccount() {
//		String accountNumber, name, balance;
		Scanner scan = new Scanner(System.in);
		System.out.println("===============");
		System.out.println("***신규계좌개설***");
		System.out.println("===============");
		System.out.print("계좌번호: ");
		String accountNumber = scan.nextLine();

		System.out.print("고객이름: ");
		String name = scan.nextLine();

		System.out.print("잔고: ");
		int balance = scan.nextInt();
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i] == null) {
				accArray[i] = new Account(accountNumber, name, balance);
				System.out.println("계좌개설이 완료되었습니다.");
				break;
			}
		}
//		System.out.println("***신규계좌개설***");
//		System.out.print("계좌번호: ");accountNumber = scan.nextLine();
//		System.out.print("고객이름: ");name = scan.nextLine();
//		System.out.print("잔고: ");balance = scan.nextLine();
	}
	
	//입금
	public static void depoitMoney() {
		Scanner scan = new Scanner(System.in);
		String accountNumber, name;
		
		System.out.println("");
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");accountNumber = scan.nextLine();
		System.out.print("입금액: ");int money = scan.nextInt();
		for (int i=0; i<accArray.length; i++) {
			while (accArray[i] != null) {
				if (accArray[i].getAccountNumber().equals(accountNumber)) {
					accArray[i].plusAccmoney(money);
					break;
				}
			}
		}
		System.out.println("입금이 완료되었습니다.");
	}

	//출금
	public static void withdrawMoney() {
		Scanner scan = new Scanner(System.in);
		String accountNumber, name;
		
		System.out.println("");
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");accountNumber = scan.nextLine();
		System.out.print("출금액: ");int money = scan.nextInt();
		for (int i=0; i<accArray.length; i++) {
			while (accArray[i] != null) {
				if (accArray[i].getAccountNumber().equals(accountNumber)) {
					accArray[i].minusAccmoney(money);
					break;
				}
			}
		}
		System.out.println("출금이 완료되었습니다.");
	}

	//계좌 조회
	public static void showAccInfo() {
		Scanner scan = new Scanner(System.in);
		String accountNumber, name, balance;
		
		System.out.println("");
		System.out.println("***계좌정보출력***");
		//System.out.println("계좌번호:"+accountNumber);
		//System.out.println("고객이름:"+name);
		System.out.println("===============");
//		for(Account ac : accounts) {
//			ac.showAccInfo();
//		}
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i] == null) {
				break;
			}
			System.out.println("계좌번호: "+accArray[i].getAccountNumber());
			System.out.println("고객이름: "+accArray[i].getName());
			System.out.println("잔고: "+accArray[i].getBalance());
			//System.out.println(
			//		accountArray[i].getAccountNumber() + "\t" + accountArray[i].getName() + "\t" + accountArray[i].getBalance());
		}
	}
}
