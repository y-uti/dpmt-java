package activeobject;

abstract class MethodRequest<T> implements Runnable {

    protected final Servant servant;
    protected final FutureResult<T> future;

    protected MethodRequest(Servant servant, FutureResult<T> future) {
	this.servant = servant;
	this.future = future;
    }

    public void run() {
	execute();
    }

    public abstract void execute();
}
