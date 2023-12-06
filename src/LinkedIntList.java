//AARON NGUYEN
/*PURPOSE: The Linked List is the foundation for many other data structures. By understanding
how they work from the ground up, it paves the way for understanding it�s many
variations and how its evolution into entirely new data structures.*/
/*ADVICE: Think carefully first and then code. Drawing a graph or diagram on paper can help a
LOT when thinking about Linked Lists. Remember that if nothing is pointing to a
node, it is inaccessible.
You can always create more methods than the required methods.
You can add a size field to the LinkedIntList class to return its size more
efficiently.
/*TODO: 
 * Check over add methods to make sure they work
 * finish remove and toString methods
 */
import java.util.*;
public class LinkedIntList {
	public ListNode front;
	private static int size;
	
	//Default Constructor, sets front to null.
	public LinkedIntList(){
		front=null;
		size=0;
		
	}
	
	//Constructor that sets front to a new node with
	//value as the parameter.
	public LinkedIntList(int value){
		front = new ListNode(value,null);
		size=1;
	}
	
	/*Adds the given value to the end of the list. What
	happens if the list is empty?*/
	public void add(int value) {
		ListNode newNode = new ListNode(value);
		
		if(front == null) {
			front = newNode;
		}
		else {
			//front.next = new ListNode(value,null);
			//what if there is already a value in the front.next element??
			ListNode temp = front;
			while(temp.next !=null) {
				temp = temp.next;
			}
			temp.next = newNode;
			
			
		}
		size++;
	}
	
	/*Inserts the specified value in the indicated
	position of the list. If the index is out of bounds, throw an
	IndexOutOfBoundsException.*/
	public void add(int index, int value) {
		if(index>size || index <0) {
			throw new IndexOutOfBoundsException();
		}
		ListNode newNode = new ListNode(value);
		
		if(index ==0 ) {
			newNode.next = front;
			front = newNode;
		}else {
			ListNode temp = front;
			for(int i =0; i < index-1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		size++;
	}
	
	/*Return the value at the specified index. If the index is out
	of bounds, throw an IndexOutOfBoundsException.*/	
	public int get(int index) {
		if(index <0 || index>size) {
			throw new IndexOutOfBoundsException();
		}
		ListNode current = front;
		for(int i=0; i < index; i++) {
				current = current.next;
		}
		return current.data;
	}
	
	/*Returns the index of the first occurrence of the
	value in the list, or -1 if it never occurs.*/
	public int indexOf (int value){
		int index = 0;
		ListNode current = front;
		while(current!=null) {
			if(current.data == value) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}
	
	/*Removes the node at the specified index and returns
	it. If the index is out of bounds, throw an IndexOutOfBoundsException.*/
	public int remove(int index) {
		if(index>size || index<0) {
			throw new IndexOutOfBoundsException();
		}
		int rVal;
		if (index ==0){
			rVal = front.data;
			front = front.next;
		}else {
			ListNode current = front;
			for(int i=0; i< index; i++) {
				current = current.next;
			}
			rVal = current.next.data;
			current.next = current.next.next;
		}
		size--;
		return rVal;
	}
	
	/*Returns the number nodes currently chained in the list.*/
	public int size() {
		return size;
	}
	public void clear() {
		front = null;
	}
	
	/*Returns a String of the list in this format �item1, item2, ...,
	item99�. You should NOT be printing in this method.*/
	public String toString( ) {
		StringBuilder word = new StringBuilder();
		ListNode current= front;
		while (current!=null) {
			word.append(current.data);
			
			if(current.next!=null) {
				word.append(" ");
			}
			current = current.next;
		}
	return word.toString();
	}
}
