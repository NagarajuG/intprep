package PreviousQuestions;

import java.util.HashMap;
import java.util.Map;

public class LoggerImplementation implements Logger {

	HashMap<String, LogEntry> map;

	public static class LogEntry {
		String processId;
		long sTime;
		long eTime;

		LogEntry(String id, long st, long et) {
			processId = id;
			sTime = st;
			eTime = et;
		}
	}

	public static void main(String[] args) {
		LoggerImplementation log = new LoggerImplementation();
		log.map = new HashMap<String, LogEntry>();

		log.start("1", 100);
		log.start("2", 101);
		log.end("2", 102);
		log.start("3", 103);
		log.end("1", 104);
		log.end("3", 105);
		log.print();

	}

	@Override
	public void start(String processId, long startTime) {
		if (this.map.containsKey(processId)) {
			LogEntry le = this.map.get(processId);
			le.sTime = startTime;
			this.map.put(processId, le);

		} else {
			LogEntry le = new LogEntry(processId, startTime, 0);
			this.map.put(processId, le);
		}

	}

	@Override
	public void end(String processId, long endTime) {
		if (this.map.containsKey(processId)) {
			LogEntry le = this.map.get(processId);
			le.eTime = endTime;
			this.map.put(processId, le);

		}

	}

	@Override
	public void print() {
		for (@SuppressWarnings("rawtypes")
		Map.Entry me : this.map.entrySet()) {
			LogEntry le = (LogEntry) me.getValue();
			System.out.println(
					"\nThe process... " + le.processId + "\tstatred at \t" + le.sTime + " \tEnded at \t" + le.eTime);

		}

	}

}
