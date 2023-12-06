
public class dNode<T> {

	dNode<T> next;
	dNode<T> prev;
    T data;
    
    public dNode(T data)
    {
    	this.data = data;
    	this.next = null;
    	
    }
    
    public dNode(T data, dNode<T> next, dNode<T> prev)
    {
    	this.data = data;
    	this.next = next;
    	this.prev = prev;
    }
    public void set(T data) {
    	this.data = data;
    }
}
