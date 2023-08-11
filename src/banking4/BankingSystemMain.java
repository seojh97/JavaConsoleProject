package banking4;

//import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import banking4.MenuChoice;

public class BankingSystemMain{
	public static void showMenu() {
		System.out.println("-----Menu------");
		System.out.println("===================================================");
		System.out.print("1. 계좌개설 ");
		System.out.print("2. 입 금 ");
		System.out.print("3. 출 금 ");
		System.out.print("4. 계좌정보출력 ");
		System.out.print("5. 계좌정보삭제 ");
		System.out.println("6. 프로그램종료 ");
		System.out.println("===================================================");
		System.out.print("선택: ");
	}
	
	public static void main(String[] args) throws MenuSelectException{
		Scanner scan = new Scanner(System.in);
		AccountManager amanager = new AccountManager();
		 
		while(true) {
			amanager.showMenu();
			try {
				int choice = scan.nextInt();
				switch(choice) {
				case MenuChoice.MAKE:
					amanager.makeAccount();
					break;
				case MenuChoice.DEPOSIT:
					amanager.depoitMoney();
					break;
				case MenuChoice.WITHDRAW:
					amanager.withdrawMoney();
					break;
				case MenuChoice.INQUIRE:
					amanager.accountInfo();
					break;
				case MenuChoice.DELETE:
					amanager.accDelete();
					break;
				case MenuChoice.EXIT:
					System.out.println("프로그램종료");
					return;
				default:
					try {
						String msg = "1~6까지의 숫자만 입력 가능합니다.";
						MenuSelectException exam = new MenuSelectException(msg); 
						throw exam;
					}
					catch(MenuSelectException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			catch(InputMismatchException e){
				System.out.println("숫자만 입력 가능합니다.");
				scan.nextLine();
			}
		}
	}
}