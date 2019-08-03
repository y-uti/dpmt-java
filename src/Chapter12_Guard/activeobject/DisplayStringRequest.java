package activeobject;

class DisplayStringRequest extends MethodRequest<Object> {

    private final String string;

    public DisplayStringRequest(Servant servant, String string) {
	super(servant, null);
	this.string = string;
    }

    public boolean guard() {
	return servant.canDisplay();
    }

    public void execute() {
	servant.displayString(string);
    }
}
