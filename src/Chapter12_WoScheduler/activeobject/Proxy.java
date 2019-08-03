package activeobject;

class Proxy implements ActiveObject {

    private final Servant servant;

    public Proxy(Servant servant) {
	this.servant = servant;
    }

    public Result<String> makeString(int count, char fillchar) {
	FutureResult<String> future = new FutureResult<String>();
	new Thread() {
	    public void run() {
		Result<String> result = servant.makeString(count, fillchar);
		future.setResult(result);
	    }
	}.start();
	return future;
    }

    public void displayString(String string) {
	new Thread() {
	    public void run() {
		servant.displayString(string);
	    }
	}.start();
    }
}
