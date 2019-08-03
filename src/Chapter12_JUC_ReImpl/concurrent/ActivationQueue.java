package concurrent;

class ActivationQueue {

    private static final int MAX_METHOD_REQUEST = 100;

    private final Runnable[] requestQueue;
    private int head;
    private int tail;
    private int count;

    public ActivationQueue() {
	this.requestQueue = new Runnable[MAX_METHOD_REQUEST];
	this.head = 0;
	this.tail = 0;
	this.count = 0;
    }

    public synchronized void putRequest(Runnable request) {
	while (count >= requestQueue.length) {
	    try {
		wait();
	    } catch (InterruptedException e) {
	    }
	}
	requestQueue[tail] = request;
	tail = (tail + 1) % requestQueue.length;
	count++;
	notifyAll();
    }

    public synchronized Runnable takeRequest() {
	while (count <= 0) {
	    try {
		wait();
	    } catch (InterruptedException e) {
	    }
	}
	Runnable request = requestQueue[head];
	head = (head + 1) % requestQueue.length;
	count--;
	notifyAll();
	return request;
    }

    public synchronized boolean isEmpty() {
	return count <= 0;
    }
}
