package concurrent;

public class Future<T> {

    private T result;
    private boolean ready;

    public Future() {
	this.result = null;
	this.ready = false;
    }

    public synchronized void set(T result) {
	this.result = result;
	this.ready = true;
	notifyAll();
    }

    public synchronized T get() {
	while (!ready) {
	    try {
		wait();
	    } catch (InterruptedException e) {
	    }
	}
	return result;
    }
}
