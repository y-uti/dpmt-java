package concurrent;

public class Executors {

    public static ExecutorService newSingleThreadExecutor() {
	return new SingleThreadExecutor();
    }
}
