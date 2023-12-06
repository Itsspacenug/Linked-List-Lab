/*
 * LinkedListReplicated.java
 * 
 */

import java.io.File;
import java.io.IOException;


public class LinkedListReplicated  {
 
    public static void main(String s[]) 
    {
    	    	
		//Students create 2 LinkedIntList objects.
    		// a) Uses the default constructor
    		// b) Uses the the construtor that allows an integer value to be passed in.
    	LinkedIntList list1 = new LinkedIntList(1);
    	LinkedIntList list2 = new LinkedIntList();

		
      	//Test out each of your various methods (add, insert, get, indexOf, remove, size, toString)) 
      		//using either of the instantiated LinkedIntList objects
    	list1.add(2);
    	list2.add(1);
    	System.out.println(list1.toString());
    	System.out.println(list2.toString());
    	/*list1.add(2,1);
    	list2.add(1,0);
    	System.out.println(list1.toString());
    	System.out.println(list2.toString());*/
    	System.out.println(list1.get(1));
    	System.out.println(list2.get(0));
    	System.out.println(list1.indexOf(1));
    	System.out.println(list2.indexOf(1));
    	list1.clear();
    	list2.clear();
    	list1.add(2);list1.add(3);list1.add(4);
    	list2.add(1);list2.add(2);list2.add(3);
    	System.out.println(list1.toString());
    	System.out.println(list2.toString());
    	
    	System.out.println(list1.remove(1));
    	System.out.println(list2.remove(0));
    	
    	System.out.println(list1.size());
    	System.out.println(list2.size());
    	list1.clear();
    	list2.clear();
    	
    	list1.add(0,2);
    	list2.add(0,1);
    	System.out.println(list1.toString());
    	System.out.println(list2.toString());
    }
    
	//Create your LinkedIntList class in another file called "LinkedIntList"
}
