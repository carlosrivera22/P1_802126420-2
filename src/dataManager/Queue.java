package dataManager;

/**
 * Interface that is implemented whenever a queue is to be constructed
 * @author carlosgrivera
 *
 * @param <E> element objects that will be stored in the queue
 */
public interface Queue<E> {
	int size(); 
	boolean isEmpty(); 
	E front() throws EmptyQueueException; 
	E dequeue() throws EmptyQueueException; 
	void enqueue(E e); 
}
