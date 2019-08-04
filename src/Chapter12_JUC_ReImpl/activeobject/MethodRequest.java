package activeobject;

abstract class MethodRequest {

    protected final Servant servant;

    protected MethodRequest(Servant servant) {
	this.servant = servant;
    }
}
