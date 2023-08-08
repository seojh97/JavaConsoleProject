package banking2;

public class HighCreditAccount extends Account{
	double inter;
	String grade;
	
	public HighCreditAccount(String accountNumber, String name, int balance, double inter, String grade) {
		super(accountNumber, name, balance);
		this.inter = inter;
		this.grade = grade;
	}

	public static void main(String[] args) {

	}

}
