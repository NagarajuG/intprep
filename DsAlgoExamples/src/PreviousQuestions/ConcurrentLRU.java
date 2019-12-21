package PreviousQuestions;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentLRU<K, V> {

	private int cacheSize;

	private ConcurrentHashMap<K, V> cache;

	private ConcurrentLinkedQueue<K> queue;

	private ReentrantReadWriteLock rrwLock;

	private Lock readLock;

	private Lock writeLock;

	public ConcurrentLRU(int size) {
		this.cacheSize = size;
		this.cache = new ConcurrentHashMap<K, V>();
		this.queue = new ConcurrentLinkedQueue<K>();
		this.rrwLock = new ReentrantReadWriteLock();
		this.readLock = rrwLock.readLock();
		this.writeLock = rrwLock.writeLock();
	}

	public V get(K key) {
		readLock.lock();
		try {
			V val = null;

			if (cache.containsKey(key)) {
				val = cache.get(key);
				queue.remove(key);
				queue.add(key);

			}

			return val;

		} finally {
			readLock.unlock();
		}

	}

	public void set(K key, V val) {
		writeLock.lock();
		try {
			if (cache.contains(key)) {
				cache.remove(key);
			}

			if (cache.size() == this.cacheSize) {
				K keyK = queue.poll();
				cache.remove(keyK);
			}

			cache.put(key, val);
			queue.add(key);

		} finally {
			writeLock.unlock();
		}
	}

	public V evict(K key) {
		writeLock.lock();
		try {
			V valV = null;
			if (cache.containsKey(key)) {
				valV = cache.remove(key);
				queue.remove(key);
			}

			return valV;

		} finally {
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {

	}

}
