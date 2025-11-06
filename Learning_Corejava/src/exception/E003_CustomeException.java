package exception;

class InsufficentFundAmount extends Exception
{
	double d;
	public InsufficentFundAmount(double d) {
		
		super(String.format("Your account need more : %s", d));
		this.d = d;
	}
	
}

class Bank
{
	double balance;
	
	public void checkBalance()
	{
		System.out.println("Cureent balance is : "+balance);
	}
	
	public void deposite(double amt)
	{
		balance+=amt;
	}
	
	
	public void withdrow(double amt) throws InsufficentFundAmount
	{
		if(amt>balance)
		{
			throw new InsufficentFundAmount(amt-balance);
		}
		else
		{
			balance-=amt;
		}
	}
}
public class E003_CustomeException {
	public static void main(String[] args) {
		
		
		Bank b = new Bank();
		b.checkBalance();
		b.deposite(5000);
		b.deposite(2000);
		b.checkBalance();
		try {
			b.withdrow(70000);
		} catch (InsufficentFundAmount e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.checkBalance();
	}
}
