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

	private static final Map<FileTail, FileMonitor> LISTENERS = new WeakHashMap<FileTail, FileMonitor>();


	/**
	 * @throws IOException
	 * 
	 */
	public static void register(final FileTail fileTail) throws IOException {
		if (LISTENERS.containsKey(fileTail)) {
			return;
		}

		FileMonitor fileMonitor = null;
		for (FileMonitor fm : LISTENERS.values()) {
			if (fm != null && fm.getFileName().equals(fileTail.getFileName())) {
				fileMonitor = fm;
				continue;
			}
		}

		if (fileMonitor == null) {
			fileMonitor = new FileMonitor(new File(fileTail.getFileName()));
			final Thread monitorThread = new Thread(fileMonitor, "FileMonitor(" + fileMonitor.getFileName() + ")");
			monitorThread.start();
		}

		fileMonitor.addListener(fileTail);
		LISTENERS.put(fileTail, fileMonitor);

	}


	public static void unregister(final FileTail fileTail) {
		if (LISTENERS.containsKey(fileTail)) {
			final FileMonitor fileMonitor = LISTENERS.get(fileTail);
			fileMonitor.removeListener(fileTail);
			LISTENERS.remove(fileTail);
		}
	}


	public static boolean isRegistered(final FileTail fileTail) {
		return LISTENERS.containsKey(fileTail);
	}

}
