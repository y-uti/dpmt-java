import activeobject.ActiveObject;
import java.util.concurrent.Future;

public class MakerClientThread extends Thread {

    private final ActiveObject activeObject;
    private final char fillchar;

    public MakerClientThread(String name, ActiveObject activeObject) {
	super(name);
	this.activeObject = activeObject;
	this.fillchar = name.charAt(0);
    }

    public void run() {
	try {
	    for (int i = 0; true; i++) {
		Future<String> future = activeObject.makeString(i, fillchar);
		Thread.sleep(10);
		String value = future.get();
		System.out.println(Thread.currentThread().getName() + ": value = " + value);
	    }
	} catch (Exception e) {
	    System.out.println(Thread.currentThread().getName() + ": " + e);
	}
    }
}
