package activeobject;

class FutureResult<T> extends Result<T> {

    private Result<T> result;
    private boolean ready;

    public FutureResult() {
	this.result = null;
	this.ready = false;
    }

    public synchronized void setResult(Result<T> result) {
	this.result = result;
	this.ready = true;
	notifyAll();
    }

    public synchronized T getResultValue() {
	while (!ready) {
	    try {
		wait();
	    } catch (InterruptedException e) {
	    }
	}
	return result.getResultValue();
    }
}
