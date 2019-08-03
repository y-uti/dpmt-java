package activeobject;

class Servant implements ActiveObject {

    private boolean canDisplay = false;

    public boolean canDisplay() {
	return canDisplay;
    }

    public Result<String> makeString(int count, char fillchar) {
	canDisplay = true;
	char[] buffer = new char[count];
	for (int i = 0; i < count; i++) {
	    buffer[i] = fillchar;
	    try {
		Thread.sleep(100);
	    } catch (InterruptedException e) {
	    }
	}
	return new RealResult<String>(new String(buffer));
    }

    public void displayString(String string) {
	if (!canDisplay) {
	    System.out.println("*ERROR* you must need to make a string");
	    return;
	}

	canDisplay = false;
	try {
	    System.out.println("displayString: " + string);
	    Thread.sleep(10);
	} catch (InterruptedException e) {
	}
    }
}

