/**
 * 
 */
package com.commsen.liferay.portlet.tailgate;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Milen Dyankov
 * 
 */
public class FileTail {

	private final File file;
	private final int lines;
	private Queue<String> buffer = new LinkedList<String>();


	public FileTail(final File file, final int lines) {
		this.file = file;
		this.lines = lines;
	}


	/**
	 * @return the fileName
	 * @throws IOException
	 */
	public String getFileName() throws IOException {
		return this.file.getCanonicalPath();
	}


	/**
	 * @return the lines
	 */
	public int getLines() {
		return this.lines;
	}


	/**
     * 
     */
	public String readLine() {
		synchronized (buffer) {
			return buffer.poll();
		}
	}


	public void start() throws IOException {
		FileMonitoringEngine.register(this);
	}


	public void stop() {
		FileMonitoringEngine.unregister(this);
	}


	public boolean isRunnig() {
		return FileMonitoringEngine.isRegistered(this);
	}


	/**
     * 
     */
	boolean addLine(final String line) {
		boolean result;
		synchronized (buffer) {
			result = buffer.add(line);
			if (buffer.size() > lines) {
				buffer.remove();
			}
		}
		return result;
	}

}
