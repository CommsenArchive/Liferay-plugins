/**
 * 
 */
package com.commsen.liferay.portlet.tailgate;

import java.io.File;
import java.io.IOException;

/**
 * @author Milen Dyankov
 * 
 */
public class TestFileTail {
	static boolean runnig = true;


	public static void main(String[] args) throws IOException {
		FileTail fileTail = new FileTail(new File("/tmp/buffer"), 100);
		fileTail.start();
		stopOnEnterKey();

		String line;
		while (true) {
			if (runnig) {
				while ((line = fileTail.readLine()) != null) {
					System.out.println("<li>" + line + "</li>");
				}
			} else {
				// if (fileTail != null) {
				// fileTail = null;
				// System.out.println("fileTail is now NULL !!!");
				// }
				if (fileTail.isRunnig()) {
					fileTail.stop();
					System.out.println("fileTail is now stopped !!!");
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// wake up
			}
		}

	}


	/**
     * 
     */
	private static void stopOnEnterKey() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				runnig = false;
			}
		});
		t.start();
	}

}
