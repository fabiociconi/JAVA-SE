
public class StackTest {
	public static void main(String args[])
	{
		StackLoader loader = new StackLoader();
		loader.foo(20);
	}
}

class StackLoader
{
	static int max=0;
	void foo(int num){ 
		max++;
		if (max < 10){
			System.out.printf("going on stack...num=%d%n", num);
			foo(num+1);
			System.out.printf("coming off stack...num=%d%n", num);
		}
		return;
	}
}