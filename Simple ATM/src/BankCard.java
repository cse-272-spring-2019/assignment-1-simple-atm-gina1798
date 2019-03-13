import java.util.ArrayList;

public class  BankCard{
	
	
	private final String cardNumber;
	private double balance;
	private String pincode;
	private AlertBox alertBox=new AlertBox();
	private ArrayList<Transaction> history=new ArrayList<>(5);
	private HomepageLayout homepageLayout;
	private int i;
	
	public BankCard (String cardNumber,String pincode,double balance)
	{
		this.cardNumber=cardNumber;
		this.pincode=pincode;
		this.balance=balance;
	}
	
	public String getCardNumber()
	{
		return cardNumber;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public boolean withdraw(double amount)
	{      
		if(balance>=amount)
		{
		    balance-=amount;
		    
			if(history.size()!=5)
			{
				history.add(new Transaction(amount,"Withdrawl"));
				i=history.size();
				homepageLayout.setHistory(history);
			}
				
			else
			{
				i=5;
				for(int j=0;j<4;j++)
					history.set(j, history.get(j+1));
				history.set(4,new Transaction(amount,"Withdrawl") );
			}
		    return true;
		}
		else
			alertBox.display("Your current balance is SMALLER than the entered amount.");
		return false;	
	}
	
	public void deposit(double amount)
	{
		balance+=amount;
		
		if(history.size()!=5)
		{
			history.add(new Transaction(amount,"Deposit"));
			i=history.size();
			homepageLayout.setHistory(history);	
		}
			
		else
		{
			i=5;
			for(int j=0;j<4;j++)
				history.set(j, history.get(j+1));
			history.set(4,new Transaction(amount,"Deposit") );
		}
			
	}
	
	public double getBalance()
	{
		if(history.size()!=5)
		{
			history.add(new Transaction(balance,"Balance Inquiry"));
			i=history.size();
			homepageLayout.setHistory(history);
		}
			
		else
		{
			i=5;
			for(int j=0;j<4;j++)
				history.set(j, history.get(j+1));
			history.set(4,new Transaction(balance,"Balance Inquiry") );
		}
		return balance;
	}	
	
	public Transaction previous()
	{
		if(i>0) {
			Transaction transaction=history.get(--i);
			return transaction;
		}
		return null;
	}
	
	public Transaction next() {
		if(i<history.size()-1) {
			Transaction transaction=history.get(++i);
			return transaction;
		}
		return null;
	}
		
	public void setHomepageLayout(HomepageLayout homepageLayout) {
		this.homepageLayout = homepageLayout;
	}
	
	public void setHistory(ArrayList<Transaction> history) {
		this.history = history;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public ArrayList<Transaction> getHistory() {
		return history;
	}
	
}
