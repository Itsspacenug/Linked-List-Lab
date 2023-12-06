
public class sNode<T> {

	sNode<?> next;
    T t;
    int data;

    public sNode()
    {
        this(null);
        this.next = null;
        data=0;
    }
    
    public sNode(T t)
    {
    	this.t = t;
    	this.next = null;
    	data = (int) t;
    }
    
    public sNode(T t, sNode<?> next)
    {
    	this.t = t;
    	this.next = next;
    }
    public void set(T t) {
    	this.t = t;
    }
    public T get() {
    	return t;
    }
}
