package dataManager;

/**
 * Class that allows the creation of a linked list queue composed of Singly Nodes.
 * @author carlosgrivera
 *
 * @param <E> type of element objects in the queue linked list 
 */
public class LLQueue<E> implements Queue<E>
{
	/**
	 * Class that allows the creation of Singly Nodes 
	 * @author carlosgrivera
	 *
	 * @param <E> type of element objects stored in node 
	 */
	private class SNode<E>{
		private E element; 
		private SNode<E> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		/**
		 * SNode constructor 
		 * @param data data that the node will store
		 * @param next node that succeeds the node created
		 */
		public SNode(E data, SNode<E> next) { 
			this.element = data; 
			this.next = next; 
		}
		
		/**
		 * SNode constructor
		 * @param data data that the node will store
		 */
		
		public SNode(E data)  { 
			this.element = data; 
			next = null; 
		}
		
		/**
		 * Method gets the data from a certain node
		 * @return node element
		 */
		public E getElement() {
			return element;
		}
		
		/**
		 * Method sets the element to a certain node
		 * @param data data that will be stored in the node 
		 */
		public void setElement(E data) {
			this.element = data;
		}
		
		/**
		 * Method gets the node that succeeds the targeted node
		 * @return
		 */
		public SNode<E> getNext() {
			return next;
		}
		
		/**
		 * Method that sets the node that will succeed the targeted node
		 * @param next node that succeeds the targeted node
		 */
		public void setNext(SNode<E> next) {
			this.next = next;
		}
		
		/**
		 * Removes the data and reference of the targeted node
		 */
		public void clean() { 
			element = null; 
			next = null; 
		}
	}
	
	private SNode<E> front, rear; 
	private int size; 
	
	/**
	 * Constructor of the linked list queue
	 */
	public LLQueue() {
		front = rear = null; 
		size = 0; 
	}
	
	/**
	 * Remove the front node from the queue
	 */
	public E dequeue() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("dequeue: Queue is empty."); 
		E etr = front.getElement(); 

		front = front.getNext();
		size--;
		return etr;
	}

	/**
	 * Adds a node to the tail of the queue
	 */
	public void enqueue(E e) {
		SNode<E> nn = new SNode<E>(e); 
		if (size == 0)
			front = nn; 
		else 
			rear.setNext(nn); 
		rear = nn; 
		size++; 
	}

	/**
	 * Gets the front node in the queue
	 */
	public E front() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException("front: Queue is empty."); 
		return front.getElement();
	}

	/**
	 * Returns the size of the queue 
	 */
	public int size() {
		return size;
	}

	/**
	 * Determines if the queue is empty or not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	// just for testing and grading....
    public void showReverse() { 
	    if (size == 0)
		   System.out.println("Queue is empty."); 
		else
		   recSR(front);
    } 
    private void recSR(SNode<E> f) { 
		if (f != null) { 
		   recSR(f.getNext()); 
		   System.out.println(f.getElement()); 
	     } 
    } 


}
