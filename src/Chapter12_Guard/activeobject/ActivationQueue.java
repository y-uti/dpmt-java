package activeobject;

import java.util.LinkedList;

class ActivationQueue {

    private static final int MAX_METHOD_REQUEST = 100;

    private final LinkedList<MethodRequest> requestQueue;

    public ActivationQueue() {
	this.requestQueue = new LinkedList<MethodRequest>();
    }

    public synchronized void putRequest(MethodRequest request) {
	while (requestQueue.size() >= MAX_METHOD_REQUEST) {
	    try {
		wait();
	    } catch (InterruptedException e) {
	    }
	}
	requestQueue.add(request);
	notifyAll();
    }

    public synchronized MethodRequest takeRequest() {
	while (requestQueue.isEmpty()) {
	    try {
		wait();
	    } catch (InterruptedException e) {
	    }
	}
	for (MethodRequest request : requestQueue) {
	    if (request.guard()) {
		requestQueue.remove(request);
		notifyAll();
		return request;
	    }
	}
	return null;
    }
}
