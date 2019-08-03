package concurrent;

public class SingleThreadExecutor extends Thread implements ExecutorService {

    private final ActivationQueue queue;
    private boolean shutdownRequested;

    public SingleThreadExecutor() {
	this.queue = new ActivationQueue();
	this.shutdownRequested = false;
	this.start();
    }

    public <T> Future<T> submit(Callable<T> callable) {
	Future<T> future = new Future<T>();
	Runnable runnable =
	    new Runnable() {
		public void run() {
		    T result = callable.call();
		    future.set(result);
		}
	    };
	execute(runnable);
	return future;
    }

    public void execute(Runnable runnable) throws RuntimeException {
	if (shutdownRequested) {
	    throw new RuntimeException("Rejected");
	}
	queue.putRequest(runnable);
    }

    public void run() {
	while (!(shutdownRequested && queue.isEmpty())) {
	    Runnable runnable = queue.takeRequest();
	    runnable.run();
	}
    }

    public void shutdown() {
	shutdownRequested = true;
    }
}
