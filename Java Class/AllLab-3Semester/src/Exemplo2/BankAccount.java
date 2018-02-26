package Exemplo2;

/**
 *
 * @author ZeusAC
 */
public class BankAccount

{
    private final int    AccountNumber_Bank;
    private final String FirstName_Bank;
    private double Balance_Bank;
//    private final char Depo_or_Wit_Bank;
    private final double Value_Bank;
//contructor	accountnumber,firstName,deporwith,value);

    /**
     *
     * @param Aux_Accont
     * @param Aux_Name
     * @param Aux_Dep_Wit
     * @param Aux_Values
     * @param Aux_Balance
     */
    public BankAccount(int Aux_Accont, String Aux_Name, char Aux_Dep_Wit, double Aux_Values, double Aux_Balance)
    {
	AccountNumber_Bank  = Aux_Accont;
	FirstName_Bank      = Aux_Name;
 	Balance_Bank        = Aux_Balance;
 //       Depo_or_Wit_Bank    = Aux_Dep_Wit;
        Value_Bank          = Aux_Values;
    }

    /**
     *
     * @param Aux_Values
     */
    public void deposit(double Aux_Values)
    {
	Balance_Bank = Balance_Bank + Aux_Values;
    }

    /**
     *
     * @param Aux_Values
     */
    public void withdraw(double Aux_Values)
    {
	Balance_Bank = Balance_Bank - Aux_Values;
    }
	   
    /**
     *
     * @param Aux_Accont
     */
    public void SetAccountNumber(int Aux_Accont)
    {
	Aux_Accont = AccountNumber_Bank;
    }

    /**
     *
     * @return
     */
    public int GetAccountNumber()
    {
    	return AccountNumber_Bank;
    }

    /**
     *
     * @param Aux_Name
     */
    public void SetafirstName(String Aux_Name)
    {
        Aux_Name = FirstName_Bank;
    }

    /**
     *
     * @return
     */
    public String GetFirstName()
    {
    	return FirstName_Bank;
    }

    /**
     *
     * @param bal
     */
    public void SetBalance(double bal)
    {
        bal = Balance_Bank;
    }

    /**
     *
     * @return
     */
    public double getbalance()
    {
    	return Balance_Bank;
    }

    /**
     *
     * @param vl
     */
    public void SetValue(double vl)
    {
        vl = Value_Bank;
    }

    /**
     *
     * @return
     */
    public double GetValue()
    {
        return Value_Bank;
    }

    /**
     *
     * @return
     */
    public String GetAccountInfo()
    {
    	String Info = String.format("Cliente informationn : %n "
                                   + "Accountnumber : %d%n"
                                   + "Name: %s%n"
                                   + "Balance: %s%n"
                                   + "Value: %s%n",
                AccountNumber_Bank, FirstName_Bank,Balance_Bank,Value_Bank  );
    	
    	return Info;
    }

}
