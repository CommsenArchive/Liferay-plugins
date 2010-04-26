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

	/**
	 * @return the position
	 */
	private long getPosition() {
		return this.position;
	}


	/**
	 * @param position the position to set
	 */
	private void setPosition(final long position) {
		this.position = position;
	}

	private final Set<FileTail> listeners = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<FileTail, Boolean>()));
	private final File file;
	private long position = 0;


	/**
	 * @return the file
	 * @throws IOException
	 */
	public String getFileName() throws IOException {
		return this.file.getCanonicalPath();
	}


	void addListener(final FileTail fileTail) {
		listeners.add(fileTail);
	}


	void removeListener(final FileTail fileTail) {
		listeners.remove(fileTail);
	}


	/**
     * 
     */
	FileMonitor(final File file) {
		// TODO check if it's directory
		this.file = file;
	}


	private void sleep(final long ms) {
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
		if (file.length() > getPosition()) {
			final RandomAccessFile raf = new RandomAccessFile(file, "r");
			raf.seek(position);
			String line;
			while ((line = raf.readLine()) != null) {
				for (FileTail fileTail : listeners) {
					if (fileTail != null) {
						fileTail.addLine(line);
					}
				}
			}
			setPosition(raf.length());
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
}
