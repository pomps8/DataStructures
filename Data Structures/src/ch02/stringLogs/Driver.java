package ch02.stringLogs;

public class Driver {

	public static void main(String[] args) {
		LinkedStringLog myLog = new LinkedStringLog("Testing 1");
		myLog.insert("Hi");
		myLog.insert("Anthony");
		System.out.println(myLog.toString());

	}

}
