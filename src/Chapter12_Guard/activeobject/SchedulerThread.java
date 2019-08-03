package activeobject;

class SchedulerThread extends Thread {

    private final ActivationQueue queue;

    public SchedulerThread(ActivationQueue queue) {
	this.queue = queue;
    }

    public void invoke(MethodRequest request) {
	queue.putRequest(request);
    }

    public void run() {
	while (true) {
	    MethodRequest request = queue.takeRequest();
	    if (request != null) {
		request.execute();
	    }
	    try {
		Thread.sleep(10);
	    } catch (InterruptedException e) {
	    }
	}
    }
}
