/**
 * 
 */
package com.commsen.file.monitor;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author Milen Dyankov
 * 
 */
public class FileTail implements FileObserver, FileBuffer {

	private final String fileName;
	private final int maxSize;
	private Queue<String> buffer = new LinkedList<String>();


	public FileTail(final String fileName, final int maxSize) throws IOException {
		this.fileName = new File(fileName).getCanonicalPath();
		this.maxSize = maxSize;
	}


	/**
	 * @return the fileName
	 * @throws IOException
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @see com.commsen.file.monitor.FileBuffer#getMaxSize()
	 */
	public int getMaxSize() {
		return this.maxSize;
	}


	/**
	 * @see com.commsen.file.monitor.FileBuffer#getSize()
	 */
	public int getSize() {
		return this.buffer.size();
	}


	/**
	 * @see com.commsen.file.monitor.FileBuffer#readLine()
	 */
	public String readLine() {
		synchronized (buffer) {
			return buffer.poll();
		}
	}


	/*
	 * (non-Javadoc)
	 * @see com.commsen.liferay.portlet.tailgate.FileBuffer#start()
	 */
	public void setEnabled(boolean enabled) {
		if (enabled) {
			FileMonitoringEngine.register(this);
		} else {
			FileMonitoringEngine.unregister(this);
		}
	}


	/*
	 * (non-Javadoc)
	 * @see com.commsen.liferay.portlet.tailgate.FileBuffer#isRunnig()
	 */
	public boolean isEnabled() {
		return FileMonitoringEngine.isRegistered(this);
	}


	/*
	 * (non-Javadoc)
	 * @see com.commsen.liferay.portlet.tailgate.FileObserver#addLine(java.lang.String)
	 */
	public boolean addLine(final String line) {
		boolean result;
		synchronized (buffer) {
			result = buffer.add(line);
			if (buffer.size() > maxSize) {
				buffer.remove();
			}
		}
		return result;
	}

}
