package activeobject;

class Proxy implements ActiveObject {

    private final Servant servant;

    public Proxy(Servant servant) {
	this.servant = servant;
    }

    public Result<String> makeString(int count, char fillchar) {
	FutureResult<String> future = new FutureResult<String>();
	new Thread(new MakeStringRequest(servant, future, count, fillchar)).start();
	return future;
    }

    public void displayString(String string) {
	new Thread(new DisplayStringRequest(servant, string)).start();
    }
}
