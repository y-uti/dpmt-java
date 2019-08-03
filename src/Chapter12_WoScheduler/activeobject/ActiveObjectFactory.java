package activeobject;

public class ActiveObjectFactory {

    public static ActiveObject createActiveObject() {
	Servant servant = new Servant();
	Proxy proxy = new Proxy(servant);

	return proxy;
    }
}
