
public class QueuesTesting {

	public static void main (String[] args)
	{
		Queue<Integer> list = new Queue<Integer>(1);
		list.enqueue(2);
		list.enqueue(3);
		list.enqueue(4);
		list.dequeue();
		list.dequeue();
		list.dequeue();
		list.dequeue();
		list.enqueue(1);
		list.enqueue(2);
		list.enqueue(3);
		list.enqueue(4);
		list.sendToBack();
		System.out.println(list.toString());
		System.out.println("Size = "+list.size());
		System.out.println(list.isEmpty());
	}
}
