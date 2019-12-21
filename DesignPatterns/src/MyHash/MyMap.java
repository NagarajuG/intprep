package MyHash;

public class MyMap<K, V> {

	private Entry<K, V>[] buckets;
	private static final int bucketSize = 16;

	public MyMap(int capacity) {
		this.buckets = new Entry[capacity];
	}

	public void put(K key, V val) {
		Entry<K, V> entry = new Entry<>(key, val, null);

		int bucket = entry.hashCode() % bucketSize;

		Entry<K, V> existing = this.buckets[bucket];

		if (existing == null) {
			this.buckets[bucket] = entry;
		} else {
			while (existing.next != null) {
				if (existing.key == entry.key) {
					existing.val = entry.val;
					return;
				}
				existing = existing.next;
			}

			if (existing.key.equals(key)) {
				existing.val = val;
			} else {
				existing.next = entry;
			}
		}

	}

	public V get(K key) {
		Entry<K, V> element = new Entry<>(key, null, null);

		Entry<K, V> entry = buckets[element.hashCode() % bucketSize];

		while (entry != null) {
			if (entry.key.equals(key)) {
				return entry.val;
			}
			entry = entry.next;
		}

		return null;

	}

	public static void main(String[] args) {
		MyMap<String, String> myMap = new MyMap<String, String>(16);
		myMap.put("Hi", "123");
		myMap.put("hello", "456");
		myMap.put("Hi", "Raju");

		System.out.println(myMap.get("Hi"));

		System.out.println(myMap.get("hello"));

	}
}
