package ObserverPattern;

public class YouTube {

	public static void main(String[] args) {
		Channel channel = new Channel();
		channel.setChannelName("DesignPatterns");

		Subscriber s1 = new Subscriber();
		s1.setName("Raju");

		channel.subscribe(s1);
		s1.subscribeChannel(channel);

		channel.upload("Observer Pattern Video");

	}

}
