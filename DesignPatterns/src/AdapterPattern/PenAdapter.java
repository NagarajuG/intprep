package AdapterPattern;

import AdapterSupport.PilotPen;

public class PenAdapter implements Pen {

	PilotPen ppPen = new PilotPen();

	@Override
	public void write(String str) {
		System.out.println("In PenAdapter Class, write Method");
		ppPen.mark(str);

	}

}
