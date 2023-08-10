package banking3;

public class HighCreditAccount extends Account{
	double inter;
	String grade;
	
	public HighCreditAccount(String accountNumber, String name, int balance, double inter, String grade) {
		super(accountNumber, name, balance);
		this.inter = inter / 100.0;
		this.grade = grade;
	}
	
	@Override
	public boolean plusAccmoney(int money) {
//		double itr = getInter() * 0.01;
//		double grd = 0;
//		if(grade=="A") {
//			grd = 0.07;
//		}
//		else if(grade=="B") {
//			grd = 0.04;
//		}
//		else if(grade=="C") {
//			grd = 0.02;
//		}
//		setBalance((int)(getBalance()+(getBalance()*(itr+grd)))+money);
		
		switch (grade) {
		case "A":
			super.balance = (int)(super.balance + (super.balance * inter)+(super.balance * 0.07) + money);
			break;
		case "B":
			super.balance = (int)(super.balance + (super.balance * inter)+(super.balance * 0.04) + money);
			break;
		case "C":
			super.balance = (int)(super.balance + (super.balance * inter)+(super.balance * 0.02) + money);
			break;
		}
		return true;
	}

//	private double getInter() {
//		return 0;
//	}
	
	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("기본이자: "+ (int)(inter*100) +"%");
		System.out.println("신용등급(A,B,C 등급): "+ grade);
	}

}
