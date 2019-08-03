package concurrent;

public interface ExecutorService {

    public <T> Future<T> submit(Callable<T> callable);

    public void execute(Runnable runnable);

    public void shutdown();
}
