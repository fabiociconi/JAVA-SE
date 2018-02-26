package zweek13;

import java.util.Queue;
import java.util.PriorityQueue;

public class QueueTest {
	public static void main(String[] args) {

		Queue<Integer> q = new PriorityQueue<>();
		q.add(new Integer(300));
		q.add(new Integer(2));
		q.add(new Integer(400));
		q.add(new Integer(50));
		
		
		
		while (!q.isEmpty()){
			System.out.println(q.remove());
		}

	}
}
