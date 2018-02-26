package newpackage;



import java.util.Scanner;

public class Addition {
	
	public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		
		int number1;
		int number2;
		int sum;
		String name;
		
		System.out.print("Enter Name:");
		name = input.next();
		System.out.printf("My name is %s \n", name);
		System.out.print("Enter First number:");
		number1 = input.nextInt();
		System.out.print("Enter Second Number:");
		number2 = input.nextInt();
		sum = number1 + number2;
		System.out.printf("Sum is %d%n", sum);
		input.close();
	}

}
