package banking2;

import java.util.Scanner;

public class AccountManager {
	
public static Account[] accArray = new Account[50];
static int numofAccounts = 0;
	
public AccountManager(int num) {
	accArray = new Account[num];
	numofAccounts = 0;
}

	public static void showMenu() {
		System.out.println("------Menu------");
		System.out.println("===================================================");
		System.out.print("1. 계좌개설 ");
		System.out.print("2. 입 금 ");
		System.out.print("3. 출 금 ");
		System.out.print("4. 계좌정보출력 ");
		System.out.println("5. 프로그램종료 ");
		System.out.println("===================================================");
		System.out.print("선택: ");
		
	}

	//계좌 생성
	public static void makeAccount() {
		//String accountNumber, name, balance;
		Scanner scan = new Scanner(System.in);
		System.out.println("===============");
		System.out.println("***신규계좌개설***");
		System.out.println("===============");
		System.out.print("1.보통계좌 ");
		System.out.println("2.신용신뢰계좌");
		System.out.print("선택:");
		int choice = scan.nextInt();
		scan.nextLine();
		
		System.out.print("계좌번호: ");
		String accountNumber = scan.nextLine();

		System.out.print("고객이름: ");
		String name = scan.nextLine();
		
		//nextInt() 다음 nextLine()을 사용
		System.out.print("잔고: ");
		int balance = scan.nextInt();
		scan.nextLine();
		
		System.out.print("기본이자: ");
		int inter = scan.nextInt();
		scan.nextLine();
		
		Account acc = null;
		
		switch(choice) {
		case 1:
			acc = new NormalAccount(accountNumber,name,balance,inter);
			break;

		case 2:
			System.out.print("신용등급(A,B,C등급):");
			String highcredit = scan.nextLine(); 
			acc = new HighCreditAccount(accountNumber,name,balance,inter,highcredit);
			break;
		}
		
		accArray[numofAccounts++]=acc;
		System.out.println("계좌개설이 완료되었습니다.");
		
//		if(choice==1) {
//			System.out.println("계좌번호: ");
//			String accountNumber = scan.nextLine();
//
//			System.out.print("고객이름: ");
//			String name = scan.nextLine();
//
//			System.out.print("잔고: ");
//			int balance = scan.nextInt();
//			
//			System.out.println("기본이자: ");
//			int inter = scan.nextInt();
//			
//			NormalAccount normal = new NormalAccount(accountNumber, name, balance, inter);
//			accArray[numofAccounts++]= normal;
//			
//		}
//		else if(choice==2) {
//			System.out.println("계좌번호: ");
//			String accountNumber = scan.nextLine();
//
//			System.out.print("고객이름: ");
//			String name = scan.nextLine();
//
//			System.out.print("잔고: ");
//			int balance = scan.nextInt();
//			
//			System.out.println(": ");
//			int inter = scan.nextInt();
//		}
		
//		for (int i = 0; i < accArray.length; i++) {
//			if (accArray[i] == null) {
//				accArray[i] = new Account(accountNumber, name, balance);
//				System.out.println("계좌개설이 완료되었습니다.");
//				break;
//			}
//		}
//		System.out.println("***신규계좌개설***");
//		System.out.print("계좌번호: ");accountNumber = scan.nextLine();
//		System.out.print("고객이름: ");name = scan.nextLine();
//		System.out.print("잔고: ");balance = scan.nextLine();
	}
	
	//입금
	public static void depoitMoney() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");
		String accountNumber = scan.nextLine();
		System.out.print("입금액: ");
		int money = scan.nextInt();
		scan.nextLine();
		for (int i=0; i<numofAccounts; i++) {
//			while (accArray[i] != null) {
				if (accArray[i].getAccountNumber().equals(accountNumber)) {
					accArray[i].plusAccmoney(money);
					System.out.println("입금이 완료되었습니다.");
					break;
				}
//			} 
		}
		
	}

	//출금
	public static void withdrawMoney() {
		Scanner scan = new Scanner(System.in);
	
		
		System.out.println("");
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");
		String accountNumber = scan.nextLine();
//		scan.nextInt();
		System.out.print("출금액: ");
		int money = scan.nextInt();
		scan.nextLine();
		
		for (int i=0; i<numofAccounts; i++) {
//			while (accArray[i] != null) {
				if (accArray[i].getAccountNumber().equals(accountNumber)) {
					accArray[i].minusAccmoney(money);
					break;
				}
//			}
		}
		System.out.println("출금이 완료되었습니다.");
	}

	//계좌 조회
	public static void accountInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("==============="); 
		for (int i = 0; i < numofAccounts; i++) {
			accArray[i].accountInfo();
			}
		System.out.println("----------------------");
	    System.out.println("전체계좌정보 출력이 완료되었습니다.");
			//System.out.println(
			//		accountArray[i].getAccountNumber() + "\t" + accountArray[i].getName() + "\t" + accountArray[i].getBalance());
		}
	}

