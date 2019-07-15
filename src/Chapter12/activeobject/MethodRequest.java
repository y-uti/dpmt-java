package activeobject;

abstract class MethodRequest<T> {

    protected MethodRequest(Servant servant, FutureResult<T> future) {
    }
}
