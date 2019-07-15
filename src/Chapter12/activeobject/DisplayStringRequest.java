package activeobject;

class DisplayStringRequest extends MethodRequest<Object> {

    public DisplayStringRequest(Servant servant, String string) {
	super(servant, null);
    }
}
