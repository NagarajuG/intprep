package ObserverPattern;

public interface Subject {

	void subscribe(Subscriber sub);

	void unsubscribe(observer sub);

	void notifySubscribers(String videoName);

	void upload(String videoName);

}