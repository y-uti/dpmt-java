package activeobject;

import concurrent.ExecutorService;
import concurrent.Executors;

public class ActiveObjectFactory {

    public static ActiveObject createActiveObject() {
	Servant servant = new Servant();
	ExecutorService service = Executors.newSingleThreadExecutor();
	Proxy proxy = new Proxy(service, servant);

	return proxy;
    }
}
