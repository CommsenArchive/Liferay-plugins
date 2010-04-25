/**
 * 
 */
package com.commsen.liferay.portlet.tailgate;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * @author Milen Dyankov
 * 
 */
public class FileMonitor implements Runnable {

	// private Set<WeakReference<FileTail>> listeners = Collections.synchronizedSet(new
	// HashSet<WeakReference<FileTail>>());
	private Set<FileTail> listeners = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<FileTail, Boolean>()));
	private File file;
	private long position = 0;


	/**
	 * @return the file
	 * @throws IOException
	 */
	String getFileName() throws IOException {
		return this.file.getCanonicalPath();
	}


	void addListener(FileTail fileTail) {
		listeners.add(fileTail);
	}


	void removeListener(FileTail fileTail) {
		listeners.remove(fileTail);
	}


	/**
     * 
     */
	FileMonitor(File file) {
		// TODO check if it's directory
		this.file = file;
	}


	private void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// wake up
		}
	}


	private boolean haveListeners() {
		if (listeners == null) return false;
		for (FileTail failTail : listeners) {
			if (failTail != null) return true;
		}
		return false;
	}


	private void readAndUpdateListeners() throws IOException {
		if (file.length() > position) {
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			raf.seek(position);
			String line;
			while ((line = raf.readLine()) != null) {
				for (FileTail fileTail : listeners) {
					if (fileTail != null) {
						fileTail.addLine(line);
					}
				}
			}
			position = raf.length();
		}
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (!file.exists() && haveListeners()) {
			sleep(100);
		}

		while (haveListeners()) {
			try {
				readAndUpdateListeners();
				sleep(100);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static FileMonitor register(FileTail fileTail) {
		return null;
	}

}
