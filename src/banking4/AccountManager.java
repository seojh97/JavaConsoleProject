package banking4;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class AccountManager{
	
//public static Account[] accArray = new Account[50];
//static int numofAccounts = 0;
	Set<Account> accountSet = new HashSet<Account>();
	
//public AccountManager(int num) {
//	accArray = new Account[num];
//	numofAccounts = 0;
//}
	public void showMenu() 
	{
		System.out.println("------Menu------");
		System.out.println("================================================================");
		System.out.print("1. 계좌개설 ");
		System.out.print("2. 입 금 ");
		System.out.print("3. 출 금 ");
		System.out.print("4. 계좌정보출력 ");
		System.out.print("5. 계좌정보삭제 ");
		System.out.println("6. 프로그램종료 ");
		System.out.println("================================================================");
		System.out.print("선택: ");
	}

	//계좌 생성
	public void makeAccount() {
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
		
		
		accountSet.add(acc);
//		accArray[numofAccounts++]=acc;
		System.out.println("계좌개설이 완료되었습니다.");
		
	}
	
	//입금
	public void depoitMoney() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");
		String accountNumber = scan.nextLine();
		int money;
		while(true) {
			try {
				System.out.print("입금액: ");
				money = scan.nextInt();
				scan.nextLine();
				break;
			}
			catch(InputMismatchException e){
				scan.nextLine();
				System.out.println("숫자만 입력하세요.");
			}
		}
		if(money<0) {
			System.out.println("음수를 입력할 수 없습니다.");
		}
		else if(money%500!=0) {
			System.out.println("500원 단위로 입력해주세요.");
		}
		else {
			for(Account ac : accountSet) {
				if (ac.getAccountNumber().equals(accountNumber)) {
					ac.plusAccmoney(money);
					System.out.println("입금이 완료되었습니다.");	
					return;
				}
			}
			System.out.println("존재하지 않는 계좌번호 입니다.");

			}
		}
		

	//출금
	public void withdrawMoney() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호: ");
		String accountNumber = scan.nextLine();
		
		int money;
		while(true) {
			try {
				System.out.print("출금액: ");
				money = scan.nextInt();
				scan.nextLine();
				break;				
			}
			catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("숫자만 입력하세요.");
			}
		}
		if(money<0) {
			System.out.println("음수를 입력할 수 없습니다.");
		}
		else if(money%1000!=0) {
			System.out.println("1000원 단위로 입력하세요.");
			return;
		}
		
		boolean showAccInfo = false;
		
        for (Account ac : accountSet) {
            if (ac.getAccountNumber().equals(accountNumber)) {
            	showAccInfo = true;

				if (ac.getBalance() < money) {
		            System.out.println("잔고가 부족합니다. 금액 전체를 출금할까요? (Y/N)");
		            String yesOrno = scan.nextLine();
		            if (yesOrno.equalsIgnoreCase("Y")) {
		            	ac.minusAccmoney(ac.getBalance());
		            	ac.setBalance(0);
		                System.out.println("금액 전체 출금 처리 완료");
		            }
		            else if (yesOrno.equalsIgnoreCase("N")) {
		                System.out.println("출금 요청 취소");
		            }
		            else {
		                System.out.println("Y/N중 입력해주세요.");
		            }
		        }
				else {
					ac.minusAccmoney(money);
		            System.out.println("출금이 완료되었습니다.");
		        }
		        break;
		    }
		}
	}

	//계좌 조회
	public void accountInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("===============");
		for (Account ac : accountSet) {
			ac.accountInfo();
			}
		System.out.println("===============");
	    System.out.println("전체계좌정보 출력이 완료되었습니다.");
			//System.out.println(
			//		accountArray[i].getAccountNumber() + "\t" + accountArray[i].getName() + "\t" + accountArray[i].getBalance());
	}
	
	//계좌 정보 삭제
	public void accDelete() {
		
	}
}

