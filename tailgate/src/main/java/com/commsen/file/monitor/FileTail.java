/**
 *	This file is part of Tailgate Liferay plug-in.
 *	
 * Tailgate Liferay plug-in is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Tailgate Liferay plug-in is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Tailgate Liferay plug-in.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
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
