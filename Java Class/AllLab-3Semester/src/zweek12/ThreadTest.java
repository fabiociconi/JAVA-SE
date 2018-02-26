package zweek12;

/*
	ThreadTest.java
	
	Author: Ketan Pandya

	Illustrates use of wait() and notify/notifyAll to do blocking of 
	a thread.

*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//
// Main class which creates threads and objects.
//
public class ThreadTest {
	public static void main(String s[]) {
		Account acnt = new Account();
		PhoneBill pb = new PhoneBill(acnt);
		Payroll pr = new Payroll(acnt);
		
		ExecutorService ex = Executors.newCachedThreadPool();
		ex.execute(pb);
		ex.execute(pr);
		
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
	synchronized void debit(int amnt) {
		// if money is there then deduct it.
		if (balance >= amnt) {
			balance = balance - amnt;
			System.out.println("After debit balance=" + balance);
		} else // if money is not available then block i.e wait
		{
			System.out.println("Waiting..");
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Synchronized, so only one thread will enter the method.
	// Add money to the balance.
	synchronized void credit(int amnt) {
		balance = balance + amnt;
		System.out.println("After credit balance=" + balance);
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

	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			accnt.debit(25);
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

	public void run() {
		while (true) {
			try {
				Thread.sleep(8000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			accnt.credit(400);
		}
	}
}
