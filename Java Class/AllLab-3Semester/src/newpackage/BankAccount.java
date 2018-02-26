package newpackage;

public class BankAccount

{
	private int    accountnumber;
	private String firstName;
	private int balance;
	
	BankAccount(int acct, String name, int bal)
	{
		accountnumber  = acct;
		firstName      = name;
		balance        = bal;
	}
	public int saque(int x)
	{
		if (x < balance)		
		{
			balance = balance-x;//error
      
		}
         return balance;
	}
	public void setaccountnumber(int acct)
	{
		acct = accountnumber;
	}
    public int getid()
    {
    	return accountnumber;
    }
    public void setafirstName(String name)
	{
    	name = firstName;
	}
    public String getfirstName()
    {
    	return firstName;
    }
    public void setbalance(int bal)
	{
    	bal = balance;
	}
    public int getbalance()
    {
    	return balance;
    }
    public String getAccountInfo()
    {
    	String info =String.format("Cliente informationn:%n accountnumber:%d%n firstName:%s%n" ,firstName);
    	
    	return info;
    }

}
