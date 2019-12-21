package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
	private String channelName;
	List<Subscriber> subscribers = new ArrayList<Subscriber>();

	@Override
	public void subscribe(Subscriber sub) {
		this.subscribers.add(sub);

	}

	@Override
	public void unsubscribe(observer sub) {
		this.subscribers.remove(sub);

	}

	@Override
	public void notifySubscribers(String videoName) {
		for (observer sub : subscribers) {
			sub.update(videoName);
		}

	}

	@Override
	public void upload(String videoName) {
		notifySubscribers(videoName);
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

}
