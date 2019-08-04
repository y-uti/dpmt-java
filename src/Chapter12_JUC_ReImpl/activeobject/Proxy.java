package activeobject;

import concurrent.ExecutorService;
import concurrent.Future;

class Proxy implements ActiveObject {

    private final ExecutorService service;
    private final Servant servant;

    public Proxy(ExecutorService service, Servant servant) {
	this.service = service;
	this.servant = servant;
    }

    public Future<String> makeString(int count, char fillchar) {
	return service.submit(new MakeStringRequest(servant, count, fillchar));
    }

    public void displayString(String string) {
	service.execute(new DisplayStringRequest(servant, string));
    }

    public void shutdown() {
	service.shutdown();
    }
}

