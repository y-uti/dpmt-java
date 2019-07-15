package activeobject;

class MakeStringRequest extends MethodRequest<String> {

    public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char fillchar) {
	super(servant, future);
    }
}
