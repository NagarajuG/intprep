package ObserverPattern;

public class Subscriber implements observer {
	private String name;
	private Subject channel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(String videoName) {
		System.out.println("Hey " + name + " New video" + videoName + " got uploaded");
	}

	@Override
	public void subscribeChannel(Subject ch) {
		this.channel = ch;

	}

	public Subject getChannel() {
		return channel;
	}

	public void setChannel(Subject channel) {
		this.channel = channel;
	}

}
