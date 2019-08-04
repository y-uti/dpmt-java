package activeobject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ActiveObjectFactory {

    public static ActiveObject createActiveObject() {
	Servant servant = new Servant();
	ExecutorService service = Executors.newSingleThreadExecutor();
	Proxy proxy = new Proxy(service, servant);

	return proxy;
    }
}
