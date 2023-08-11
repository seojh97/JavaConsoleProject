package banking2;

public class NormalAccount extends Account{
	double inter;
	
	//생성자
	public NormalAccount(String accountNumber, String name, int balance, int inter) {
		super(accountNumber, name, balance);
		this.inter=inter/100.0;
	}
	 
	public double getNormal() {
		return inter;
	}

	public void setNormal(int normal) {
		this.inter = normal;
	}
	
	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("기본이자: "+ (int)(inter*100)+"%");
	}
	
	@Override
	public boolean plusAccmoney(int money) {
		super.balance=(int)(super.balance+(super.balance*inter)+money);
		return true;
	}

}
