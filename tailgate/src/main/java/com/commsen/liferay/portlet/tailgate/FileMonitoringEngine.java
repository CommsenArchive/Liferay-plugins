/**
 * 
 */
package com.commsen.liferay.portlet.tailgate;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Milen Dyankov
 * 
 */
public class FileMonitoringEngine {

	private static final Map<FileTail, FileMonitor> listeners = new WeakHashMap<FileTail, FileMonitor>();


	/**
	 * @throws IOException
	 * 
	 */
	public static void register(FileTail fileTail) throws IOException {
		if (listeners.containsKey(fileTail)) return;

		FileMonitor fileMonitor = null;
		for (FileMonitor fm : listeners.values()) {
			if (fm != null && fm.getFileName().equals(fileTail.getFileName())) {
				fileMonitor = fm;
				continue;
			}
		}

		if (fileMonitor == null) {
			fileMonitor = new FileMonitor(new File(fileTail.getFileName()));
			Thread t = new Thread(fileMonitor, "FileMonitor(" + fileMonitor.getFileName() + ")");
			t.start();
		}

		fileMonitor.addListener(fileTail);
		listeners.put(fileTail, fileMonitor);

	}


	public static void unregister(FileTail fileTail) {
		if (listeners.containsKey(fileTail)) {
			FileMonitor fileMonitor = listeners.get(fileTail);
			fileMonitor.removeListener(fileTail);
			listeners.remove(fileTail);
		}
	}


	public static boolean isRegistered(FileTail fileTail) {
		return listeners.containsKey(fileTail);
	}

}
