import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws Exception {
		// URL u = new URL(
		// "ftp://jamescheung: @183.45.31.253/ftp/2013-04-22_22-22-59.dat");
		// URLConnection urlconn = u.openConnection();
		//
		// BufferedReader br = new BufferedReader(new InputStreamReader(
		// urlconn.getInputStream()));
		// char[] c = new char[4096];
		//
		// while (-1 != br.read(c)) {
		// System.out.println(c);
		// }
		String url1 = "ftp://jamescheung: @183.45.31.253/ftp/2013-04-22_22-22-59.dat";
		String url2 = "ftp://jamescheung: @183.45.31.253/ftp/2013-04-22_22-28-52.dat";
//		String url3 = "ftp://jamescheung: @183.45.31.253/ftp/2013-04-22_22-28-52.dat";
		
		List<Thread> l = new ArrayList<Thread>();
		for (int i = 0; i < 5; i++) {
			l.add(new Thread(new ReadFile(url1)));
//			l.add(new Thread(new ReadFile(url2)));
		}

		for (Thread t : l) {
			t.start();
		}
	}

}

class ReadFile implements Runnable {

	private String url;

	public ReadFile(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		try {
			Thread currentThread = Thread.currentThread();
			System.out.println("Thread start: " + currentThread.getId());
			URL u = new URL(url);
			URLConnection urlconn = u.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					urlconn.getInputStream()));
			char[] c = new char[4096];

			while (-1 != br.read(c)) {
				// System.out.println(c);
			}
			System.out.println("Thread end: " + currentThread.getId());
		} catch (Exception e) {
			System.out.println("Thread exception: "
					+ Thread.currentThread().getId());
			e.printStackTrace();
		}
	}
}
