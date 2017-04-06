package singleton.notthreadsafe;

public class Creator implements Runnable {

	private int id;

	public Creator(int id) {
		this.id = id;
	}

	public void run() {
		try {
			Thread.sleep(200L);
		} catch (Exception e) {
		}
		Singleton s = Singleton.getInstance();
		System.out.println("s[" + id + "] = " + s);
	}

	public static void main(String[] args) {
		Thread[] creators = new Thread[10];
		for (int i = 0; i < 10; i++) {
			creators[i] = new Thread(new Creator(i));
		}
		for (Thread t : creators) {
			t.start();
		}
	}
}
