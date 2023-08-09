package banking3;

import java.util.ArrayList;
import java.util.Scanner;

import banking1.MenuChoice;

public class BankingSystemMain {
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
		AccountManager amanager = new AccountManager(50);
		 
		while(true) {
			amanager.showMenu();
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
				amanager.showAccInfo();
				break;
			case MenuChoice.EXIT:
				System.out.println("프로그램종료");
				return;
			}
		}
	}
}