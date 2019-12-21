package AdapterPattern;

public class AssignmentWork {

	private Pen pen;

	public Pen getPen() {
		return pen;
	}

	public void setPen(Pen pen) {
		this.pen = pen;
	}

	public void writeAssignment(String str) {
		System.out.println("In Assignment Work writeAssignment method");
		pen.write(str);

	}

}
