package activeobject;

class DisplayStringRequest extends MethodRequest implements Runnable {

    private final String string;

    public DisplayStringRequest(Servant servant, String string) {
	super(servant);
	this.string = string;
    }

    public void run() {
	servant.displayString(string);
    }
}
