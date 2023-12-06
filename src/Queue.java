//Aaron Nguyen
/*//Purpose: This class must implement a
connected list of dNode objects, and you must not import the built-in LinkedList
class or the Queue interface. A dNode object contains data, as well as a reference
variable for the next and previous nodes. Modify your generic ListNode class, now
named dNode, to reflect all the information described in a doubly-linked node.

/*Advice: Think carefully first and then code. Drawing a graph or diagram on paper can help a
lot when thinking about Linked Lists. Remember that if nothing is pointing to a node,
it is inaccessible.
You can always create more methods than the required methods.
/*TODO:
 * 
 */
public class Queue<T> {
	private dNode<T> head;
	private dNode<T> tail;
	private int size;
	
	//sets head and tail to null
	public Queue(){
		head = null;
		tail = null;
		size = 0;
	}
	
	//Constructor that sets head to a new node with value as the
	//parameter. This should also set the tail to point to the new node.
	public Queue(T value) {
		head = new dNode<T>(value);
		head.next = tail;
		size =1;
	}
	
	/*Adds the given value to the end of the Queue. Keep
	 in mind that our linked list is circular.*/
	public void enqueue(T value) {
		dNode<T> newNode = new dNode<T>(value);
		
		dNode<T> current = head;
		while(current!=tail) {
			if(size==1) {
				head.next = newNode;
				tail = newNode;
				tail.next = head;
			}
			if(current.next == tail) {
				newNode.next = head;
				current.next=tail;
				tail = newNode;
				
			}
			current = current.next;
		}
		size++;
	}
	
//	/Removes the first element of the queue and returns it’s data.
	//If the queue is empty, return null.
	public T dequeue() {
		return null;
	}
	
	
	//Returns true if the list is empty, false otherwise.
	public boolean isEmpty() {
		return false;
	}
	
	//Removes the first element and places it at the “back” of
	//the queue.
	public void sendToBack() {
		
	}
	
	//Returns the number of nodes currently chained in the list.
	public int size( ) {
		return size;
	}
	
	//Returns a String of the list in this format : “item1 | item2 |
	//...| item99”. You should NOT be printing in this method.
	public String toString( ) {
		StringBuilder word = new StringBuilder();
		dNode<T> current= head;
		while (current!=tail) {
			word.append(current.data + "");
			
			if(current.next!=tail) {
				word.append(" | ");
			}
			
			current = current.next;
		}
	return word.toString();
	}
}
