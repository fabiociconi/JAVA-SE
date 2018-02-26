package fabiociconi_comp228lab6;

/*
	ThreadTest.java
	
	Author: Marveo/Fabio

	Illustrates use of wait() and notify/notifyAll to do blocking of 
	a thread.
Update example ThreadTest.java from week-12 as follows. 
Add another thread class TvBill that will deduct $10
every 200 milliseconds.

When Account object does not have balance, both threads 
PhoneBill and TvBill should be waiting and once balance > 0, both threads should 
start deducting bill amount.

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//
// Main class which creates threads and objects.
//
public class FabioCiconi_COMP228lab6 {
	public static void main(String s[]) {
		Account acnt    = new Account();
		PhoneBill pb    = new PhoneBill(acnt);
                TvBill tv       = new TvBill(acnt);  
		Payroll pr      = new Payroll(acnt);
                                     
		ExecutorService ex = Executors.newCachedThreadPool();
		ex.execute(pb);
		ex.execute(pr);
                ex.execute(tv);
		ex.shutdown();
	}
}

//
// Account - a class which holds the balance amount and method to
// debit from and credit to the account. When a thread enters either
// debit or credit, the object of this class will be locked and no
// other thread will be able to access it.
class Account {
	private int balance = 0;

	// Synchronized, so only one thread will enter the method.
	synchronized void debit(int amnt, String desc) {
		// if money is there then deduct it.
		if (balance >= amnt) {
			balance = balance - amnt;
			System.out.println(String.format("Debit Description %s - Debit value: %s",desc, balance));
		} else // if money is not available then block i.e wait
		{
			System.out.println(String.format("Waiting..%s",desc));
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Synchronized, so only one thread will enter the method.
	// Add money to the balance.
	synchronized void credit(int amnt, String desc) {
		balance = balance + amnt;
		System.out.println(String.format("Credit Description %s - Credit value: %s",desc, balance));
		notifyAll(); // Make all waiting threads ready.
	}
}

//
// PhoneBill - thread will attempts to debit the account every 200 ms.
//
class PhoneBill implements Runnable {
	private Account accnt;

	PhoneBill(Account a) {
		accnt = a;
	}

        @Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
                                
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
                       // System.out.println("PhoneBill");
			accnt.debit(10,"Phone");
		}
	}
}

class TvBill implements Runnable 
{
    private  Account accnt;

    public TvBill(Account accnt) {
        this.accnt = accnt;
    }

      
    @Override
    public void run() 
    {
        while(true)
        {
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
//            System.out.println("TVBILL");
            accnt.debit(24, "TV bill");
        }
       
        
    }
}

//
// Payroll - thread which adds money to the account every 8000 ms.
//
class Payroll implements Runnable {
	private Account accnt;

	Payroll(Account a) {
		accnt = a;
	}

        @Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(8000);
			} catch (Exception e) {
				e.printStackTrace();
			}
                        System.out.println("Payroll");
			accnt.credit(400, "Payroll");
		}
	}
}
