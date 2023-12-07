//Queue.java
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
 * Needs to complete the extra credit because you ass has a horrible grade
 */
public class Queue<T> {
	public dNode<T> head; //sets head variable
	public dNode<T> tail; //sets tail variable
	private int size; //sets size variable for size() method
	private int capacity;
	
	//sets head and tail to null
	public Queue(){ //default constructor that sets head and tail to null and size to 0
		head = null;
		tail = null;
		size = 0;
		capacity = Integer.MAX_VALUE;
	}
	
	//Constructor that sets head to a new node with value as the
	//parameter. This should also set the tail to point to the new node.
	public Queue(T value) { //contructor that takes in a value that is set to the head and tail
		dNode<T> newNode = new dNode<T>(value);
		
		this.head = newNode;
		this.tail = newNode;
		this.head.next = tail;
		this.head.prev = tail; //completes the loop
		this.tail.next = head; //completes the loop
		this.tail.prev = head;
		this.size =1;
		this.capacity = Integer.MAX_VALUE;
	}
	
	/*Add another attribute named capacity that will be used to limit the
	number of items that can be contained in the list at once. When adding values to the
	list, you should throw an IllegalStateException if no space is currently available.*/
	public Queue(T value, int cap) { //Constructor that takes in a value that is set to the head and tail
		dNode<T> newNode = new dNode<T>(value);
		
		this.head = newNode;
		this.tail = newNode;
		this.head.next = tail;
		this.head.prev = tail; //completes the loop
		this.tail.next = head; //completes the loop
		this.tail.prev = head;
		size =1;
		capacity = cap;
	}
	
	/*Adds the given value to the end of the Queue. Keep
	 in mind that our linked list is circular.*/
	public void enqueue(T value) {
		dNode<T> newNode = new dNode<T>(value);
		if(size+1>capacity) {
			throw new IllegalStateException("Cannot add more elements because queue is at capacity");
		}
		if(size==0) { //one off chance if the default constructor was used so it does what the regular one perameter contructor does
			head = newNode;
			tail = newNode;
			head.prev = tail; //completes the loop
			tail.next = head; //completes the loop
		}else{
			tail.next = newNode; //sets the element after the tail to the given value
			newNode.prev = tail; //adds the pointer so that loop can go backwards
			tail= newNode; //sets the value as the tail
			tail.next = head; //completes the loop
			head.prev = tail; //completes the loop
			
		}
		size++;//changes the size variable to accurately represent the size 
	}
	
//	/Removes the first element of the queue and returns it�s data.
	//If the queue is empty, return null.
	public T dequeue() {
		if(size ==0) { //duh it returns null if there is nothing in it 
			return null;
		}
		if(size ==1) {
			head = null;
			tail = null;
			size =0;
			return null; //IS THIS WHAT WE PRINT IF WE ARE REMOVING THE LAST ELEMENT
		}else {
		dNode<T> current = head; // temp variable 
		tail.next = head.next; //adds pointer to next element after the head from tail
		head = head.next; //sets the head as the element after head
		head.prev = tail; //adds pointer backwards to tail
		
		size--; //changes the size variable to accurately represent the size 
		return current.data;
		}
		
	}
	
	
	//Returns true if the list is empty, false otherwise.
	public boolean isEmpty() {
		if(size==0) { //self explanatory but since youre mean on grading
			return true; //returns true if its empty CRAZY RIGHT
		}
		return false; //if not empty return false WOAHHH CRAZYYY
	}
	
	//Removes the first element and places it at the �back� of
	//the queue.
	public void sendToBack() {
		if(size!=0) { //cannot send to back if nothings there
			T value = dequeue(); //copies the element leaving, and removes the element 
			enqueue(value); //add the element to the end
		}
	}
	
	//Returns the number of nodes currently chained in the list.
	public int size( ) {
		return size; //returns the size variable 
	}
	
	//returns capacity variable
	public int capacity() {
		return capacity;
	}
	
	//Thank about what to do if the new capacity is smaller than the current size.
	public void changeCapacity(int cap) {
		if(size>capacity) {
			throw new IllegalStateException("The capacity cannot be less than the size");
		}else {
			capacity = cap;
		}
	}
	
	//Returns a String of the list in this format : �item1 | item2 |
	//...| item99�. You should NOT be printing in this method.
	public String toString( ) {
		StringBuilder word = new StringBuilder();
		dNode<T> current= head;
		if(current!=null) { //one off chance the person prints and the list is empty 
			do //makes sure the loop goes through at least once
			{
				word.append(current.data + ""); //adds the data to the variable 
				if(current!=tail) { //if it isnt at the end it adds a line as you requested King President Benevolent Sir Your Majesty Honorable Judge Prime Minister Holiness Mr. Watson. I couldnt think of more titles 
					word.append(" | ");
				}
				
				current = current.next; //goes to next in the queue
				
			}while(current!=head); //base case to end loop
		}else {
			word = word.append("list = Empty"); //if the list is empty it returns it
		}
	return word.toString();
	}
}
