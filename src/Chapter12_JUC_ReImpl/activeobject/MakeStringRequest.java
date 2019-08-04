package activeobject;

import concurrent.Callable;

class MakeStringRequest extends MethodRequest implements Callable<String> {

    private final int count;
    private final char fillchar;

    public MakeStringRequest(Servant servant, int count, char fillchar) {
	super(servant);
	this.count = count;
	this.fillchar = fillchar;
    }

    public String call() {
	return servant.makeString(count, fillchar);
    }
}
