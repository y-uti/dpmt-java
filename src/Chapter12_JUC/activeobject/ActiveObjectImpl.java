package activeobject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ActiveObjectImpl implements ActiveObject {

    private final ExecutorService service;

    public ActiveObjectImpl() {
	this.service = Executors.newSingleThreadExecutor();
    }

    public Future<String> makeString(int count, char fillchar) {
	class MakeStringRequest implements Callable<String> {
	    public String call() {
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
		    buffer[i] = fillchar;
		    try {
			Thread.sleep(100);
		    } catch (InterruptedException e) {
		    }
		}
		return new String(buffer);
	    }
	};
	return service.submit(new MakeStringRequest());
    }

    public void displayString(String string) {
	class DisplayStringRequest implements Runnable {
	    public void run() {
		try {
		    System.out.println("displayString: " + string);
		    Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	    }
	};
	service.execute(new DisplayStringRequest());
    }

    public void shutdown() {
	service.shutdown();
    }
}

