package LinkedList;

/* Time spent on a3:  1 hours and 0 minutes.
 *
 * When you change the above, please do it carefully. Change hh to
 * the hours and mm to the minutes and leave everything else as is.
 * If the minutes are 0, change mm to 0. This will help us in
 * extracting times and giving you the average and max.
 * 
 * Name: Chen Li
 * Netid: cl953
 * What I thought about this assignment:
 *
 *
 */

/** An instance is a doubly linked list. */
public class DList<E>  {
    private Node head;  // first node of linked list (null if size is 0)
    private Node tail;  // last node of linked list (null if size is 0)
    private int size;   // Number of values in the linked list.

    /** Constructor: an empty linked list. */
    public DList() {
    }

    /** Return the number of values in this list.
     *  This function takes constant time. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty).
     *  This function takes constant time. */
    public Node head() {
        return head;
    }

    /** Return the last node of the list (null if the list is empty).
     *  This function takes constant time. */
    public Node tail() {
        return tail;
    }

    /** Return the value of node n of this list.
     *  Precondition: n is a node of this list; it may not be null.
     *  This function takes constant time. */
    public E value(Node n) {
        assert n != null;
        return n.data;
    }

    /** Return a representation of this list: its values, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list.<br>
     * E.g. for the list containing 4 7 8 in that order, the result it "[4, 7, 8]".
     * E.g. for the list containing two empty strings, the result is "[, ]" */
    public String toString() {
        String res= "[";
        Node n= head;
        // inv: res contains values of nodes before node n (all of them if n = null),
        //      with ", " after each (except for the tail value)
        while (n != null) {
            res= res + n.data;
            n= n.succ;
            if (n != null) {
                res= res + ", ";
            }
        }

        return res + "]";
    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * Takes time proportional to the length of this list.
     * E.g. for the list containing 4 7 8 in that order, the result is "[8, 7, 4]".
     * E.g. for the list containing two empty strings, the result is "[, ]". */
    public String toStringRev() { 
        //TODO 1. Look at toString to see how that was written.
        //        Use the same scheme. Extreme case to watch out for:
        //        E is String and values are the empty string.
        //        You can't test this fully until #2, append, is written.
    	String res = "[";
    	Node n = tail;
    	while(n != null) {
    		res = res + n.data;
    		n = n.pred;
    		if(n != null) {
    			res = res + ", ";
    		}
    	}
      
        return res + "]";
    }
    
    /** add value v to the end of the list.
     *  This operation takes constant time. */
    public void append(E v) {
        //TODO 2. After writing this method, test this method and
        //        method toStringRev thoroughly before starting on the next
        //        method. These two must be correct in order to be
        //        able to write and test all the others.
        if(this.head == null) {
        	Node node = new Node(null,v,null);
        	this.head = node;
        	this.tail = node;
        }
        else {
        	Node node = new Node(tail,v,null);
        	this.tail.succ = node;
        	this.tail = node;
        }
        this.size++;
    }

    /** Add value v at the front of the list.
     * This operation takes constant time. */
    public void prepend(E v) {
        //TODO 3. 
    	if(this.head == null) {
    		Node node = new Node(null,v,null);
    		this.head = node;
    		this.tail = node;
    	}
    	else {
    	Node node = new Node(null,v,this.head);
    	this.head.pred = node;
    	this.head = node;
    	}
    	this.size++;
        
    }

    /** Return node number k. 
     *  Precondition: 0 <= k < size of the list.
     *  If k is 0, return head node; if k = 1, return second node, ... */
    public Node getNode(int k) {
        //TODO 4. This method should take time proportional to min(k, size-k).
        // For example, if k <= size/2, search from the beginning of the
        // list, otherwise search from the end of the list.
    	assert k>=0&&k<this.size;
    	int size = this.size;
    	Node node = null;
    	if(k<size/2) {
    		int index = 0;
    		node = this.head;
    		while(k != index) {
    			node = node.succ;
    			index++;
    		}
    	}
    	else {
    		node = this.tail;
    		int index = this.size-1;
    		while(k != index) {
    			node = node.pred;
    			index--;
    		}
    	}
        
        return node;
    }
    
    /** Remove node n from this list.
     * This operation must take constant time.
     * Precondition: n must be a node of this list; it may not be null. */
    public void delete(Node n) {
        //TODO 5. Make sure this method takes constant time. 
    	assert n!=null;
    	int size = this.size;
    	Node curNode = this.head;
    	while(n != curNode&&curNode!=null) {
    		curNode = curNode.succ;
    	}
    	assert curNode!=null;
    	if(curNode == this.head) {
    		if(this.size == 1) {
    			this.head = null;
    			this.tail = null;
    		}
    		else {
    		this.head = this.head.succ;
    		this.head.pred = null;
    		}
    	}
    	else {
    	Node preNode = curNode.pred;
    	Node next = curNode.succ;
    	preNode.succ = next;
    	if(next==null) {
    		this.tail = preNode;
    		
    	}
    	else {
    	next.pred = preNode;
    	}
    	}
    	this.size = this.size-1;
        
    }

    /** Insert value v in a new node after node n.
     * This operation takes constant time.
     * Precondition: n must be a node of this list; it may not be null. */
    public void insertAfter(E v, Node n) {
        //TODO 6. Make sure this method takes constant time.
    	assert n!=null;
    	int size = this.size;
    	Node curNode = this.head;
    	while(n != curNode&&curNode!=null) {
    		curNode = curNode.succ;
    	}
    	assert curNode!=null;
    	if(curNode == this.tail) {
    		this.tail = new Node(curNode,v,null);
    		curNode.succ = this.tail;
    	}
    	else {
    	Node next = curNode.succ;
    	Node newNode = new Node(curNode,v,next);
    	curNode.succ = newNode;
    	next.pred = newNode;
    	}
    	this.size = this.size + 1;
        
    }

 

    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        private Node pred; // Previous node on list (null if this is head node)
        private E data;     // The value of this element
        private Node succ; // Next node on list. (null if this is tail node)

        /** Constructor: an instance with predecessor node p (can be null),
         * value v, and successor node n (can be null). */
        Node(Node p, E v, Node n) {
            pred= p;
            data= v;
            succ= n;
        }

        /** Return the predecessor of this node (null if this is the
         * head node of the list). */
        public Node pred() {
            return pred;
        }

        /** Return the value of this node. */
        public E value() {
            return data;
        }

        /** Return the successor of this node in this list (null if this is the
         * tail node of this list). */
        public Node succ() {
            return succ;
        }
    }

}
