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

import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Logger;

/**
 * @author Milen Dyankov
 * 
 */
public class FileMonitoringEngine {

	Logger log = Logger.getLogger(FileMonitoringEngine.class.getName());

	private static final Map<FileObserver, FileMonitor> FILE_BUFFERS = new WeakHashMap<FileObserver, FileMonitor>();


	public static FileBuffer newFileBuffer(String fileName, int maxSize) throws IOException {
		FileTail fileTail = new FileTail(fileName, maxSize);
		register(fileTail);
		return fileTail;
	}


	/**
	 * @throws IOException
	 * 
	 */
	public static void register(final FileObserver fileObserver) {
		if (FILE_BUFFERS.containsKey(fileObserver)) {
			return;
		}

		FileMonitor fileMonitor = null;
		for (FileMonitor fm : FILE_BUFFERS.values()) {
			if (fm != null && fm.getFileName().equals(fileObserver.getFileName())) {
				fileMonitor = fm;
				continue;
			}
		}

		if (fileMonitor == null) {
			fileMonitor = new FileMonitor(fileObserver.getFileName());
			final Thread monitorThread = new Thread(fileMonitor, "FileMonitor(" + fileMonitor.getFileName() + ")");
			monitorThread.start();
		}

		fileMonitor.addObserver(fileObserver);
		FILE_BUFFERS.put(fileObserver, fileMonitor);

	}


	public static void unregister(final FileObserver fileObserver) {
		if (FILE_BUFFERS.containsKey(fileObserver)) {
			final FileMonitor fileMonitor = FILE_BUFFERS.get(fileObserver);
			fileMonitor.removeObserver(fileObserver);
			FILE_BUFFERS.remove(fileObserver);
		}
	}


	public static boolean isRegistered(final FileObserver fileTail) {
		return FILE_BUFFERS.containsKey(fileTail);
	}

}
