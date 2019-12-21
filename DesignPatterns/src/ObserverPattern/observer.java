package ObserverPattern;

public interface observer {

	void update(String videoName);

	void subscribeChannel(Subject ch);

}